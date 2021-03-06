package org.apache.ctakes.cancer.ae.temporal;

import org.apache.ctakes.core.pipeline.PipeBitInfo;
import org.apache.ctakes.core.util.textspan.DefaultTextSpan;
import org.apache.ctakes.core.util.textspan.TextSpan;
import org.apache.ctakes.typesystem.type.refsem.Event;
import org.apache.ctakes.typesystem.type.refsem.EventProperties;
import org.apache.ctakes.typesystem.type.textsem.EventMention;
import org.apache.log4j.Logger;
import org.apache.uima.UimaContext;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.component.JCasAnnotator_ImplBase;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.function.Consumer;


/**
 * @author SPF , chip-nlp
 * @version %I%
 * @since 8/23/2017
 */
@PipeBitInfo(
      name = "Doubled Event Remover",
      description = "Removes EventMentions that overlap Symptoms, Procedures, Medications, and Disorders.",
      dependencies = PipeBitInfo.TypeProduct.EVENT,
      role = PipeBitInfo.Role.ANNOTATOR
)
@Deprecated
final public class DoubledEventRemover extends JCasAnnotator_ImplBase {

   static private final Logger LOGGER = Logger.getLogger( "DoubledEventRemover" );

   // TODO Move to ctakes !!!  Check HtmlWriter and extract best / most exact

   /**
    * {@inheritDoc}
    */
   @Override
   public void initialize( final UimaContext context ) throws ResourceInitializationException {
      // Always call the super first
      super.initialize( context );

      // place AE initialization code here

   }

   /**
    * {@inheritDoc}
    */
   @Override
   public void process( final JCas jCas ) throws AnalysisEngineProcessException {
      LOGGER.info( "Removing overlapped Events ..." );

      final Collection<EventMention> pureEvents = new ArrayList<>();
      final Collection<EventMention> highEvents = new ArrayList<>();
      final Consumer<EventMention> splitEvents = e -> {
         if ( e.getClass().equals( EventMention.class ) ) {
            pureEvents.add( e );
         } else {
            highEvents.add( e );
         }
      };
      JCasUtil.select( jCas, EventMention.class ).forEach( splitEvents );

      final Collection<EventMention> removals = new HashSet<>();
      for ( EventMention high : highEvents ) {
         final TextSpan highSpan = new DefaultTextSpan( high, 0 );
         for ( EventMention pure : pureEvents ) {
            final TextSpan pureSpan = new DefaultTextSpan( pure, 0 );
            if ( highSpan.overlaps( pureSpan ) ) {
               copyProperties( high, pure );
               removals.add( pure );
            }
         }
      }
      removals.forEach( jCas::removeFsFromIndexes );
      LOGGER.info( "Finished." );
   }

   // TODO Copy Relations
   static private void copyProperties( final EventMention highEvent, final EventMention pureEvent ) {
      final Event event = pureEvent.getEvent();
      if ( event == null ) {
         return;
      }
      final Event old = highEvent.getEvent();
      highEvent.setEvent( event );
      // cleanup references to old event
      if ( old != null ) {
         final EventProperties props = old.getProperties();
         old.removeFromIndexes();
         if ( props != null ) {
            props.removeFromIndexes();
         }
      }
   }


}

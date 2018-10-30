package org.healthnlp.deepphe.neo4j;

import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.RelationshipType;

/**
 * @author SPF , chip-nlp
 * @version %I%
 * @since 8/22/2018
 */
final public class Neo4jConstants {

   private Neo4jConstants() {
   }

   static public final String NAME_KEY = "name";
   static public final String PREF_TEXT_KEY = "preferred_text";
   static public final String CUI_KEY = "cui";

   static public final String MISSING_NODE_NAME = "MissingNodeName";

   static public final String NAME_INDEX = NAME_KEY + "_index";

   static public final String IS_A_PROP = "Is_A";

   static public final String DPHE_CODING_SCHEME = "DPHE_URI";
   static public final String DPHE_DOMAIN = "http://cancer.healthnlp.org/DeepPhe.owl";


   static public final Label CLASS_LABEL = Label.label( "Class" );
   static public final Label OBJECT_LABEL = Label.label( "Object" );
   static public final Label SUBJECT_LABEL = Label.label( "Subject" );
   static public final Label FINDING_LABEL = Label.label( "Finding" );


   static public final String SUBJECT_URI = "Subject";
   static public final String PATIENT_URI = "Patient";

   static public final String EMR_NOTE_URI = "EMR_Note";
   static public final String GENERIC_NOTE_URI = "Generic_Note";
   static public final String PATHOLOGY_NOTE_URI = "Pathology_Note";
   static public final String DISCHARGE_NOTE_URI = "Discharge_Note";
   static public final String PROGRESS_NOTE_URI = "Progress_Note";
   static public final String RADIOLOGY_NOTE_URI = "Radiology_Note";

   static public final String SUMMARY_URI = "Summary";
   static public final String CANCER_SUMMARY_URI = "Cancer_Summary";
   static public final String TUMOR_SUMMARY_URI = "Tumor_Summary";

   static public final String FACT_URI = "Fact";

   static public final String SOURCE_DATUM_URI = "Source_Datum";
   static public final String STRUCTURED_ENTRY_URI = "Structured_Entry";
   static public final String TEXT_MENTION_URI = "Text_Mention";

   static public final String PATIENT_NAME = "Patient_Name";
   static public final String PATIENT_GENDER = "Patient_Gender";
   static public final String PATIENT_BIRTH_DATE = "Patient_Birth_Date";
   static public final String PATIENT_DEATH_DATE = "Patient_Death_Date";
   static public final String PATIENT_FIRST_ENCOUNTER = "Patient_First_Encounter";
   static public final String PATIENT_LAST_ENCOUNTER = "Patient_Last_Encounter";

   static public final String NOTE_NAME = "Note_Name";
   static public final String NOTE_TEXT = "Note_Text";
   static public final String NOTE_DATE = "Note_Date";
   static public final String NOTE_EPISODE = "Note_Episode";

   static public final String VALUE_TEXT = "Value_Text";
   static public final String TEXT_SPAN_BEGIN = "Text_Span_Begin";
   static public final String TEXT_SPAN_END = "Text_Span_End";


   // Use relation other than "Is_A" to make traversal faster.
   static public final String INSTANCE_OF = "Instance_Of";
   static public final String SUBJECT_HAS_NOTE = "Subject_Has_Note";
   static public final String SUBJECT_HAS_CANCER = "Subject_Has_Cancer";
   static public final String CANCER_HAS_TUMOR = "Cancer_Has_Tumor";
   static public final String CANCER_HAS_FACT = "Cancer_Has_Fact";
   static public final String TUMOR_HAS_FACT = "Tumor_Has_Fact";
   static public final String FACT_HAS_STRUCTURED_ENTRY = "Fact_Has_Structured_Entry";
   static public final String FACT_HAS_TEXT_MENTION = "Fact_Has_Text_Mention";
   static public final String NOTE_HAS_TEXT_MENTION = "Note_Has_Text_Mention";
   static public final String FACT_HAS_RELATED_FACT = "Fact_Has_Related_Fact";

   static public final RelationshipType IS_A_RELATION = RelationshipType.withName( IS_A_PROP );
   static public final RelationshipType INSTANCE_OF_RELATION = RelationshipType.withName( INSTANCE_OF );
   static public final RelationshipType SUBJECT_HAS_NOTE_RELATION = RelationshipType.withName( SUBJECT_HAS_NOTE );
   static public final RelationshipType SUBJECT_HAS_CANCER_RELATION = RelationshipType.withName( SUBJECT_HAS_CANCER );
   static public final RelationshipType CANCER_HAS_TUMOR_RELATION = RelationshipType.withName( CANCER_HAS_TUMOR );
   static public final RelationshipType CANCER_HAS_FACT_RELATION = RelationshipType.withName( CANCER_HAS_FACT );
   static public final RelationshipType TUMOR_HAS_FACT_RELATION = RelationshipType.withName( TUMOR_HAS_FACT );
   static public final RelationshipType NOTE_HAS_TEXT_MENTION_RELATION
         = RelationshipType.withName( NOTE_HAS_TEXT_MENTION );
   static public final RelationshipType FACT_HAS_TEXT_MENTION_RELATION
         = RelationshipType.withName( FACT_HAS_TEXT_MENTION );
   static public final RelationshipType FACT_HAS_RELATED_FACT_RELATION
         = RelationshipType.withName( FACT_HAS_RELATED_FACT );

   static public final String FACT_RELATION_TYPE = "Fact_Relation_Type";
   static public final String SUMMARY_FACT_RELATION_TYPE = "Summary_Fact_Relation_Type";



}
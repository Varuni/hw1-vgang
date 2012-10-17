

/* First created by JCasGen Sun Oct 14 11:46:20 EDT 2012 */
package edu.cmu.hw1.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Mon Oct 15 20:26:22 EDT 2012
 * XML source: /home/varuni/11791/hw1-vgang_old/src/main/resources/GeneAnnotator.xml
 * @generated */
public class Genemarker extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Genemarker.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated  */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected Genemarker() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Genemarker(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Genemarker(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public Genemarker(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: geneId

  /** getter for geneId - gets 
   * @generated */
  public String getGeneId() {
    if (Genemarker_Type.featOkTst && ((Genemarker_Type)jcasType).casFeat_geneId == null)
      jcasType.jcas.throwFeatMissing("geneId", "edu.cmu.hw1.types.Genemarker");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Genemarker_Type)jcasType).casFeatCode_geneId);}
    
  /** setter for geneId - sets  
   * @generated */
  public void setGeneId(String v) {
    if (Genemarker_Type.featOkTst && ((Genemarker_Type)jcasType).casFeat_geneId == null)
      jcasType.jcas.throwFeatMissing("geneId", "edu.cmu.hw1.types.Genemarker");
    jcasType.ll_cas.ll_setStringValue(addr, ((Genemarker_Type)jcasType).casFeatCode_geneId, v);}    
   
    
  //*--------------*
  //* Feature: geneName

  /** getter for geneName - gets 
   * @generated */
  public String getGeneName() {
    if (Genemarker_Type.featOkTst && ((Genemarker_Type)jcasType).casFeat_geneName == null)
      jcasType.jcas.throwFeatMissing("geneName", "edu.cmu.hw1.types.Genemarker");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Genemarker_Type)jcasType).casFeatCode_geneName);}
    
  /** setter for geneName - sets  
   * @generated */
  public void setGeneName(String v) {
    if (Genemarker_Type.featOkTst && ((Genemarker_Type)jcasType).casFeat_geneName == null)
      jcasType.jcas.throwFeatMissing("geneName", "edu.cmu.hw1.types.Genemarker");
    jcasType.ll_cas.ll_setStringValue(addr, ((Genemarker_Type)jcasType).casFeatCode_geneName, v);}    
  }

    
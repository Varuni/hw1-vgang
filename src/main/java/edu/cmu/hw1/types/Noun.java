

/* First created by JCasGen Sun Oct 14 15:39:26 EDT 2012 */
package edu.cmu.hw1.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.tcas.Annotation;


/** 
 * Updated by JCasGen Sun Oct 14 15:39:26 EDT 2012
 * XML source: /home/varuni/11791/hw1-vgang/src/main/resources/typeSystemDescriptor.xml
 * @generated */
public class Noun extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Noun.class);
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
  protected Noun() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Noun(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Noun(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public Noun(JCas jcas, int begin, int end) {
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
  //* Feature: NounId

  /** getter for NounId - gets 
   * @generated */
  public String getNounId() {
    if (Noun_Type.featOkTst && ((Noun_Type)jcasType).casFeat_NounId == null)
      jcasType.jcas.throwFeatMissing("NounId", "edu.cmu.hw1.types.Noun");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Noun_Type)jcasType).casFeatCode_NounId);}
    
  /** setter for NounId - sets  
   * @generated */
  public void setNounId(String v) {
    if (Noun_Type.featOkTst && ((Noun_Type)jcasType).casFeat_NounId == null)
      jcasType.jcas.throwFeatMissing("NounId", "edu.cmu.hw1.types.Noun");
    jcasType.ll_cas.ll_setStringValue(addr, ((Noun_Type)jcasType).casFeatCode_NounId, v);}    
  }

    
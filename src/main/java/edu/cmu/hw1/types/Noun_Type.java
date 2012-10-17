
/* First created by JCasGen Sun Oct 14 15:39:26 EDT 2012 */
package edu.cmu.hw1.types;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;
import org.apache.uima.jcas.tcas.Annotation_Type;

/** 
 * Updated by JCasGen Wed Oct 17 11:24:23 EDT 2012
 * @generated */
public class Noun_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Noun_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Noun_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Noun(addr, Noun_Type.this);
  			   Noun_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Noun(addr, Noun_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Noun.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.hw1.types.Noun");
 
  /** @generated */
  final Feature casFeat_NounId;
  /** @generated */
  final int     casFeatCode_NounId;
  /** @generated */ 
  public String getNounId(int addr) {
        if (featOkTst && casFeat_NounId == null)
      jcas.throwFeatMissing("NounId", "edu.cmu.hw1.types.Noun");
    return ll_cas.ll_getStringValue(addr, casFeatCode_NounId);
  }
  /** @generated */    
  public void setNounId(int addr, String v) {
        if (featOkTst && casFeat_NounId == null)
      jcas.throwFeatMissing("NounId", "edu.cmu.hw1.types.Noun");
    ll_cas.ll_setStringValue(addr, casFeatCode_NounId, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public Noun_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_NounId = jcas.getRequiredFeatureDE(casType, "NounId", "uima.cas.String", featOkTst);
    casFeatCode_NounId  = (null == casFeat_NounId) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_NounId).getCode();

  }
}



    
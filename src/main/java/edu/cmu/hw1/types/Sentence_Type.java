
/* First created by JCasGen Sun Oct 14 01:47:54 EDT 2012 */
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
 * Updated by JCasGen Sun Oct 14 21:36:17 EDT 2012
 * @generated */
public class Sentence_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Sentence_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Sentence_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Sentence(addr, Sentence_Type.this);
  			   Sentence_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Sentence(addr, Sentence_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Sentence.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.hw1.types.Sentence");
 
  /** @generated */
  final Feature casFeat_SentenceId;
  /** @generated */
  final int     casFeatCode_SentenceId;
  /** @generated */ 
  public String getSentenceId(int addr) {
        if (featOkTst && casFeat_SentenceId == null)
      jcas.throwFeatMissing("SentenceId", "edu.cmu.hw1.types.Sentence");
    return ll_cas.ll_getStringValue(addr, casFeatCode_SentenceId);
  }
  /** @generated */    
  public void setSentenceId(int addr, String v) {
        if (featOkTst && casFeat_SentenceId == null)
      jcas.throwFeatMissing("SentenceId", "edu.cmu.hw1.types.Sentence");
    ll_cas.ll_setStringValue(addr, casFeatCode_SentenceId, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public Sentence_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_SentenceId = jcas.getRequiredFeatureDE(casType, "SentenceId", "uima.cas.String", featOkTst);
    casFeatCode_SentenceId  = (null == casFeat_SentenceId) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_SentenceId).getCode();

  }
}



    
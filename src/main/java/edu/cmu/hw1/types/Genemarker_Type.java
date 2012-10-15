
/* First created by JCasGen Sun Oct 14 11:46:20 EDT 2012 */
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
public class Genemarker_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Genemarker_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Genemarker_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Genemarker(addr, Genemarker_Type.this);
  			   Genemarker_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Genemarker(addr, Genemarker_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Genemarker.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.hw1.types.Genemarker");
 
  /** @generated */
  final Feature casFeat_geneId;
  /** @generated */
  final int     casFeatCode_geneId;
  /** @generated */ 
  public String getGeneId(int addr) {
        if (featOkTst && casFeat_geneId == null)
      jcas.throwFeatMissing("geneId", "edu.cmu.hw1.types.Genemarker");
    return ll_cas.ll_getStringValue(addr, casFeatCode_geneId);
  }
  /** @generated */    
  public void setGeneId(int addr, String v) {
        if (featOkTst && casFeat_geneId == null)
      jcas.throwFeatMissing("geneId", "edu.cmu.hw1.types.Genemarker");
    ll_cas.ll_setStringValue(addr, casFeatCode_geneId, v);}
    
  
 
  /** @generated */
  final Feature casFeat_geneName;
  /** @generated */
  final int     casFeatCode_geneName;
  /** @generated */ 
  public String getGeneName(int addr) {
        if (featOkTst && casFeat_geneName == null)
      jcas.throwFeatMissing("geneName", "edu.cmu.hw1.types.Genemarker");
    return ll_cas.ll_getStringValue(addr, casFeatCode_geneName);
  }
  /** @generated */    
  public void setGeneName(int addr, String v) {
        if (featOkTst && casFeat_geneName == null)
      jcas.throwFeatMissing("geneName", "edu.cmu.hw1.types.Genemarker");
    ll_cas.ll_setStringValue(addr, casFeatCode_geneName, v);}
    
  



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public Genemarker_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_geneId = jcas.getRequiredFeatureDE(casType, "geneId", "uima.cas.String", featOkTst);
    casFeatCode_geneId  = (null == casFeat_geneId) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_geneId).getCode();

 
    casFeat_geneName = jcas.getRequiredFeatureDE(casType, "geneName", "uima.cas.String", featOkTst);
    casFeatCode_geneName  = (null == casFeat_geneName) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_geneName).getCode();

  }
}



    
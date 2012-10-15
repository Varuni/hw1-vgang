import java.util.Iterator;
import java.util.Map;

import org.apache.uima.resource.ResourceInitializationException;


import edu.cmu.hw1.types.Noun;
import edu.cmu.hw1.types.Sentence;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.jcas.JCas;

public class PosTagAnnotator extends JCasAnnotator_ImplBase {
  
  public void process(JCas aJCas) {
    FSIndex SentenceIndex = aJCas.getAnnotationIndex(Sentence.type);
    Iterator SentenceIterator = SentenceIndex.iterator();
    while (SentenceIterator.hasNext()) {
      Sentence sequenceId = (Sentence)SentenceIterator.next();
      //String originalDocument=aJCas.getDocumentText();
      String sentenceText = aJCas.getDocumentText();
      // Splitting the sentence into token.
      PosTagNamedEntityRecognizer nounRecognizer;
    
      try {
        nounRecognizer = new PosTagNamedEntityRecognizer();
        Map<Integer,Integer> GeneMap=nounRecognizer.getGeneSpans(sentenceText.substring(sequenceId.getBegin(),sequenceId.getEnd()));
        Iterator<Integer> genemapIterator=GeneMap.keySet().iterator();
    
    while(genemapIterator.hasNext()){
      Integer positionfirst=genemapIterator.next();
      Integer positionlast=GeneMap.get(positionfirst);
      Noun nounAnnotation=new Noun(aJCas);
      nounAnnotation.setBegin(sequenceId.getBegin()+positionfirst);
      nounAnnotation.setEnd(sequenceId.getBegin()+positionlast);
      nounAnnotation.setNounId(sequenceId.getSentenceId());
      nounAnnotation.addToIndexes(); 
    } 

  }catch (ResourceInitializationException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
  
}
  
      }
}  
}
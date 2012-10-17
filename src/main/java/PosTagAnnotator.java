import java.util.Iterator;
import java.util.Map;

import org.apache.uima.resource.ResourceInitializationException;

import edu.cmu.hw1.types.Noun;
import edu.cmu.hw1.types.Sentence;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.jcas.JCas;

/**
 * This Annotator accessed the Sentence type systems from sequenceAnnotator providing the sequence.
 * It also accesses name entity recognition program based on Stanford CoreNLP tool for recognising
 * nouns from the sentence.
 * 
 * The noun entities as well as there begin and end positions are stored for further processing.
 * 
 * @author varuni
 * 
 */
public class PosTagAnnotator extends JCasAnnotator_ImplBase {

  public void process(JCas aJCas) {
    // calling Sentence annotator
    FSIndex SentenceIndex = aJCas.getAnnotationIndex(Sentence.type);
    Iterator SentenceIterator = SentenceIndex.iterator();
    // loop for each sentence
    while (SentenceIterator.hasNext()) {

      Sentence sequenceId = (Sentence) SentenceIterator.next();
      String sentenceText = aJCas.getDocumentText();
      // making an object of PosTagNamedEntityRecognizer "Stanford CoreNLP tool"
      PosTagNamedEntityRecognizer nounRecognizer;

      try {
        nounRecognizer = new PosTagNamedEntityRecognizer();
        Map<Integer, Integer> GeneMap = nounRecognizer.getGeneSpans(sentenceText.substring(sequenceId.getBegin(), sequenceId.getEnd()));
        Iterator<Integer> genemapIterator = GeneMap.keySet().iterator();

        while (genemapIterator.hasNext()) {
          Integer positionfirst = genemapIterator.next();
          Integer positionlast = GeneMap.get(positionfirst);
          Noun nounAnnotation = new Noun(aJCas);
          nounAnnotation.setBegin(sequenceId.getBegin() + positionfirst);
          nounAnnotation.setEnd(sequenceId.getBegin() + positionlast);
          nounAnnotation.setNounId(sequenceId.getSentenceId());
          nounAnnotation.addToIndexes();
        }
      } catch (ResourceInitializationException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }
}

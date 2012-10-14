import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
Package

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceProcessException;

import edu.cmu.hw1.types.Sentence;
import edu.cmu.hw1.types.Genemarker;


public class GeneAnnotator extends JCasAnnotator_ImplBase {

  public void process(JCas aJCas) throws AnalysisEngineProcessException {
      JCas jcas = aJCas;
    
      String sentenceIdentifier = "";
    String sentenceText = "";
    System.out.println("Annotating Genes");
    PosTagNamedEntityRecognizer Tagger = null;
    try {
      Tagger = new PosTagNamedEntityRecognizer();
    } catch (ResourceInitializationException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    

    // retrieve the filename of the input file from the CAS
    FSIterator it = jcas.getAnnotationIndex(Sentence.type).iterator();
    while (it.hasNext()) {
      System.out.println("Iterating through sentences");

      Sentence annotation = (Sentence) it.next();
      sentenceIdentifier = annotation.();
      sentenceText = annotation.getSentenceId();
      Map<Integer, Integer> occurences = Tagger.getGeneSpans(sentenceText);
      int begin;
      int end;
      
      for (Map.Entry<Integer, Integer> entry : occurences.entrySet())
      {
          System.out.println(entry.getKey() + "/" + entry.getValue());
          begin = entry.getKey();
          end = entry.getValue();
          GeneTag ann = new GeneTag(jcas);
          ann.setBegin(begin);
          ann.setEnd(end);
          ann.setIdentifier(sentenceIdentifier);
          ann.setName(sentenceText.substring(begin, end));
          ann.addToIndexes();
      }
  }
}

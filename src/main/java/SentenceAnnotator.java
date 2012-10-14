import java.util.Map;
import java.util.Iterator;
//import javax.swing.text.html.HTMLDocument.Iterator;

import edu.cmu.hw1.types.Sentence;
import edu.cmu.hw1.types.Noun;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;


public class SentenceAnnotator extends JCasAnnotator_ImplBase {
  
  
  private String SequenceId; 

  /**
   * @see JCasAnnotator_ImplBase#process(JCas)
   */
  public void process(JCas aJCas) {
    // get document text to Sequence.
      String SequenceText = aJCas.getDocumentText();
      String lines[] = SequenceText.split("\\r?\\n");
      int firstPosition = 0;
      PosTagNamedEntityRecognizer nounRecognizer;
      try {
        nounRecognizer = new PosTagNamedEntityRecognizer();
        
        System.out.println("Starting Annotation of text");
        for(int i=0;i<lines.length; i++){
        
        String[] token = lines[i].split(" "); // Splitting the sentence into token.
        SequenceId = token[0]; // Assigning the first token to sequence id.
        
        //Setting Beginning and last position
        int beginingPosition = token[0].length() + 1 + firstPosition ;  
        int lastPosition = lines[i].length() + firstPosition; 
        
        // Annotating each sentence
        Sentence annotation = new Sentence(aJCas);
        annotation.setBegin(beginingPosition);
        annotation.setEnd(lastPosition);
        annotation.setSentenceId(SequenceId);
        annotation.addToIndexes();
        
        firstPosition = firstPosition + lines[i].length()+1; // resetting first position for the next line
        
        Map<Integer,Integer> GeneMap=nounRecognizer.getGeneSpans(lines[i].substring(token[0].length()+1,lines[i].length()));
        Iterator<Integer> genemapIterator=GeneMap.keySet().iterator();
        
        while(genemapIterator.hasNext()){
          Integer positionfirst=genemapIterator.next();
          Integer positionlast=GeneMap.get(positionfirst);
          Noun nounAnnotation=new Noun(aJCas);
          nounAnnotation.setBegin(annotation.getBegin()+positionfirst);
          nounAnnotation.setEnd(annotation.getBegin()+positionlast);
          nounAnnotation.setNounId(SequenceId);
          nounAnnotation.addToIndexes(); 
        } 
        }
        }catch (ResourceInitializationException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        
    }
}
}
//import javax.swing.text.html.HTMLDocument.Iterator;

import edu.cmu.hw1.types.Sentence;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.jcas.JCas;

/**
 * This SentenceAnnotator java class processed the document step by step as : a) splitting the document
 * on every newline b) tokenising each line on the first white space c) storing the first token as
 * Sentence-Id and rest as the sequence
 * 
 * @author varuni
 * 
 */
public class SentenceAnnotator extends JCasAnnotator_ImplBase {

  private String SequenceId;

  public void process(JCas aJCas) {
    // get document text to Sequence.
    String SentenceText = aJCas.getDocumentText();
    String lines[] = SentenceText.split("\\r?\\n");
    int firstPosition = 0;
    System.out.println("Starting Annotation of text");
    for (int i = 0; i < lines.length; i++) {

      String[] token = lines[i].split(" "); // Splitting the sentence into token.
      SequenceId = token[0]; // Assigning the first token to sequence id.

      // Setting Beginning and last position
      int beginingPosition = token[0].length() + 1 + firstPosition;
      int lastPosition = lines[i].length() + firstPosition;

      // Annotating each sentence
      Sentence annotation = new Sentence(aJCas);
      annotation.setBegin(beginingPosition);
      annotation.setEnd(lastPosition);
      annotation.setSentenceId(SequenceId);
      annotation.addToIndexes();

      firstPosition = firstPosition + lines[i].length() + 1; // resetting first position for the
                                                             // next line iteration

    }

  }
}
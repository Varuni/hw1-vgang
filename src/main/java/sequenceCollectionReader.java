import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.collection.CollectionException;
import org.apache.uima.collection.CollectionReader_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.Progress;

/**
 * This collection reader takes the file “sample.in” as input and reads it line by line and uses
 * getnext method to generate cas. These cas are further passed to the annotators for annotations.
 * 
 * @author varuni
 * 
 */
public class sequenceCollectionReader extends CollectionReader_ImplBase {

  private BufferedReader br;

  private int read = 1;

  String cas = "";

  public void initialize() throws ResourceInitializationException {
    String input = (String) getConfigParameterValue("INPUT_FILE");
    System.out.println(input);
    FileReader file;
    System.out.println("Initializing Collection Reader");
    try {
      file = new FileReader(input);
      br = new BufferedReader(file);

      char myBuffer[] = new char[4096];
      while ((br.read(myBuffer)) != -1) {
        cas += new String(myBuffer);
        myBuffer = null;
        myBuffer = new char[4096];
      }

      br.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void getNext(CAS aCAS) throws IOException, CollectionException {
    System.out.println("Collection Reader:getNext");
    JCas jcas;
    try {
      jcas = aCAS.getJCas();
    } catch (CASException e) {
      throw new CollectionException(e);
    }
    jcas.setDocumentText(cas);
    read = 0;
  }

  @Override
  public void close() throws IOException {
    br.close();
  }

  @Override
  public Progress[] getProgress() {

    return null;
  }

  @Override
  public boolean hasNext() throws IOException, CollectionException {
    System.out.println("Collection Reader:hasNext");
    if (read == 1)
      return true;
    return false;
  }

}

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


public class sequenceCollectionReader extends CollectionReader_ImplBase {

  private String nextSentence;
  private BufferedReader in;
  private int read = 1;
  String cas = "";
  public void initialize() throws ResourceInitializationException {
    String input = (String) getConfigParameterValue("INPUT_FILE");
    FileReader file;
    System.out.println("Initializing Collection Reader");
    try {
      file = new FileReader(input);
      in = new BufferedReader(file);
      System.out.println(input);
       int i=0;
       char chars[]=new char[4096];
      while( (in.read(chars))!=-1 ){
        //System.out.println("Collection Reader: reading line by line");
        //System.out.println(nextSentence);
        cas+=new String(chars);
        //cas = cas + "\n" + nextSentence;
        chars=null;
        chars=new char[4096];
      }
      in.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  
  @Override
  public void getNext(CAS aCAS) throws IOException, CollectionException {
    // TODO Auto-generated method stub
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
    // TODO Auto-generated method stub
    in.close();
  }

  @Override
  public Progress[] getProgress() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean hasNext() throws IOException, CollectionException {
    // TODO Auto-generated method stub
    System.out.println("Collection Reader:hasNext");
    if(read == 1) return true;
    return false;
  }

}

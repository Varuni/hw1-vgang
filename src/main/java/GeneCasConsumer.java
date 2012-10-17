import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.collection.CasConsumer_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceProcessException;
import org.xml.sax.SAXException;

import edu.cmu.hw1.types.Genemarker;

public class GeneCasConsumer extends CasConsumer_ImplBase {

  int docNum;
  File out = null;
  BufferedWriter bw = null;

  @Override
  public void initialize() {

    docNum = 0;
    try {
    //out = new File((String) getConfigParameterValue("OUTPUT_FILE"));
    out = new File("/home/varuni/11791/hw1-vgang_old/src/main/resources/data/test.out");
    bw = new BufferedWriter(new FileWriter(out));
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  @Override
  public void processCas(CAS aCAS) throws ResourceProcessException {

    JCas jcas;
    try {
      jcas = aCAS.getJCas();
    } catch (CASException e) {
      throw new ResourceProcessException(e);
    }

    // retrieve the filename of the input file from the CAS
    FSIterator it = jcas.getAnnotationIndex(Genemarker.type).iterator();
    System.out.println("Consuming CAS");
    String geneIdentifier = "";
    String geneName = "";
    int start = -1;
    int end = -1;
    while (it.hasNext()) {
      Genemarker annotation = (Genemarker) it.next();
      geneIdentifier = annotation.getGeneId();
      geneName = annotation.getGeneName();      
      start = annotation.getBegin();
      end = annotation.getEnd();  

    // write to output file
    try {
      writeIntoFile(geneIdentifier, geneName, start, end);
    } catch (IOException e) {
      throw new ResourceProcessException(e);
    } catch (SAXException e) {
      throw new ResourceProcessException(e);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    }
  }

  public void writeIntoFile(String geneIdentifier, String geneName, int start, int end)
      throws Exception {
    bw.write(geneIdentifier + "|" + start + " " + end + "|" + geneName);
    bw.newLine();
    bw.flush();
  }

  @Override
  public void destroy() {

    try {
      if (bw != null) {
        bw.close();
        bw = null;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

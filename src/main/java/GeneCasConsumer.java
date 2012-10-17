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

  File output = null;
  BufferedWriter writer = null;

  @Override
  public void initialize() {

    try {
    output = new File("/home/varuni/11791/hw1-vgang_old/src/main/resources/data/test.out");
    writer = new BufferedWriter(new FileWriter(output));
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
    System.out.println("writting cas to the file");
    String geneId, geneName;
    int positionfirst, positionlast;
    positionfirst = positionlast = -1;
    while (it.hasNext()) {
      Genemarker annotation = (Genemarker) it.next();
      geneId = annotation.getGeneId();
      geneName = annotation.getGeneName();      
      positionfirst = annotation.getBegin();
      positionlast = annotation.getEnd();  

    // write to output file
    try {
      writeIntoFile(geneId, geneName, positionfirst, positionlast);
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

  public void writeIntoFile(String geneId, String geneName, int positionfirst, int positionlast)
      throws Exception {
    writer.write(geneId + "|" + positionfirst + " " + positionlast + "|" + geneName);
    writer.newLine();
    writer.flush();
  }

  @Override
  public void destroy() {

    try {
      if (writer != null) {
        writer.close();
        writer = null;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

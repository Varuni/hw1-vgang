import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import edu.cmu.hw1.types.Genemarker;
import edu.cmu.hw1.types.Noun;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.jcas.JCas;

public class GeneAnnotator extends JCasAnnotator_ImplBase {

  @Override
  public void process(JCas aJCas) {
    // TODO Auto-generated method stub
    FSIndex NounIndex = aJCas.getAnnotationIndex(Noun.type);
    Iterator NounIterator = NounIndex.iterator();
    
    BufferedReader file = null;
    final int max = 100000;
    //retrieving file names 
    ArrayList<String> list = new ArrayList<String>(max);
    String line;
    try {
      file=new BufferedReader(new FileReader("/home/varuni/11791/hw1-vgang_old/genenames.in"));
      try {
        while(file.readLine() != null){
          line = file.readLine();
          list.add(line);
        }
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    
      ////////////////////////
      while (NounIterator.hasNext()) {
        Noun nounId = (Noun)NounIterator.next();
        String nounText = aJCas.getDocumentText().substring(nounId.getBegin(), nounId.getEnd());
          
        if(list.contains(nounText)){
          Integer positionfirst=nounId.getBegin();
          Integer positionlast=nounId.getEnd();
          Genemarker geneAnnotation=new Genemarker(aJCas);
          geneAnnotation.setBegin(positionfirst);
          geneAnnotation.setEnd(positionlast);
          geneAnnotation.setGeneId(nounId.getNounId());
          geneAnnotation.setGeneName(nounText);
          geneAnnotation.addToIndexes(); 
        
        }
      }
    }catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
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

/**
 * This Annotator accessed the Noun type systems from PosTagAnnotator providing the nouns. The file
 * contains the gene names extracted from NCBI database ( manages GenBank DNA sequence database)
 * 
 * The database contains gene data from individual laboratories, international nucleotide sequence
 * databases, European Molecular Biology Laboratory (EMBL) and the DNA Database of Japan (DDBJ).
 * 
 * GeneAnnotator uses the genenames.in file for checking the gene names with the nouns. Steps: a)
 * Forms an Arraylist for storing the names of the genes in a list b) Compares each file name with
 * the noun phrases accessed through PosTagAnnotator type systems c) stores for each gene its gene
 * name as geneName, sentence id as geneId and its beginning and end position in the sentence
 * 
 * @author varuni
 * 
 */
public class GeneAnnotator extends JCasAnnotator_ImplBase {

  @Override
  public void process(JCas aJCas) {
    
    FSIndex NounIndex = aJCas.getAnnotationIndex(Noun.type);
    Iterator NounIterator = NounIndex.iterator();

    BufferedReader file = null;
    final int max = 100000;
    // retrieving gene names
    ArrayList<String> list = new ArrayList<String>(max);
    String line;
    try {
      System.out.println("Completed Implementation of Stanford CoreNLP tool for recognising nouns from the sentences");
      System.out.println("Now comapring with international nucleotide sequence databases for gene name annotation: Please wait");
      file = new BufferedReader(new FileReader("data/genenames.in"));
      try {
        while (file.readLine() != null) {
          line = file.readLine();
          if (line != null) {
            list.add(line.toUpperCase());
          }
        }
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

      while (NounIterator.hasNext()) {
        Noun nounId = (Noun) NounIterator.next();
        String nounText = aJCas.getDocumentText().substring(nounId.getBegin(), nounId.getEnd());

        if (nounText != null) {
          if (list.contains(nounText.toUpperCase())) {
            Integer positionfirst = nounId.getBegin();
            Integer positionlast = nounId.getEnd();
            Genemarker geneAnnotation = new Genemarker(aJCas);
            geneAnnotation.setBegin(positionfirst);
            geneAnnotation.setEnd(positionlast);
            geneAnnotation.setGeneId(nounId.getNounId());
            geneAnnotation.setGeneName(nounText);
            geneAnnotation.setSentenceBegin(nounId.getSentenceBegin());
            geneAnnotation.addToIndexes();
          }
        }
      
      }
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
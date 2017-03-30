package pkg;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;

import ca.pfv.spmf.algorithms.sequentialpatterns.spade_spam_AGP.AlgoSPADE;
import ca.pfv.spmf.algorithms.sequentialpatterns.spade_spam_AGP.candidatePatternsGeneration.CandidateGenerator;
import ca.pfv.spmf.algorithms.sequentialpatterns.spade_spam_AGP.candidatePatternsGeneration.CandidateGenerator_Qualitative;
import ca.pfv.spmf.algorithms.sequentialpatterns.spade_spam_AGP.dataStructures.creators.AbstractionCreator;
import ca.pfv.spmf.algorithms.sequentialpatterns.spade_spam_AGP.dataStructures.creators.AbstractionCreator_Qualitative;
import ca.pfv.spmf.algorithms.sequentialpatterns.spade_spam_AGP.dataStructures.database.SequenceDatabase;
import ca.pfv.spmf.algorithms.sequentialpatterns.spade_spam_AGP.idLists.creators.IdListCreator;
import ca.pfv.spmf.algorithms.sequentialpatterns.spade_spam_AGP.idLists.creators.IdListCreator_FatBitmap;

public class SmpfTest {

    public static void main(String[] args) throws IOException {
    	String outputPath ="C:/google drive/skripsi/app/output/spmfRiau14.txt";
        // Load a sequence database
        double support = 0.01;

        boolean keepPatterns = true;
        boolean verbose = false;

        AbstractionCreator abstractionCreator = AbstractionCreator_Qualitative.getInstance();
        boolean dfs= true;
        
        // kalo ini true, akan ada tambahan output #idSekuens setiap sekuens yang 
        // mengandung suatu pola sekuens  
        boolean outputSequenceIdentifiers = false;

        IdListCreator idListCreator = IdListCreator_FatBitmap.getInstance();
        
        CandidateGenerator candidateGenerator = CandidateGenerator_Qualitative.getInstance();
        
        SequenceDatabase sequenceDatabase = new SequenceDatabase(abstractionCreator, idListCreator);

        sequenceDatabase.loadFile("C:/google drive/skripsi/app/input/riau14new.txt", support);
        
        System.out.println(sequenceDatabase.toString());

        AlgoSPADE algorithm = new AlgoSPADE(support,dfs,abstractionCreator);
        
        algorithm.runAlgorithm(sequenceDatabase, candidateGenerator,keepPatterns,verbose,outputPath,outputSequenceIdentifiers);
        System.out.println("Minimum support (relative) = "+support);
        System.out.println(algorithm.getNumberOfFrequentPatterns()+ " frequent patterns.");
        
        System.out.println(algorithm.printStatistics());
    }

    public static String fileToPath(String filename) throws UnsupportedEncodingException {
        URL url = SmpfTest.class.getResource(filename);
        return java.net.URLDecoder.decode(url.getPath(), "UTF-8");
    }
}

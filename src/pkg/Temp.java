package pkg;

import java.io.IOException;

import org.rosuda.JRI.RVector;
import org.rosuda.JRI.Rengine;

// percobaan rjava

public class Temp {
	
	public static void main(String a[]) throws IOException {
		
		
		// membuat vektor yang dimasukan kedalam string
        String javaVector = "c(1,2,3,4,5)";
		
		// input file csv
//		String javaFile = "read.table(\"C:/google drive/skripsi/my Reference/data kak gema/G64120089/Data Penelitian/Titik Panas Kalimantan/praproses kalimantan 2015.csv\", header=TRUE, sep=\",\")";
		
        // memulai Rengine
        Rengine engine = new Rengine(new String[] { "--no-save" }, false, null);
        
        // vektor yang berformat java kemudian dimasukan kedalam lingkungan R
        engine.eval("rVector=" + javaVector);
        
      //menghitung rata rata dengan sintax R
        engine.eval("meanVal=mean(rVector)");

        
//        engine.eval("myFile=" + javaFile);
        
        //menghitung jumlah row-- tested
//        engine.eval("row1= nrow(myFile)");
        
//        engine.eval("row1 = myFile[1,]");
        
        // menulis file csv
//        engine.eval("write.csv(row1, file = \"C:/google drive/skripsi/app/testOutput/oneRow.csv\",row.names=FALSE)");

        
//        RVector outputRow = engine.eval("row1").asVector() ;
        
        //install R package
//        engine.eval("install.packages(\"ggplot2\", lib=\"C:/google drive/skripsi/app/R Package\")");
        
        
//       engine.eval("library(\"ggplot2\")");
//       engine.eval("ggplot(row1, aes(hwy,cty))");
        
//        for (int i =0; i < outputRow.size(); i++){
//        	System.out.println(outputRow.get(i));
//        }
        
        
        
        //print matrix
//        for (int i =1; i < outputRow.length; i++){
//        	for(int j = 1; j < outputRow[i].length; j++){
//        		System.out.println(outputRow[i][j] + " ");
//        	f}
//        }
        
        
        
//        System.out.println(outputRow);
        
        //memindahkan hasil menjadi double (java format)
        double mean = engine.eval("meanVal").asDouble();
        
        //Print hasil keluaran
        System.out.println("Mean of given vector is=" + mean);

    }
}


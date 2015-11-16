package com.jdse.duplicates;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * This class is responsible of reading the file line by line and delegates the storage of the siret numbers 
 * in the appropriate structure.
 * 
 * @author Juan David Sanchez
 *
 */
public class DuplicateFinder {
    
    private static final String DEFAULT_FILE = "testFiles/sirens_fxt.txt";

    public StatisticsHolder computeStatistics(String filePath){
        
        StatisticsHolder statsOutput = new StatisticsHolder();
        
        try{
            BufferedReader br = null;
            if(filePath!=null){
        	File file = new File(filePath);
        	if(file.exists() && file.canRead()){
        	    FileReader fr = new FileReader(file);
            	    br  = new BufferedReader(fr); 
        	}else{
        	    System.err.format("The file %s does not exist or it cannot be read.%n", filePath);
        	}
        	
            }else{
        	ClassLoader classLoader = this.getClass().getClassLoader();
        	InputStream in = classLoader.getResourceAsStream(DEFAULT_FILE); 
        	br = new BufferedReader(new InputStreamReader(in));
            }
            
            String line = null;
            while (br!=null && (line = br.readLine()) != null) {
        	statsOutput.addSirenNumber(line);
            }
        	
            return statsOutput;
        } catch (IOException x) {
            System.err.format("There was an IO Exception: %s%n", x);
            return null;
        }
    }
    
}

package com.jdse.duplicates;

/**
 * @author Juan David Sanchez
 * 
 * This class calls a class responsible of computing the statistics. The main responsibility of this class is 
 * launching the program and printing the results.
 *
 */
public class DuplicateFinderLauncher 
{
    public static void main( String[] args )
    {
	DuplicateFinder fr = new DuplicateFinder();
	StatisticsHolder output;
	if(args.length>0){
	    System.out.format("trying to read file from arguments: %s%n", args[0]);
	    output = fr.computeStatistics(args[0]);
	}else{
	    System.out.println("No file provided, using default file instead.");
	    output = fr.computeStatistics(null);
	}
	
	if(output!=null){
	    System.out.format("Siren numbers count without duplicates: %s%n", output.getUniqueSirens().size());
	    System.out.format("Siren numbers count with duplicates: %s%n", output.getDuplicateSirens().size());
	    System.out.format("Siren numbers with incorrect format: %s%n", output.getErrorSirens().size());
	}else{
	    System.out.format("Something went wrong, the statistics could not be computed");
	}
    }
}



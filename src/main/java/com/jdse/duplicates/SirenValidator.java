package com.jdse.duplicates;

/**
 * @author Juan David Sanchez
 * 
 * This class is responsible of checking the validity of a siren number using a variation of Luhn algorithm.
 * https://en.wikipedia.org/wiki/Luhn_algorithm.
 *
 */
public class SirenValidator {
    
    private String errorMessage;
    
    /**
     * Checks the validity of the siren number: numeric, length 9 and compliant with Luhn algorithm.
     * 
     * @param sirenNumber
     * @return true if the number passes the Luhn algorithm check
     */
    public boolean isValid(String sirenNumber){
	if(sirenNumber== null || sirenNumber.length()!=9){
	    setErrorMessage("Siren number lenght is incorrect");
	    return false;
	}
	
	if(!parseableAsInteger(sirenNumber)){
	    setErrorMessage("Siren number is not an integer");
	    return false;
	}
	
	int iteration = 1;
	int total = 0;
	int todo = Integer.parseInt(sirenNumber, 10);
	while (todo > 0) {
	    int subResult;
	    //even positions are multiplied by 2
	    if(iteration %2 == 0){
		subResult = (todo % 10) * 2;
	    }else{
		//odd positions are multiplied by 1
		subResult = (todo % 10);
	    }
	    
	    //if the multiplication has a 2 digit result, those digits are summed and added to the total
	    if(subResult > 9){
		total += 1 + (subResult % 10);
	    }else{
		total += subResult % 10;
	    }
	    
	    //prepare for the next iteration:
	    //ignore one digit in the right
	    //increment the iteration count
	    todo  = todo / 10;
	    iteration++;
	}
	
	//The verification is successful if the total of the sum is multiple of 10
	if(total % 10 == 0){
	    return true;
	}
	setErrorMessage("Siren not verifying the checksum.");
	return false;
    }

    /**
     * Checks whether a siren String can be represented as a number.
     * 
     * @param siren number to be checked
     * @return true if the String is parseable as a number
     */
    private boolean parseableAsInteger(String siren) {
	if(siren!=null && siren.matches("\\d+")){
	    return true;
	}
	return false;
    }

    public String getErrorMessage() {
	return errorMessage;
    }

    private void setErrorMessage(String errorMessage) {
	this.errorMessage = errorMessage;
    }

}

package com.jdse.duplicates;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is responsible of holding the siren numbers that are read and put them into the right category:
 * <ul>
 * <li>unique sirens: siren numbers not having duplicates</li>
 * <li>duplicate sirens: siren numbers having duplicates</li>
 * <li>invalid sirens</li>
 * </ul>
 * 
 * @author Juan David Sanchez
 *
 */
public class StatisticsHolder {
    
    private Map<String, String> uniqueSirens;
    
    private Map<String, String> duplicateSirens;
    
    private Map<String, String> invalidSirens;
    
    private SirenValidator errorChecker;
    
    private static final String UNIQUE = "UNIQUE";
    
    private static final String HAS_DUPLICATE = "HAS_DUPLICATE";
    
    /**
     * Initializes the maps holding the siren numbers and the sirenValidator
     */
    public StatisticsHolder(){
	uniqueSirens = new HashMap<String, String>();
        duplicateSirens = new HashMap<String, String>();
        invalidSirens = new HashMap<String, String>();
        errorChecker = new SirenValidator();
    }
    
    /**
     * Adds the siren number to the appropriate map:
     * 
     * <ul>
     * <li>if not a valid siren number: add to error map</li>
     * <li>if duplicate siren number: add it to duplicate list (and remove it from the unique list</li>
     * <li>if unique </li>
     * </ul>
     * 
     * @param siren number
     */
    public void addSirenNumber(String siren){
	if(errorChecker.isValid(siren)){
	    if(uniqueSirens.containsKey(siren)){
    	    	uniqueSirens.remove(siren);
    	    	duplicateSirens.put(siren, HAS_DUPLICATE);
	    }else if(!duplicateSirens.containsKey(siren)){
		uniqueSirens.put(siren, UNIQUE);
	    } 
	}else{
	    invalidSirens.put(siren, "invalid Siren number.");
	}
    }

    public Map<String, String> getUniqueSirens() {
        return uniqueSirens;
    }

    public void setUniqueSirens(Map<String, String> uniqueSirens) {
        this.uniqueSirens = uniqueSirens;
    }

    public Map<String, String> getDuplicateSirens() {
        return duplicateSirens;
    }

    public void setDuplicateSirens(Map<String, String> duplicateSirens) {
        this.duplicateSirens = duplicateSirens;
    }

    public Map<String, String> getErrorSirens() {
	return invalidSirens;
    }

    public void setErrorSirens(Map<String, String> errorSirens) {
	this.invalidSirens = errorSirens;
    }

}

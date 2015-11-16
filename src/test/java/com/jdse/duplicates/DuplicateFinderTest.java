package com.jdse.duplicates;

import static org.junit.Assert.assertEquals;

import java.net.URL;

import org.junit.Before;
import org.junit.Test;



/**
 * Unit test for DuplicateFinderTest.
 */
public class DuplicateFinderTest {
    
    DuplicateFinder classUnderTest;
    
    @Before
    public void setUp(){
	classUnderTest = new DuplicateFinder();
    }
    
    /**
     * Test case for "only duplicates" scenario:
     * <ul>
     * <li>All siren numbers have a correct formating</li>
     * <li>Some Unique siren numbers are present</li>
     * <li>Some duplicate siren numbers are present</li>
     * </ul>
     */
    @Test
    public void standardScenarioTest()
    {
	ClassLoader classLoader = this.getClass().getClassLoader();
	URL url = classLoader.getResource("test_file_1.txt");
	StatisticsHolder result = classUnderTest.computeStatistics(url.getPath());
	assertEquals("2 unique sirens were expected.", 2, result.getUniqueSirens().size());
	assertEquals("2 duplicate sirens were expected.", 2, result.getDuplicateSirens().size());
	assertEquals("No sirens in error were expected.", 0, result.getErrorSirens().size());
    }
    
    /**
     * Test case for "all duplicates" scenario:
     * <ul>
     * <li>All siren numbers have a correct formating</li>
     * <li>No Unique siren numbers are present</li>
     * <li>1 duplicate siren number is present</li>
     * </ul>
     */
    @Test
    public void onlyDuplicatesScenarioTest()
    {
	ClassLoader classLoader = this.getClass().getClassLoader();
	URL url = classLoader.getResource("test_file_2.txt");
	StatisticsHolder result = classUnderTest.computeStatistics(url.getPath());
	assertEquals("No unique sirens were expected.", 0, result.getUniqueSirens().size());
	assertEquals("1 duplicate sirens were expected.", 1, result.getDuplicateSirens().size());
	assertEquals("0 sirens in error was expected.", 0, result.getErrorSirens().size());
    }
    
    /**
     * Test case for "invalid entry" scenario:
     * <ul>
     * <li>1 Siren numbers has incorrect formating</li>
     * <li>2 Unique siren numbers are present</li>
     * <li>1 duplicate siren number is present</li>
     * </ul>
     */
    @Test
    public void NotNumericEntryTest()
    {
	ClassLoader classLoader = this.getClass().getClassLoader();
	URL url = classLoader.getResource("test_file_3.txt");
	StatisticsHolder result = classUnderTest.computeStatistics(url.getPath());
	assertEquals("2 unique sirens were expected.", 2, result.getUniqueSirens().size());
	assertEquals("1 duplicate sirens were expected.", 1, result.getDuplicateSirens().size());
	assertEquals("1 sirens in error was expected.", 1, result.getErrorSirens().size());
    }
    
    /**
     * Test case for "empty file" scenario:
     * 
     * No siren numbers in the file provided.
     */
    @Test
    public void emptyFileTest()
    {
	ClassLoader classLoader = this.getClass().getClassLoader();
	URL url = classLoader.getResource("test_file_4.txt");
	StatisticsHolder result = classUnderTest.computeStatistics(url.getPath());
	assertEquals("No unique sirens were expected.", 0, result.getUniqueSirens().size());
	assertEquals("No duplicate sirens were expected.", 0, result.getDuplicateSirens().size());
	assertEquals("No sirens in error were expected.", 0, result.getErrorSirens().size());
    }
    
    /**
     * Test case for "all duplicates" scenario:
     * <ul>
     * <li>All siren numbers have a correct formating</li>
     * <li>3 Unique siren numbers are present</li>
     * <li>0 duplicate siren numbers are present</li>
     * </ul>
     */
    @Test
    public void onlyUniqueTest()
    {
	ClassLoader classLoader = this.getClass().getClassLoader();
	URL url = classLoader.getResource("test_file_5.txt");
	StatisticsHolder result = classUnderTest.computeStatistics(url.getPath());
	assertEquals("3 unique sirens were expected.", 3, result.getUniqueSirens().size());
	assertEquals("0 duplicate sirens were expected.", 0, result.getDuplicateSirens().size());
	assertEquals("0 sirens in error was expected.", 0, result.getErrorSirens().size());
    }
    
    /**
     * Test case for "invalid entry" scenario:
     * <ul>
     * <li>All siren numbers have a correct formating</li>
     * <li>3 Unique siren numbers are present, but one of them is invalid</li>
     * <li>0 duplicate siren numbers are present</li>
     * </ul>
     */
    @Test
    public void invalidEntryTest()
    {
	ClassLoader classLoader = this.getClass().getClassLoader();
	URL url = classLoader.getResource("test_file_6.txt");
	StatisticsHolder result = classUnderTest.computeStatistics(url.getPath());
	assertEquals("2 unique sirens were expected.", 2, result.getUniqueSirens().size());
	assertEquals("0 duplicate sirens were expected.", 0, result.getDuplicateSirens().size());
	assertEquals("1 sirens in error was expected.", 1, result.getErrorSirens().size());
    }
}

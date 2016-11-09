package com.m1miageprojet.plugindeplacement;


import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class DeplacementSimpleTest extends TestCase {

	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public DeplacementSimpleTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( DeplacementSimpleTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testDeplacementSimple()
    {
        assertTrue( true );
    }
}

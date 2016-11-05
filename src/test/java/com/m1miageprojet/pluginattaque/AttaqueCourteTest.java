package com.m1miageprojet.pluginattaque;


import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AttaqueCourteTest extends TestCase {
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AttaqueCourteTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AttaqueCourteTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testAttaqueCourte()
    {
        assertTrue( true );
    }

}

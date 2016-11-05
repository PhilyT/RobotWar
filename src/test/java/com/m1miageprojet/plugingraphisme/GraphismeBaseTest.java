package com.m1miageprojet.plugingraphisme;


import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class GraphismeBaseTest extends TestCase {
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public GraphismeBaseTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( GraphismeBaseTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testGraphismeBase()
    {
        assertTrue( true );
    }
}

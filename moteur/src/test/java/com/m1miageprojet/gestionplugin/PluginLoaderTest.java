package com.m1miageprojet.gestionplugin;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class PluginLoaderTest extends TestCase{
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public PluginLoaderTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( PluginLoaderTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testPluginLoader()
    {
        assertTrue( true );
    }
}

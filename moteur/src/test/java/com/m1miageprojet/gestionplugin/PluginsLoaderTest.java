package com.m1miageprojet.gestionplugin;

import java.io.File;

import com.m1miageprojet.gestionplugins.PluginsLoader;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class PluginsLoaderTest extends TestCase{
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public PluginsLoaderTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( PluginsLoaderTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testPluginLoader()
    {
        assertTrue( true );
    }
    
    public void testPluginLoaderAttaqueCourteImplementInterface()
    {
    	PluginsLoader testLoader = new PluginsLoader();
    	testLoader.getPath().add(new File("../plugins/plugins-1.0-jar-with-dependencies.jar"));
    	try {
			Class<?> attaque = testLoader.loadClass("com.m1miageprojet.pluginattaque.AttaqueCourte");
			System.out.println(attaque.getInterfaces()[0].getName());
			assertTrue(attaque.getInterfaces().length>0);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			assertTrue(false);
		}
    }
}

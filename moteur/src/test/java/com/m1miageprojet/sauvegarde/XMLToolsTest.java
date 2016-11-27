package com.m1miageprojet.sauvegarde;

import java.awt.Color;
import java.io.File;
import java.util.ArrayList;

import com.m1miageprojet.app.Robot;
import com.m1miageprojet.gestionplugins.PluginsLoader;
import com.m1miageprojet.interfacesplugins.IAttaque;
import com.m1miageprojet.interfacesplugins.IDeplacement;
import com.m1miageprojet.interfacesplugins.IGraphisme;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * 
 * @author Tom
 *
 */
public class XMLToolsTest extends TestCase 
{
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public XMLToolsTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( XMLToolsTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testXMLTools()
    {
        assertTrue( true );
    }
    
    /**
     * Test la serialization d'une liste de Robots
     */
    public void testSerializationDuneListeDeRobots()
    {
    	XMLTools outil = new XMLTools();
    	PluginsLoader pluginsloader = new PluginsLoader();
    	pluginsloader.getPath().add(new File("../plugins/plugins-1.0-jar-with-dependencies.jar"));
    	try 
    	{
			Class<?> graphiqueplugin = pluginsloader.loadClass("com.m1miageprojet.plugingraphisme.GraphismeBase");
			Class<?> attaqueplugin = pluginsloader.loadClass("com.m1miageprojet.pluginattaque.AttaqueCourte");
			Class<?> deplacementplugin = pluginsloader.loadClass("com.m1miageprojet.plugindeplacement.DeplacementSimple");
			IGraphisme g = (IGraphisme)graphiqueplugin.newInstance();
			IAttaque a = (IAttaque)attaqueplugin.newInstance();
			IDeplacement d = (IDeplacement)deplacementplugin.newInstance();
			ArrayList<Robot> partie = new ArrayList<Robot>();
			partie.add(new Robot(150, 150, Color.BLUE, g, d, a, "r1"));
			partie.add(new Robot(350, 350, Color.RED, g, d, a, "r2"));
			// Test la serialisation
			outil.encodeToFile(partie, "PartieTest.xml");
			
			ArrayList<Robot> partieDeserialize = outil.decodeFromFile("PartieTest.xml");
	    	assertTrue( !partieDeserialize.isEmpty() );
		} 
    	catch (ClassNotFoundException e) 
    	{
			e.printStackTrace();
		} 
    	catch (InstantiationException e) 
    	{
			e.printStackTrace();
		} 
    	catch (IllegalAccessException e) 
    	{
			e.printStackTrace();
		}
    }
}

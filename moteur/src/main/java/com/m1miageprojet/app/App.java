package com.m1miageprojet.app;

import java.lang.reflect.InvocationTargetException;

import com.m1miageprojet.gestionplugins.PluginsLoader;
import com.m1miageprojet.gestionplugins.SwingRepository;


/**
 * 
 * @author Tom
 *
 */
public class App 
{
	/**
	 * 
	 * @param args
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
    public static void main( String[] args ) throws IllegalArgumentException, InvocationTargetException, InstantiationException, IllegalAccessException
    {
    	SwingRepository gestionnaireplugins = new SwingRepository();
    	gestionnaireplugins.showFrame();

    }
}

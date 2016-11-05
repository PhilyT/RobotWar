package com.m1miageprojet.app;

import java.io.File;

import com.m1miageprojet.gestionplugin.PluginLoader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	PluginLoader myclassloader = new PluginLoader();
		File f = new File("RobotWar-1.0.jar");
		myclassloader.getPath().add(f);
		try {
			Class<?> c = myclassloader.loadClass("com.m1miageprojet.plugingraphisme.GraphismeBase");
			try {
				Object newisntanceofc = c.newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }
}

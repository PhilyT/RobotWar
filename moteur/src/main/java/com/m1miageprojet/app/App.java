package com.m1miageprojet.app;

import java.io.File;

import com.m1miageprojet.gestionplugins.PluginsLoader;
import com.m1miageprojet.interfacesplugins.IGraphisme;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IllegalArgumentException, InvocationTargetException, InstantiationException, IllegalAccessException
    {
    	PluginsLoader myclassloader = new PluginsLoader();

		File f = new File("plugins/plugins-1.0.jar");
		File f2 = new File("interfaces/interfaces-1.0.jar");
		myclassloader.getPath().add(f);
		myclassloader.getPath().add(f2);

		try {
			System.out.println("jusqu'ici tout va bien");
			Class<?> graphisme = myclassloader.loadClass("com.m1miageprojet.plugingraphisme.GraphismeBase");
			try {
				System.out.println("je passe bien par ici");
				Constructor c = graphisme.getConstructor();
				IGraphisme g = (IGraphisme) c.newInstance();
				System.out.println("Chargement des plugins r�ussi !");
				MySwingApp fenetre = new MySwingApp(g);
				fenetre.repaint();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }
}

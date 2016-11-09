package com.m1miageprojet.app;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.m1miageproject.interfacesplugin.IGraphisme;
import com.m1miageprojet.gestionplugin.PluginLoader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IllegalArgumentException, InvocationTargetException
    {
    	PluginLoader myclassloader = new PluginLoader();
		File f = new File("../RobotWar-1.0.jar");
		myclassloader.getPath().add(f);
		try {
			//Class<?> attaque = myclassloader.loadClass("com.m1miageprojet.pluginattaque.AttaqueCourte");
			//Class<?> deplacement = myclassloader.loadClass("com.m1miageprojet.plugindeplacement.DeplacementSimple");
			//Class<?> graphisme = myclassloader.loadClass("com.m1miageprojet.plugingraphisme.GraphismeFleur");
			Class<?> graphisme = myclassloader.loadClass("com.m1miageprojet.plugingraphisme.Plateau");
			try {
				Constructor[] testConstruct = graphisme.getConstructors();
				IGraphisme testInstance = (IGraphisme) testConstruct[0].newInstance(null);
				MySwingApp fenetre = new MySwingApp(testInstance);
				//Object attaqueInstance = attaque.newInstance();
				//Object deplacementInstance = deplacement.newInstance();
				//Object graphismeInstance = graphisme.newInstance();
				System.out.println("Chargement des plugins réussi !");
				/*Robot imrobot = new Robot(attaqueInstance, deplacementInstance, graphismeInstance);
				Plateau plateau = new Plateau();
				plateau.getRobots().add(imrobot);
				MySwingApp app = new MySwingApp(plateau);*/
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

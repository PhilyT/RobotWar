package com.m1miageprojet.app;

import java.io.File;
import com.m1miageprojet.gestionplugins.PluginsLoader;
import com.m1miageprojet.interfacesplugins.IDeplacement;
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
			//Class<?> attaque = myclassloader.loadClass("com.m1miageprojet.pluginattaque.AttaqueCourte");
			//Class<?> deplacement = myclassloader.loadClass("com.m1miageprojet.plugindeplacement.DeplacementSimple");
			//Class<?> graphisme = myclassloader.loadClass("com.m1miageprojet.plugingraphisme.GraphismeFleur");
			System.out.println("jusqu'ici tout va bien");
			//Class<?> plateau = myclassloader.loadClass("com.m1miageprojet.plugingraphisme.Plateau");
			Class<?> graphisme = myclassloader.loadClass("com.m1miageprojet.plugingraphisme.GraphismeBase");
			Class<?> deplacement = myclassloader.loadClass("com.m1miageprojet.plugindeplacement.DeplacementSimple");
			try {
				Constructor cGraph = graphisme.getConstructor();
				Constructor cDep = deplacement.getConstructor();
				IGraphisme g = (IGraphisme) cGraph.newInstance();
				IDeplacement d = (IDeplacement) cDep.newInstance();
				MySwingApp fenetre = new MySwingApp(g, d);
				for(int i = 0; i < 50; i++) {
					fenetre.repaint();
					Thread.sleep(1000);
				}
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("je passe bine par là");
			System.out.println("Chargement des plugins réussi !");
			//Object attaqueInstance = attaque.newInstance();
			//Object deplacementInstance = deplacement.newInstance();
			//Object graphismeInstance = graphisme.newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }
}

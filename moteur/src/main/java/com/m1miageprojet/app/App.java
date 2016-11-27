package com.m1miageprojet.app;

import java.io.File;
import com.m1miageprojet.gestionplugins.PluginsLoader;
import com.m1miageprojet.interfacesplugins.IAttaque;
import com.m1miageprojet.interfacesplugins.IDeplacement;
import com.m1miageprojet.interfacesplugins.IGraphisme;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


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
    	PluginsLoader myclassloader = new PluginsLoader();
    	File f = new File("plugins/plugins-1.0-jar-with-dependencies.jar");
    	File f2 = new File("interfaces/interfaces-1.0.jar");
		//File f = new File("../plugins/plugins-1.0-jar-with-dependencies.jar");
		//File f2 = new File("../interfaces/interfaces-1.0.jar");
		myclassloader.getPath().add(f);
		myclassloader.getPath().add(f2);
		try {
			Class<?> graphisme = myclassloader.loadClass("com.m1miageprojet.plugingraphisme.GraphismeBase");
			Class<?> deplacement = myclassloader.loadClass("com.m1miageprojet.plugindeplacement.DeplacementSimple");
			Class<?> attaque = myclassloader.loadClass("com.m1miageprojet.pluginattaque.AttaqueCourte");
			try {
				Constructor cGraph = graphisme.getConstructor();
				Constructor cDep = deplacement.getConstructor();
				Constructor cAtt = attaque.getConstructor();
				IGraphisme g = (IGraphisme) cGraph.newInstance();
				IDeplacement d = (IDeplacement) cDep.newInstance();
				IAttaque a = (IAttaque) cAtt.newInstance();
				MySwingApp fenetre = new MySwingApp(g, d, a);
				fenetre.run();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }
}

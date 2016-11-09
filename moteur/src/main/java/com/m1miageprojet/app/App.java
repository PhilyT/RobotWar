package com.m1miageprojet.app;

import java.io.File;
import javax.swing.JPanel;
import com.m1miageprojet.gestionplugins.PluginsLoader;
import com.m1miageprojet.interfacesplugins.IGraphisme;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	PluginsLoader myclassloader = new PluginsLoader();
		File f = new File("plugins/plugins-1.0.jar");
		myclassloader.getPath().add(f);
		try {
			//Class<?> attaque = myclassloader.loadClass("com.m1miageprojet.pluginattaque.AttaqueCourte");
			//Class<?> deplacement = myclassloader.loadClass("com.m1miageprojet.plugindeplacement.DeplacementSimple");
			//Class<?> graphisme = myclassloader.loadClass("com.m1miageprojet.plugingraphisme.GraphismeFleur");
			System.out.println("jusqu'ici tout va bien");
			Class<?> plateau = myclassloader.loadClass("com.m1miageprojet.plugingraphisme.Plateau");
			System.out.println("je passe bine par là");
			try {
				IGraphisme plateauInstance = (IGraphisme) plateau.newInstance();
				System.out.println("Chargement des plugins réussi !");
				MySwingApp fenetre = new MySwingApp((JPanel)plateauInstance);
				//Object attaqueInstance = attaque.newInstance();
				//Object deplacementInstance = deplacement.newInstance();
				//Object graphismeInstance = graphisme.newInstance();
				
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

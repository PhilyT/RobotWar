package com.m1miageprojet.gestionplugins;

import com.m1miageprojet.interfacesplugins.IAttaque;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

/**
 * Created by Tanouti on 11/11/2016.
 */
public class PluginRepository {

    final PluginsLoader loaderClass = new PluginsLoader();
    final List<Class<?>> ListToReturn = new ArrayList<Class<?>>();
    private final File folder;
    private String finalFolder = "";
    List<Class<?>> pluginsGraphisme = new ArrayList<>();
    List<Class<?>> pluginsAttaque = new ArrayList<>();
    List<Class<?>> pluginsDeplacment = new ArrayList<>();

    public PluginRepository(File folder) {
        finalFolder = folder.toString();
        this.folder = folder;

    }

   public List<Class<?>> load() throws IOException {
        loaderClass.getPath().add(new File(finalFolder));
        return walk(folder);
    }

    //debut ajout
    public List<Class<?>> walk(File folder) throws IOException {

        try {
            InputStream input = new FileInputStream(finalFolder);
            JarInputStream jis = new JarInputStream(input);
            JarEntry temp = jis.getNextJarEntry();

            while (temp != null) {
                System.out.print(temp.getName());
                if (temp.isDirectory())
                    System.out.println(" -> Repertoire");
                else {
                    // parcourir le jar et le traitement des fichier
                    System.out.println(" -> Fichier");
                    //on rÃ©cuppÃ©re les fichier .class
                    if (temp.getName().endsWith(".class")) {
                        String classVisitedName = temp.getName().substring(0, temp.getName().length() - 6);
                        System.out.println("le nouveau nom " + classVisitedName);
                        classVisitedName = classVisitedName.replace(File.separator, ".");
                        classVisitedName = classVisitedName.replace("/", ".");
                        try {
                            // chargement des classes
                            Class c = loaderClass.loadClass(classVisitedName);
                            if (!c.isInterface()) {
                                Class<?>[] interfaces = c.getInterfaces();
                                for (int i = 0; i < interfaces.length; i++) {
                                    switch (interfaces[i].getSimpleName()) {
                                        case "IAttaque":
                                            pluginsAttaque.add(c);
                                            break;
                                        case "IDeplacement":
                                            pluginsDeplacment.add(c);
                                            break;
                                        case "IGraphisme":
                                            pluginsGraphisme.add(c);
                                            break;
                                    }
                                }
                                ListToReturn.add(c);
                            }

                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
                temp = jis.getNextJarEntry();
            }

        } catch (IOException e) {
            System.out.println("Impossible de lire le jar");
            e.printStackTrace();

        }
        return ListToReturn;
    }


    public List<Class<?>> getPluginsGraphisme() {
        return pluginsGraphisme;
    }

    public List<Class<?>> getPluginsDeplacment() {
        return pluginsDeplacment;
    }

    public List<Class<?>> getPluginsAttaque() {
        return pluginsAttaque;
    }
    
    /**
     * 
     * @param name nom du plugin a recuperer
     * @return un plugin attaque
     * @throws Exception
     */
    public Class<?> getPluginsAttaquebyName(String name) throws Exception
    {
    	for(Class<?> c : pluginsAttaque)
    	{
    		if(c.getName().equals(name))
    		{
    			return c;
    		}
    	}
    	throw new Exception("Pas de plugin attaque chargé");
    }
    
    /**
     * 
     * @param name name nom du plugin a recuperer
     * @return un plugin deplacement
     * @throws Exception
     */
    public Class<?> getPluginsDeplacementbyName(String name)throws Exception
    {
    	for(Class<?> c : pluginsDeplacment)
    	{
    		if(c.getName().equals(name))
    		{
    			return c;
    		}
    	}
    	throw new Exception("Pas de plugin attaque chargé");
    }
    
    /**
     * 
     * @param name name nom du plugin a recuperer
     * @return un plugin graphisme
     * @throws Exception
     */
    public Class<?> getPluginsGraphismebyName(String name)throws Exception
    {
    	for(Class<?> c : pluginsGraphisme)
    	{
    		if(c.getName().equals(name))
    		{
    			return c;
    		}
    	}
    	throw new Exception("Pas de plugin attaque chargé");
    }
}


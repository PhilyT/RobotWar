package com.m1miageprojet.gestionplugins;

import com.m1miageprojet.interfacesplugins.IAttaque;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tanouti on 11/11/2016.
 */
public class PluginRepository {
    final List<Class<?>> ListToReturn = new ArrayList<Class<?>>();
    private final File folder;
    private String finalFolder="";
    List<Class<?>> pluginsGraphisme= new ArrayList<>();
    List<Class<?>> pluginsAttaque= new ArrayList<>();
    List<Class<?>> pluginsDeplacment = new ArrayList<>();

    public PluginRepository(File folder) {
        finalFolder =folder.toString();
        this.folder = folder;

    }

   public List<Class<?>> load() throws IOException {

       Path p = Paths.get(folder.toString());
       return walk(folder);
   }
       //debut ajout
  public List<Class<?>> walk( File folder ) throws IOException {
      final PluginsLoader loaderClass = new PluginsLoader();
      File fich1= new File ("../plugins/plugins-1.0-jar-with-dependencies.jar");
      File fich2 = new File("../interfaces/interfaces.jar");
      loaderClass.getPath().add(fich1);
      loaderClass.getPath().add(fich2);
               if (!folder.exists()){System.out.println("n'existe pas");}
               File[] list = folder.listFiles();

               if (list == null) return null;

               for ( File f : list ) {
                   if ( f.isDirectory() ) {
                       walk( f );
                   }
                   else {
                       if (f.toString().endsWith(".class")) {
                           System.out.println("valable a charger "+f.getAbsolutePath());
                           //get the name of file
                           String classVisitedName = f.toString().substring(finalFolder.toString().length()+1);
                           System.out.println("apres premier traitement "+classVisitedName);
                           //On enlève l'extention (".class")
                           classVisitedName = classVisitedName.substring(0, classVisitedName.length() - 6);
                           System.out.println("apres premier traitement 2"+classVisitedName);
                           //On remplace les  séparateurs de fichiers par des "."
                           classVisitedName = classVisitedName.replace(File.separator, ".");
                           classVisitedName = classVisitedName.replace("/", ".");
                           System.out.println("apres premier traitement 3 "+classVisitedName);
                           try {
                               //ajout

                               Class c =loaderClass.loadClass(classVisitedName);
                               Class<?>[] interfaces=c.getInterfaces();
                             
                               for (int i=0;i<interfaces.length;i++){
                                   switch (interfaces[i].getSimpleName()){
                                       case "IAttaque": pluginsAttaque.add(c); break;
                                       case "IDeplacement" : pluginsDeplacment.add(c); break;
                                       case "IGraphisme" : pluginsGraphisme.add(c); break;
                                   }
                               }
                               ListToReturn.add(c);

                               //fin ajout
                             //  ListToReturn.add(loaderClass.loadClass(classVisitedName));
                           } catch (ClassNotFoundException e) {
                               e.printStackTrace();
                           }
                       }

                   }
               }
       return ListToReturn;
           }
    public List<Class<?>> getPluginsGraphisme()
       {
           return pluginsGraphisme;
       }
    public List<Class<?>> getPluginsDeplacment()
    {
        return pluginsDeplacment;
    }
    public List<Class<?>> getPluginsAttaque()
    {
        return pluginsAttaque;
    }

       }



       //fin d'ajout


      /* Files.walkFileTree(p, new SimpleFileVisitor<Path>() {
           @Override
           public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
               if (file.toString().endsWith(".class")) {
                        System.out.println(file.toString());
                       //get the name of file
                       String classVisitedName = file.toString().substring(folder.toString().length() + 1);
                       //On enlève l'extention (".class")
                       classVisitedName = classVisitedName.substring(0, classVisitedName.length() - 6);
                       //On remplace les  séparateurs de fichiers par des "."
                       classVisitedName = classVisitedName.replace(File.separator, ".");
                       classVisitedName = classVisitedName.replace("/", ".");
                       try {
                           ListToReturn.add(loaderClass.loadClass(classVisitedName));
                       } catch (ClassNotFoundException e) {
                           e.printStackTrace();
                       }
                   }
                       return FileVisitResult.CONTINUE;
    }
           @Override
           public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
               return FileVisitResult.SKIP_SUBTREE;
           }
       });

       return ListToReturn;}
*/
//}

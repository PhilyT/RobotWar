package com.m1miageprojet.gestionplugins;

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
    private final File folder;

    public PluginRepository(File folder) {
        this.folder = folder;
    }

   public List<Class<?>> load() throws IOException {
        final List<Class<?>> ListToReturn = new ArrayList<>();
        final PluginsLoader loaderClass = new PluginsLoader();
       Path p = Paths.get(folder.toString());
       Files.walkFileTree(p, new SimpleFileVisitor<Path>() {
           @Override
           public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
               if (file.toString().endsWith(".class")) {

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

}

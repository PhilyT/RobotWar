package com.m1miageprojet.gestionplugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.SecureClassLoader;
import java.util.ArrayList;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class PluginLoader extends SecureClassLoader
{
	private ArrayList<File> path = new ArrayList<File>();

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte[] b = loadClassData(name);
		return super.defineClass(name, b, 0, b.length);
	}

	private byte[] loadClassData(String name) throws ClassNotFoundException {
		try {
			return loadClassRepertoire(name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ClassNotFoundException();
		}
	}

	private byte[] loadClassRepertoire(String name) throws ClassNotFoundException, IOException {
		// System.out.println(name);
		String pathclass = name.replace('.', '/');
		// System.out.println(pathclass);
		pathclass = pathclass + ".class";

		byte[] result = null;
		for (File file : path) {
			if (true) {
				return loadClassJar(result, file, pathclass);
			}
		}
		throw new ClassNotFoundException();
	}

	public ArrayList<File> getPath() {
		return path;
	}

	public static byte[] getBytesFromInputStream(InputStream is) throws IOException 
	{

		// Get the size of the file
		long length = is.available();

		if (length > Integer.MAX_VALUE) {
			// File is too large
		}

		// Create the byte array to hold the data
		byte[] bytes = new byte[(int) length];

		// Read in the bytes
		int offset = 0;
		int numRead = 0;
		while (offset < bytes.length && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
			offset += numRead;
		}

		// Ensure all the bytes have been read in
		if (offset < bytes.length) {
			throw new IOException("Could not completely read file ");
		}

		// Close the input stream and return bytes
		is.close();
		return bytes;
	}

	private byte[] loadClassJar(byte[] result, File file, String pathclass) throws ClassNotFoundException, IOException {
		System.out.println("je passe bien ici");
		JarFile jf = new JarFile(file.getPath());
		
		JarEntry je = jf.getJarEntry(pathclass);
		System.out.println(je);
		InputStream is = jf.getInputStream(je);
		result = getBytesFromInputStream(is);
		jf.close();
		return result;
	}

	public static void main(String[] args) {
		PluginLoader myclassloader = new PluginLoader();
		File f = new File("C://Users/Tom/Documents/Projet/RobotWar/RobotWar-1.0.jar");
		myclassloader.getPath().add(f);
		try {
			Class<?> c = myclassloader.loadClass("com.m1miageprojet.gestionplugin.PluginLoader");
			System.out.println(c.getName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

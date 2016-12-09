package com.m1miageprojet.sauvegarde;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import com.m1miageprojet.app.Robot;

/**
 * 
 * @author Tom
 *
 */
public class XMLTools 
{	
    /**
     * Serialisation d'une partie dans un fichier
     * @param partie Liste de robots comprenant l'etat de la partie en cours a serialiser
     * @param filename chemin du fichier
     */
    public static void encodeToFile(ArrayList<Robot> partie, String fileName) {
        // ouverture de l'encodeur vers le fichier
        XMLEncoder encoder;
		try 
		{
			encoder = new XMLEncoder(new FileOutputStream(fileName));
			try 
			{
	            // serialisation de la partie
	            encoder.writeObject(partie);
	            encoder.flush();
	        } 
			finally 
			{
	            // fermeture de l'encodeur
	            encoder.close();
	        }
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
    }

    /**
     * Deserialisation d'une partie depuis un fichier
     * @param filename chemin du fichier
     */
    public static ArrayList<Robot> decodeFromFile(String fileName) 
    {
    	ArrayList<Robot> partie = null;
        // ouverture de decodeur
        XMLDecoder decoder;
		try 
		{
			decoder = new XMLDecoder(new FileInputStream(fileName));
			try 
	        {
	            // deserialisation de la partie
	            partie = (ArrayList<Robot>)decoder.readObject();
	        } 
			catch(Exception e)
			{
				e.printStackTrace();
			}
	        finally 
	        {
	            // fermeture du decodeur
	            decoder.close();
	        }
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
        return partie;
    }

}

/**
 * @author Nicolas Kircun
 * Date de creation 9 nov. 2016
 * Nom du projet interfaces
 * com.m1miageproject.interfacesplugin - IGraphisme.java
 * Master 1 MIAGE - UNICE
 */
package com.m1miageprojet.interfacesplugins;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 * @author Nicolas Kircun
 *
 */
public interface IGraphisme {
	public void draw(IRobot r, Graphics g);
	public void addNameIGraphisme(String name);
	public ArrayList<String> getListeNames();
}

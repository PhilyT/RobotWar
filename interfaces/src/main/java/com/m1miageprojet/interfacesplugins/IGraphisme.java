/**
 * @author Nicolas Kircun
 * Date de creation 9 nov. 2016
 * Nom du projet interfaces
 * com.m1miageproject.interfacesplugin - IGraphisme.java
 * Master 1 MIAGE - UNICE
 */
package com.m1miageprojet.interfacesplugins;

import java.awt.Color;
import java.awt.Graphics;

/**
 * @author Nicolas Kircun
 *
 */
public interface IGraphisme {
	public void draw(IRobot r, Graphics g);
	public void drawWeapon(IProjectile p, Graphics g, int direction);
}

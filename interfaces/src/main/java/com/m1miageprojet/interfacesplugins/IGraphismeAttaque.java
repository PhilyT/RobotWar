/**
 * @author Nicolas Kircun
 * Date de creation 10 nov. 2016
 * Nom du projet interfaces
 * com.m1miageprojet.interfaces - IGraphismeAttaque.java
 * Master 1 MIAGE - UNICE
 */
package com.m1miageprojet.interfacesplugins;

import java.awt.Graphics;

public interface IGraphismeAttaque {
	public void drawWeapon(IProjectile p, Graphics g, int direction);
}

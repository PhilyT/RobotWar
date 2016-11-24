/**
 * @author Nicolas Kircun
 * Date de creation 10 nov. 2016
 * Nom du projet interfaces
 * com.m1miageprojet.app - IProjectile.java
 * Master 1 MIAGE - UNICE
 */
package com.m1miageprojet.interfacesplugins;

import java.awt.Graphics;

public interface IProjectile {
	public void attaque(Graphics gr, IRobot r, IGraphisme g, IAttaque a);
	public int getX();
	public int getY();
	public void setX(int x);
	public void setY(int y);
	public int getTaille();
	public IRobot getAdversaire();
	public IRobot getTireur();
}

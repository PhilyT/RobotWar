/**
 * @author Nicolas Kircun
 * Date de creation 10 nov. 2016
 * Nom du projet interfaces
 * com.m1miageprojet.app - IProjectile.java
 * Master 1 MIAGE - UNICE
 */
package com.m1miageprojet.interfacesplugins;

public interface IProjectile {
	public void attaque(int direction, IRobot r);
	public int getX();
	public int getY();
	public int getTaille();
	public IRobot getAdversaire();
}

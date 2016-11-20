/**
 * @author Nicolas Kircun
 * Date de creation 10 nov. 2016
 * Nom du projet interfaces
 * com.m1miageprojet.app - IProjectile.java
 * Master 1 MIAGE - UNICE
 */
package com.m1miageprojet.interfacesplugins;

public interface IProjectile {
	public void deplace();
	public double getX();
	public double getY();
	public IRobot getAdversaire();
}

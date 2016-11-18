/**
 * @author Nicolas Kircun
 * Date de creation 10 nov. 2016
 * Nom du projet moteur
 * com.m1miageprojet.app - Projectile.java
 * Master 1 MIAGE - UNICE
 */
package com.m1miageprojet.app;

import com.m1miageprojet.interfacesplugins.IProjectile;
import com.m1miageprojet.interfacesplugins.IRobot;

public class Projectile implements IProjectile {
	
	private double x1, y1;
	private double y2;
	private double x2;
	private double coeffDir;
	
	public Projectile(int xDep, int yDep, IRobot adversaire) {
		this.x1 = xDep;
		this.y1 = yDep;
		
		if(adversaire.getY() > this.y1 && adversaire.getX() > this.x1) {
			coeffDir = ((adversaire.getY() - this.y1) / (adversaire.getX() - this.x1));
		} else {
			coeffDir = ((this.y1 - adversaire.getY()) / (this.x1 - adversaire.getX()));
		}
		
		double milieuX = (this.x1 + adversaire.getX()) / 2;
		double milieuY = (this.y1 + adversaire.getY()) / 2;

		this.x2 = milieuX - 30;
		this.y2 = (milieuY - 30) * coeffDir;
	}

	public void deplace() {
		double rapportX = this.x1 / this.x2;
		double rapportY = this.y1 / this.y2;
		this.x1 += 30 * rapportX;
		this.y1 += 30 * rapportY;
		this.x2 += 30 * rapportX;
		this.y2 += 30 * rapportY;
	}

	public double getX1() {
		return x1;
	}

	public double getY1() {
		return y1;
	}

	public double getX2() {
		return x2;
	}

	public double getY2() {
		return y2;
	}
}

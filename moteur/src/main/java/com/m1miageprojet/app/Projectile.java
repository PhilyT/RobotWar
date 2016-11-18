/**
 * @author Nicolas Kircun
 * Date de creation 10 nov. 2016
 * Nom du projet moteur
 * com.m1miageprojet.app - Projectile.java
 * Master 1 MIAGE - UNICE
 */
package com.m1miageprojet.app;

import java.awt.Graphics;

import com.m1miageprojet.interfacesplugins.IProjectile;
import com.m1miageprojet.interfacesplugins.IRobot;

public class Projectile implements IProjectile {
	
	private double x1, y1;
	private double y2;
	private double x2;
	
	public Projectile(int xDep, int yDep, IRobot adversaire) {
		this.x1 = xDep;
		this.y1 = yDep;
		
		double coeffDir = ((adversaire.getY() - this.y1) / (adversaire.getX() - this.x1));
//		System.out.println((adversaire.getY() - this.y1) + " // " + (adversaire.getX() - this.x1));
//		System.out.println((adversaire.getY() - this.y1) / (adversaire.getX() - this.x1));
//		this.x2 = (int) ((int) (xDep + 20) * coeffDir);
		this.x2 = xDep + 20;
		this.y2 = (yDep + 20) * coeffDir;
	}

	public void deplace() {
		this.x1 += 30;
		this.y1 += 30;
		this.x2 += 30;
		this.y2 += 30;
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

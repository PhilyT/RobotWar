/**
 * @author Nicolas Kircun
 * Date de creation 10 nov. 2016
 * Nom du projet moteur
 * com.m1miageprojet.app - Projectile.java
 * Master 1 MIAGE - UNICE
 */
package com.m1miageprojet.app;

import com.m1miageprojet.interfacesplugins.IAttaque;
import com.m1miageprojet.interfacesplugins.IProjectile;
import com.m1miageprojet.interfacesplugins.IRobot;

public class Projectile implements IProjectile {
	
	private double x, y;
	private double coeffDir;
	private IRobot adversaire;
	private IRobot tireur;
	private IAttaque attaque;
	
	public Projectile(int xDep, int yDep, IRobot adversaire, IRobot tireur, IAttaque attaque) {
		this.attaque = attaque;
		this.tireur = tireur;
		this.adversaire = adversaire;
		this.x = xDep;
		this.y = yDep;
		if(adversaire.getY() > this.y && adversaire.getX() > this.x) {
			coeffDir = ((adversaire.getY() - this.y) / (adversaire.getX() - this.x));
		} else {
			coeffDir = ((this.y - adversaire.getY()) / (this.x - adversaire.getX()));
		}
}

	public void deplace(boolean a) {
		
		if(a) {
			this.x = this.x + 30;
			this.y = (this.y + 30) * this.coeffDir;
		} else {
			this.x = this.x - 30;
			this.y = (this.y - 30) * this.coeffDir;
		}
		if(adversaire.estTouche(x, y))
		{
			attaque.touche(this);
		}
		
		
//		double rapportX = this.x / this.x2;
//		double rapportY = this.y / this.y2;
//		this.x += 30 * rapportX;
//		this.y += 30 * rapportY;
//		this.x2 += 30 * rapportX;
//		this.y2 += 30 * rapportY;
//		
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
	
	public IRobot getAdversaire() {
		return adversaire;
	}

	public IRobot getTireur() {
		// TODO Auto-generated method stub
		return tireur;
	}
}

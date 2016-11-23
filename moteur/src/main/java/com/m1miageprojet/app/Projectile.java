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
	
	private int x, y;
	private IRobot adversaire;
	private IRobot tireur;
	private IAttaque attaque;
	private int taille;
	
	public Projectile() {
		this.taille = 150;
//		this.adversaire = adversaire;
}

	public void attaque(int direction, IRobot r) {
		
		switch (direction) {
		// attaque vers la droite
		case 0:
			this.x = r.getX() + 50;
			this.y = r.getY() + 25;
			break;
		// attaque vers le bas
		case 1:
			this.x = r.getX() + 25;
			this.y = r.getY() + 50;
			break;
		// attaque vers la gauche	
		case 2:
			this.x = r.getX();
			this.y = r.getY() + 25;
			break;
		// attaque vers le haut
		case 3:
			this.x = r.getX() + 25;
			this.y = r.getY();
			break;
		default:
			break;
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public int getTaille() {
		return taille;
	}
	
	public IRobot getAdversaire() {
		return adversaire;
	}

	public IRobot getTireur() {
		// TODO Auto-generated method stub
		return tireur;
	}
}

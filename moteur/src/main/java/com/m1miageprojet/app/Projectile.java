/**
 * @author Nicolas Kircun
 * Date de creation 10 nov. 2016
 * Nom du projet moteur
 * com.m1miageprojet.app - Projectile.java
 * Master 1 MIAGE - UNICE
 */
package com.m1miageprojet.app;


import java.awt.Graphics;

import com.m1miageprojet.interfacesplugins.IAttaque;
import com.m1miageprojet.interfacesplugins.IGraphisme;
import com.m1miageprojet.interfacesplugins.IProjectile;
import com.m1miageprojet.interfacesplugins.IRobot;

public class Projectile implements IProjectile {
	
	private int x, y;
	private IRobot adversaire;
	private IRobot tireur;
//	private IAttaque attaque;
	private int taille;
	

	public Projectile(IRobot adversaire, IRobot tireur) {
		this.taille = 150;
		this.adversaire = adversaire;
		this.tireur = tireur;
}

	public void attaque(Graphics gr, IRobot adversaire, IAttaque a) {	
		a.attaque(gr, adversaire, this);
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
		return tireur;
	}

	public void setX(int x) {
		this.x = x;		
	}

	public void setY(int y) {
		this.y = y;		
	}
}

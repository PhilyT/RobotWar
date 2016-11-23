/**
 * @author Nicolas Kircun
 * Date de creation 10 nov. 2016
 * Nom du projet plugins
 * com.m1miageprojet.app - AttaqueCourte.java
 * Master 1 MIAGE - UNICE
 */
package com.m1miageprojet.pluginattaque;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Line2D;

import com.m1miageprojet.interfacesplugins.IAttaque;
import com.m1miageprojet.interfacesplugins.IGraphisme;
import com.m1miageprojet.interfacesplugins.IProjectile;
import com.m1miageprojet.interfacesplugins.IRobot;

public class AttaqueCourte implements IAttaque {

	public void attaque(Graphics gr, IGraphisme g, IRobot adversaire, IProjectile p) {
		int direction;
		
		if(adversaire.getX() >= p.getTireur().getX() - 50 && adversaire.getX() < p.getTireur().getX() + 50) {
			if(adversaire.getY() <= p.getTireur().getY() + 200 && adversaire.getY() > p.getTireur().getY() - 50) {
				direction = 1;
				p.setX(p.getTireur().getX() + 25);
				p.setY(p.getTireur().getY() + 50);
				g.drawWeapon(p, gr, direction);
			} else if(adversaire.getY() > p.getTireur().getY() - 150 && adversaire.getY() < p.getTireur().getY()) {
				direction = 3;
				p.setX(p.getTireur().getX() + 25);
				p.setY(p.getTireur().getY());
				g.drawWeapon(p, gr, direction);
			}
		} else if(adversaire.getY() >= p.getTireur().getY() - 50 && adversaire.getY() < p.getTireur().getY() + 50) {
			if(adversaire.getX() <= p.getTireur().getX() + 200 && adversaire.getX() > p.getTireur().getX() + 50) {
				direction = 0;
				p.setX(p.getTireur().getX() + 50);
				p.setY(p.getTireur().getY() + 25);
				g.drawWeapon(p, gr, direction);
			} else if(adversaire.getX() > p.getTireur().getX() - 150 && adversaire.getX() < p.getTireur().getX()) {
				direction = 2;
				p.setX(p.getTireur().getX());
				p.setY(p.getTireur().getY() + 25);
				g.drawWeapon(p, gr, direction);
			}
		}
	}

	public void touche(IProjectile p) {
		// TODO Auto-generated method stub
		p.getAdversaire().subVie(5);
		p.getTireur().subEnergie(1);
		System.out.println("Robot touché { vie : " + p.getAdversaire().getVie() + " energie : " + p.getAdversaire().getEnergie());
	}
}

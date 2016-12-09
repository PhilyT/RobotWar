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
import com.m1miageprojet.interfacesplugins.IGraphismeAttaque;
import com.m1miageprojet.interfacesplugins.IProjectile;
import com.m1miageprojet.interfacesplugins.IRobot;
import com.m1miageprojet.plugingraphisme.attaque.GraphismeAttaque;

public class AttaqueCourte implements IAttaque {
	
	private IGraphismeAttaque graphismeAttaque;
	
	public AttaqueCourte() {
		graphismeAttaque = new GraphismeAttaque();
	}

	public void attaque(Graphics gr, IRobot adversaire, IProjectile p) {
		int direction;
		if(adversaire.getX() >= p.getTireur().getX() - 50 && adversaire.getX() < p.getTireur().getX() + 50 && (p.getTireur().getE()-2)>=0) {
			p.getTireur().soustrairedelenergie(2);
			if(adversaire.getY() <= p.getTireur().getY() + 200 && adversaire.getY() > p.getTireur().getY() - 50) {
				direction = 1;
				p.setX(p.getTireur().getX() + 25);
				p.setY(p.getTireur().getY() + 50);
				graphismeAttaque.drawWeapon(p, gr, direction);
				if(p.getAdversaire().estTouche(p.getX(), p.getY(), p.getX(), p.getY() + p.getTaille(), direction))
				{
					touche(p);
					System.out.println("Robot touche dans la direction "+ direction +" { nom : "+ p.getAdversaire().getNom() +" vie : " + p.getAdversaire().getV() + " energie : " + p.getAdversaire().getE());
				}
			} else if(adversaire.getY() > p.getTireur().getY() - 150 && adversaire.getY() < p.getTireur().getY()) {
				direction = 3;
				p.setX(p.getTireur().getX() + 25);
				p.setY(p.getTireur().getY());
				graphismeAttaque.drawWeapon(p, gr, direction);
				if(p.getAdversaire().estTouche(p.getX(), p.getY(), p.getX(), p.getY() - p.getTaille(), direction))
				{
					touche(p);
					System.out.println("Robot touche dans la direction "+ direction +" { nom : "+ p.getAdversaire().getNom() +" vie : " + p.getAdversaire().getV() + " energie : " + p.getAdversaire().getE());
				}
			}
		} else if(adversaire.getY() >= p.getTireur().getY() - 50 && adversaire.getY() < p.getTireur().getY() + 50&& (p.getTireur().getE()-2)>=0) {
			p.getTireur().soustrairedelenergie(2);
			if(adversaire.getX() <= p.getTireur().getX() + 200 && adversaire.getX() > p.getTireur().getX() + 50) {
				direction = 0;
				p.setX(p.getTireur().getX() + 50);
				p.setY(p.getTireur().getY() + 25);
				graphismeAttaque.drawWeapon(p, gr, direction);
				if(p.getAdversaire().estTouche(p.getX(), p.getY(), p.getX() + p.getTaille(), p.getY(), direction))
				{
					touche(p);
					System.out.println("Robot touche dans la direction "+ direction +" { nom : "+ p.getAdversaire().getNom() +" vie : " + p.getAdversaire().getV() + " energie : " + p.getAdversaire().getE());
				}
			} else if(adversaire.getX() > p.getTireur().getX() - 150 && adversaire.getX() < p.getTireur().getX()) {
				direction = 2;
				p.setX(p.getTireur().getX());
				p.setY(p.getTireur().getY() + 25);
				graphismeAttaque.drawWeapon(p, gr, direction);
				if(p.getAdversaire().estTouche(p.getX(), p.getY(), p.getX() - p.getTaille(), p.getY(), direction))
				{
					touche(p);
					System.out.println("Robot touche dans la direction "+ direction +" { nom : "+ p.getAdversaire().getNom() +" vie : " + p.getAdversaire().getV() + " energie : " + p.getAdversaire().getE());
				}
			}
		}
	}

	/**
	 * Action lorsque un projectile touche un adversaire.
	 * @param p projectile touchant un adversaire
	 */
	public void touche(IProjectile p) {
		// TODO Auto-generated method stub

		p.getAdversaire().soustrairedelavie((int)(Math.random() * (5-3)) + 3);
	}
}

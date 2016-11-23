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
import com.m1miageprojet.interfacesplugins.IProjectile;
import com.m1miageprojet.interfacesplugins.IRobot;

public class AttaqueCourte implements IAttaque {

//	private int degats = 10, angle;	
	
	public void attaque(IProjectile p, Graphics g, int direction) {
		
		g.setColor(Color.GREEN);
		
		
		switch (direction) {
		// attaque vers la droite
		case 0:
			g.drawLine(p.getX(), p.getY(), p.getX() + p.getTaille(), p.getY());
			break;
		// attaque vers le bas
		case 1:
			g.drawLine(p.getX(), p.getY(), p.getX(), p.getY() + p.getTaille());
			break;
		// attaque vers la gauche	
		case 2:
			g.drawLine(p.getX(), p.getY(), p.getX() - p.getTaille(), p.getY());
			break;
		// attaque vers le haut
		case 3:
			g.drawLine(p.getX(), p.getY(), p.getX(), p.getY() - p.getTaille());
			break;
		default:
			break;
		}
	}
	
	public void deplace(IProjectile p, Graphics g) {
		
		g.setColor(Color.GREEN);
		g.fillRect((int) p.getX(), (int) p.getY(), 5, 5);
		
//		Graphics2D g2d = (Graphics2D) g;
//		Shape s = new Line2D.Double(p.getX1(), p.getY1(), p.getX2(), p.getY2());
//		g2d.setColor(Color.BLACK);
//		g2d.draw(s);
	}

	@Override
	public void touche(IProjectile p) {
		// TODO Auto-generated method stub
		p.getAdversaire().subVie(1);
	}
}

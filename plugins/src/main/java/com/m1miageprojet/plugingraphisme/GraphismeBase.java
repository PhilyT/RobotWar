package com.m1miageprojet.plugingraphisme;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import com.m1miageprojet.interfacesplugins.IGraphisme;
import com.m1miageprojet.interfacesplugins.IProjectile;
import com.m1miageprojet.interfacesplugins.IRobot;

public class GraphismeBase implements IGraphisme {

	/**
	 * Necessaire pour la serialisation
	 */
	public GraphismeBase()
	{
		
	}
	
	public void draw(IRobot r, Graphics g) {		
		g.setColor(r.getColor());
		g.fillRect(r.getX(), r.getY(), 50, 50);
	}

	public void drawWeapon(IProjectile p, Graphics g, int direction) {
		
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
	
}

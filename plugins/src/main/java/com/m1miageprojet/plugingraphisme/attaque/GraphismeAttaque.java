/**
 * @author Nicolas Kircun
 * Date de creation 10 nov. 2016
 * Nom du projet plugin
 * com.m1miageprojet.plugingraphisme.attaque - GraphismeAttaque.java
 * Master 1 MIAGE - UNICE
 */
package com.m1miageprojet.plugingraphisme.attaque;

import java.awt.Color;
import java.awt.Graphics;

import com.m1miageprojet.interfacesplugins.IGraphismeAttaque;
import com.m1miageprojet.interfacesplugins.IProjectile;

public class GraphismeAttaque implements IGraphismeAttaque {

	@Override
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

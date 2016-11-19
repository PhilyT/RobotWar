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
	
	public void tirer(IProjectile p, Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		Shape s = new Line2D.Double(p.getX1(), p.getY1(), p.getX2(), p.getY2());
		g2d.setColor(Color.BLACK);
		g2d.draw(s);
//		g.drawLine(p.getX1(), p.getY1(), p.getX2(),  p.getY2());
	}
	
	public void deplace(IProjectile p, Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		Shape s = new Line2D.Double(p.getX1(), p.getY1(), p.getX2(), p.getY2());
		g2d.setColor(Color.BLACK);
		g2d.draw(s);
	}

	@Override
	public void touche(IProjectile p) {
		// TODO Auto-generated method stub
		p.getAdversaire().subVie(1);
	}
}

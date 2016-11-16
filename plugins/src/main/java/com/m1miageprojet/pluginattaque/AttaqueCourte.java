package com.m1miageprojet.pluginattaque;

import java.awt.Graphics;

import com.m1miageprojet.interfacesplugins.IAttaque;
import com.m1miageprojet.interfacesplugins.IProjectile;

public class AttaqueCourte implements IAttaque {

	private int degats = 10, angle;
	
	private int x1 = 10, y1 = 10, midx = 50, midy = 200;
	
	
	@Override
	public void tirer(IProjectile p, Graphics g) {
		g.drawLine(p.getX1(), p.getY1(), p.getX2(), p.getY2());
	}
	
	public void deplace(IProjectile p, Graphics g) {
		g.drawLine(p.getX1(), p.getY1(), p.getX2(), p.getY2());
	}
}

package com.m1miageprojet.plugingraphisme.attaque;

import java.awt.Color;
import java.awt.Graphics;

import com.m1miageprojet.interfacesplugins.IGraphismeAttaque;
import com.m1miageprojet.interfacesplugins.IProjectile;

public class GraphismeAttaqueLongue implements IGraphismeAttaque {

	@Override
	public void drawWeapon(IProjectile p, Graphics g, int direction) {
		g.setColor(p.getTireur().getColor());
		g.drawRoundRect(p.getX()-8, p.getY()-8, 16, 16, 90, 90);
	}

}

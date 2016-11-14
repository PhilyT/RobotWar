package com.m1miageprojet.plugingraphisme;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import com.m1miageprojet.interfacesplugins.IGraphisme;
import com.m1miageprojet.interfacesplugins.IRobot;

public class GraphismeBase implements IGraphisme {

	public void draw(IRobot r, Graphics g) {		
		g.setColor(r.getColor());
		g.fillRect(r.getX(), r.getY(), 50, 50);
	}
	
}

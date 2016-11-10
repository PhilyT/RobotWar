package com.m1miageprojet.plugingraphisme;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import com.m1miageprojet.interfacesplugins.IGraphisme;
import com.m1miageprojet.interfacesplugins.IRobot;

public class GraphismeBase implements IGraphisme {

	public void draw(IRobot r, Graphics g) {
		Random rnd = new Random();
		int c = rnd.nextInt(2);
		Color color;
		
		switch(c) {
		case 0:
			color = Color.RED;
			break;
		case 1:
			color = Color.BLUE;
			break;
		case 2:
			color = Color.GREEN;
			break;
		default: 
			color = Color.BLACK;
		}
		
		g.setColor(color);
		g.fillRect(r.getX(), r.getY(), 50, 50);
	}
	
}

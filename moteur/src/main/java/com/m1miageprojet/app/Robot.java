package com.m1miageprojet.app;

import java.awt.Color;
import java.awt.Graphics;
import com.m1miageproject.interfacesplugin.IGraphisme;

/**
 * @author Nicolas Kircun
 *
 */
public class Robot  {
	private int x;
	private int y;
	private Color color;
	private IGraphisme graphisme;
	
	public Robot(int x, int y) {
		this.x = x;
		this.y = y;
//		this.color = graphisme.getColor();
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public void afficheRobot(Graphics g) {
		graphisme.draw(g);
	}
}

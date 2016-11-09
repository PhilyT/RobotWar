/**
 * @author Nicolas Kircun
 * Date de creation 9 nov. 2016
 * Nom du projet moteur
 * com.m1miageprojet.plugingraphisme - Robot.java
 * Master 1 MIAGE - UNICE
 */
package com.m1miageprojet.plugingraphisme;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 * @author Nicolas Kircun
 *
 */
public class Robot  {
	private int x;
	private int y;
	private Color color;
	
	public Robot(int x, int y, Color c) {
		this.x = x;
		this.y = y;
		this.color = c;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Color getColor() {
		return color;
	}
	
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.fillRect(getX(), getY(), 50, 50);
	}
}

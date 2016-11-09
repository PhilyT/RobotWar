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
	
	public void afficheRobot(Graphics g) {
		graphisme.draw(g);
	}
}

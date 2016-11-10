/**
 * @author Nicolas Kircun
 * Date de creation 10 nov. 2016
 * Nom du projet moteur
 * com.m1miageprojet.app - Robot.java
 * Master 1 MIAGE - UNICE
 */
package com.m1miageprojet.app;

import java.awt.Graphics;
import com.m1miageprojet.interfacesplugins.IGraphisme;
import com.m1miageprojet.interfacesplugins.IRobot;

/**
 * @author Nicolas Kircun
 *
 */
public class Robot implements IRobot {
	private int x, y, width, height;
	private IGraphisme graphisme;
	
	public Robot(int x, int y, IGraphisme graphisme) {
		this.graphisme = graphisme;
		this.x = x;
		this.y = y;
		this.width = 50; this.height = 50;
	}

	/**
	 * 	Appel du plugin graphique pour l'afficher
	 */
	public void drawRobot(Graphics g) {
		graphisme.draw(this, g);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}	
}

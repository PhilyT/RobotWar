/**
 * @author Nicolas Kircun
 * Date de creation 5 nov. 2016
 * Nom du projet RobotWar
 * com.m1miageprojet.plugingraphisme - Plateau.java
 * Licence 3 MIAGE - UNICE
 */
package com.m1miageprojet.plugingraphisme;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import com.m1miageproject.interfacesplugin.IGraphisme;

/**
 * @author Nicolas Kircun
 *
 */
public class Plateau extends JPanel implements IGraphisme {
	
	private Robot r1;
	private Robot r2;
	
	
	public Plateau() {
		r1 = new Robot(10, 10, Color.RED);
		r2 = new Robot(430, 410, Color.BLUE);
	}
	
	public void paintComponent(Graphics g) {
		r1.draw(g);
		r2.draw(g);
	}

	/**
	 * Methode de IGraphisme
	 */
	public void draw(Graphics g) {
		this.repaint();
	}
}

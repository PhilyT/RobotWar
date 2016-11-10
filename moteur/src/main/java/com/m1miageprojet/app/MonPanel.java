/**
 * @author Nicolas Kircun
 * Date de creation 10 nov. 2016
 * Nom du projet moteur
 * com.m1miageprojet.app - MonPanel.java
 * Master 1 MIAGE - UNICE
 */
package com.m1miageprojet.app;

import java.awt.Graphics;

import javax.swing.JPanel;

import com.m1miageprojet.interfacesplugins.IGraphisme;

/**
 * @author Nicolas Kircun
 *
 */
public class MonPanel extends JPanel {
	private Robot r1;
	private Robot r2;
	
	public MonPanel(IGraphisme graphisme) {
		r1 = new Robot(10, 10, graphisme);
		r2 = new Robot(430, 410, graphisme);
	}
	
	public void paintComponent(Graphics g) {
		r1.drawRobot(g);
		r2.drawRobot(g);
	}
}

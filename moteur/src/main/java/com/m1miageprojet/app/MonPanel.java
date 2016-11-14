/**
 * @author Nicolas Kircun
 * Date de creation 10 nov. 2016
 * Nom du projet moteur
 * com.m1miageprojet.app - MonPanel.java
 * Master 1 MIAGE - UNICE
 */
package com.m1miageprojet.app;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.m1miageprojet.interfacesplugins.IDeplacement;
import com.m1miageprojet.interfacesplugins.IGraphisme;

/**
 * @author Nicolas Kircun
 *
 */
public class MonPanel extends JPanel {
	private Robot r1;
	private Robot r2;
	
	// Indice pour dire si on en est a la création du panel ou simplement au rechargement
	private int i;
	
	public MonPanel(IGraphisme graphisme, IDeplacement deplacement) {
		r1 = new Robot(10, 10, Color.BLUE, graphisme, deplacement);
		r2 = new Robot(430, 410, Color.RED, graphisme, deplacement);
		i = 0;
	}
	
	public void paintComponent(Graphics g) {
		if(i == 0) {
			r1.drawRobot(g);
			r2.drawRobot(g);
		} else {
			r1.moveRobot();
			r2.moveRobot();
			r1.drawRobot(g);
			r2.drawRobot(g);	
		}
		i++;
	}
}

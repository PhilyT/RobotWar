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
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import com.m1miageprojet.interfacesplugins.IAttaque;
import com.m1miageprojet.interfacesplugins.IDeplacement;
import com.m1miageprojet.interfacesplugins.IGraphisme;
import com.m1miageprojet.interfacesplugins.IRobot;

/**
 * @author Nicolas Kircun
 *
 */
public class MonPanel extends JPanel {
	private Robot r1;
	private Robot r2;
	private ArrayList<Robot> robots = new ArrayList<Robot>();
	
	// Indice pour dire si on en est a la creation du panel ou simplement au rechargement
	private int i;
	
	public MonPanel(IGraphisme graphisme, IDeplacement deplacement, IAttaque attaque) {
		r1 = new Robot(10, 10, 10, 10, Color.BLUE, graphisme, deplacement, attaque, "r1");
		r2 = new Robot(100, 100, 10, 10, Color.RED, graphisme, deplacement, attaque, "r2");
		i = 0;
		robots.add(r1);
		robots.add(r2);
	}
	
	public Robot getR1()
	{
		return r1;
	}
	
	public Robot getR2()
	{
		return r2;
	}
	
	public ArrayList<Robot> getRobots()
	{
		return robots;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		if(i == 0) {
			r1.drawRobot(g);
			r2.drawRobot(g);
			r1.tirer(g, r2);
			r2.tirer(g, r1);
		} else {
			r1.moveRobot(robots);
			r2.moveRobot(robots);
			r1.drawRobot(g);
			r2.drawRobot(g);
			r1.tirer(g, r2);
			r2.tirer(g, r1);	
		}
		i++;
	}
}

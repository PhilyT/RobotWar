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
	private Robot r3;
	private Robot r4;
	private ArrayList<Robot> robots = new ArrayList<Robot>();
	
	// Indice pour dire si on en est a la creation du panel ou simplement au rechargement
	private int i;
	
	public MonPanel(IGraphisme graphisme, IDeplacement deplacement, IAttaque attaque) {
			
		r1 = new Robot(10, 10, 10, 10, Color.BLUE, graphisme, deplacement, attaque, "Robot Bleu");
		r2 = new Robot(100, 100, 10, 10, Color.RED, graphisme, deplacement, attaque, "Robot Rouge");
		r3 = new Robot(300, 300, 10, 10, Color.DARK_GRAY, graphisme, deplacement, attaque, "Robot Gris Sombre");
		r4 = new Robot(300, 100, 10, 10, Color.ORANGE, graphisme, deplacement, attaque, "Robot Orange");
		
		i = 0;
		robots.add(r1);
		robots.add(r2);
		robots.add(r3);
		robots.add(r4);
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
		
		for(int h = 0; h < robots.size(); h++) {
			if(robots.get(h).getV() <= 0) {
				robots.remove(h);
				h--;
			}
		}
		
		if(i == 0) {
			for(int j = 0; j < robots.size(); j++) {
				robots.get(j).drawRobot(g);
				robots.get(j).tirer(g, robots);
			}
		} else {
			for(int j = 0; j < robots.size(); j++) {
				robots.get(j).moveRobot(robots);
				robots.get(j).drawRobot(g);
				robots.get(j).tirer(g, robots);
			}
		}
		i++;
	}
}

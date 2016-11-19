/**
 * @author Nicolas Kircun
 * Date de creation 10 nov. 2016
 * Nom du projet moteur
 * com.m1miageprojet.app - Robot.java
 * Master 1 MIAGE - UNICE
 */
package com.m1miageprojet.app;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import com.m1miageprojet.interfacesplugins.IAttaque;
import com.m1miageprojet.interfacesplugins.IDeplacement;
import com.m1miageprojet.interfacesplugins.IGraphisme;
import com.m1miageprojet.interfacesplugins.IProjectile;
import com.m1miageprojet.interfacesplugins.IRobot;

/**
 * @author Nicolas Kircun
 *
 */
public class Robot implements IRobot {
	private int x, y, width, height;
	private Color color;
	private IGraphisme graphisme;
	private IDeplacement deplacement;
	private IAttaque attaque;
	private ArrayList<IProjectile> projectiles;
	private int vie, energie;
	
	public Robot(int x, int y, Color c, IGraphisme graphisme, IDeplacement deplacement, IAttaque attaque) {
		this.graphisme = graphisme;
		this.deplacement = deplacement;
		this.attaque = attaque;
		this.color = c;
		this.x = x;
		this.y = y;
		this.width = 50; this.height = 50;
		projectiles = new ArrayList<IProjectile>();
		vie = 10;
		energie = 10;
	}

	/**
	 * 	Appel du plugin graphique pour l'afficher
	 */
	public void drawRobot(Graphics g) {
		graphisme.draw(this, g);
	}
	
	public void moveRobot() {
		deplacement.move(this);
	}
	
	public void tirer(Graphics g, Robot adversaire) {
		IProjectile p = new Projectile(this.x + 50, this.y + 50, adversaire);
		projectiles.add(p);
		attaque.tirer(p, g);
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).deplace();
			attaque.deplace(projectiles.get(i), g);
		}
	}
	
	public boolean estTouche(double projectilX, double projectilY)
	{
		return ((projectilX <= (x + 25)) && (projectilX >= (x-25))) && ((projectilY <= (y+25)) && (projectilY >= (y+25)));
	}
	
	public int getVie(){
		return vie;
	}
	
	public int getEnergie(){
		return energie;
	}
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}	
	
	public void subVie() {
		vie--;
	}
	
	public void subEnergie(){
		energie--;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}

	public Color getColor() {
		return color;
	}
}

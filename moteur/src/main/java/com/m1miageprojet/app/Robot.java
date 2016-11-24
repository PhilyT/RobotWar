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
//	private ArrayList<IProjectile> projectiles;
	private IProjectile projectile;
	private int vie, energie;
	
	public Robot(int x, int y, Color c, IGraphisme graphisme, IDeplacement deplacement, IAttaque attaque) {
		this.graphisme = graphisme;
		this.deplacement = deplacement;
		this.attaque = attaque;
		this.color = c;
		this.x = x;
		this.y = y;
		this.width = 50; this.height = 50;
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
		if(energie <10){
			energie++;
		}
	}
	
	public void tirer(Graphics g, Robot adversaire) {
		projectile = new Projectile(adversaire, this);
		projectile.attaque(g, adversaire, graphisme, attaque);
	}
	
	/**
	 * Methode pour savoir si le robot est touché par un projectil en mouvement.
	 */
	public boolean estTouche(double projectilX, double projectilY)
	{
		return ((projectilX <= (x + 50)) && (projectilX >= (x))) && ((projectilY <= (y+50)) && (projectilY >= (y)));
	}
	
	/**
	 * Methode pour savoir si le robot est touché par un projectil en ligne.
	 */
	@Override
	public boolean estTouche(double posXProjectilInit, double posYProjectilInit, double posXProjectilFin,
			double posYProjctilFin, int direction) {
			boolean result = false;
			switch(direction)
			{
				// attaque vers la droite
				case 0:
					result = (((x+50) <= posXProjectilFin) && (x >= posXProjectilInit)) && ((y <= posYProjctilFin) && ((y+50) >= posYProjctilFin));
				// attaque vers le bas
				case 1:
					result = ((posXProjectilFin <= (x + 50)) && (posXProjectilFin >= (x))) && (((y+50) <= posYProjctilFin) && (y >= posYProjectilInit));
				// attaque vers la gauche	
				case 2:
					result = (((x+50) <= posXProjectilInit) && (x >= posXProjectilFin)) && ((y <= posYProjctilFin) && ((y+50) >= posYProjctilFin));
				// attaque vers le haut
				case 3:
					result = ((posXProjectilFin <= (x + 50)) && (posXProjectilFin >= (x))) && ((y >= posYProjctilFin) && ((y+50) <= posYProjectilInit));
			}
			return result;
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
	
	public void subVie(int degas) {
		vie = vie - degas;
	}
	
	public void subEnergie(int consum){
		energie = energie - consum;
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

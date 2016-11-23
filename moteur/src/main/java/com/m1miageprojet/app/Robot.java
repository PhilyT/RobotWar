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
		projectile = new Projectile();
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
		
		/**
		 * indique la direction de l'attaque : 0 pour droite, 1 pour en bas, 2 pour gauche, 3 pour en haut
		 */
		int direction;
		
		if(adversaire.getX() >= this.x && adversaire.getX() < this.x + 25) {
			if(adversaire.getY() <= this.y + 200) {
				direction = 1;
				projectile.attaque(direction, this);
				attaque.attaque(projectile, g, direction);
			} else if(adversaire.getY() < this.y - 150) {
				direction = 3;
				projectile.attaque(direction, this);
				attaque.attaque(projectile, g, direction);
			}
		} else if(adversaire.getY() >= this.y && adversaire.getY() < this.y + 25) {
			if(adversaire.getX() <= this.x + 200) {
				direction = 0;
				projectile.attaque(direction, this);
				attaque.attaque(projectile, g, direction);
			} else if(adversaire.getY() < this.y - 150) {
				direction = 2;
				projectile.attaque(direction, this);
				attaque.attaque(projectile, g, direction);
			}
		}
	}
	
	public boolean estTouche(double projectilX, double projectilY)
	{
		return ((projectilX <= (x + 50)) && (projectilX >= (x))) && ((projectilY <= (y+50)) && (projectilY >= (y)));
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

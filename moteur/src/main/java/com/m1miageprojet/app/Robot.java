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
//import java.util.ArrayList;
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
	private int x, y,v, e, width, height ;
	private Color color;
	private IGraphisme graphisme;
	private IDeplacement deplacement;
	private IAttaque attaque;
//	private ArrayList<IProjectile> projectiles;
	private IProjectile projectile;
	private String nom;	//pour test
	private String nomGraphisme;
	private String nomAttaque;
	private String nomDeplacement;
	
	/**
	 * Constructeur par default pour la serialization
	 */
	public Robot()
	{
		this(50, 50, 10, 10, Color.BLACK, new IGraphisme() {

					@Override
					public void draw(IRobot r, Graphics g) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void drawWeapon(IProjectile p, Graphics g, int direction) {
						// TODO Auto-generated method stub
						
					} 
			
				}, new IDeplacement() {

					@Override
					public void move(IRobot r) {
						// TODO Auto-generated method stub
						
					}
					
				}, new IAttaque() {

					@Override
					public void attaque(Graphics gr, IGraphisme g, IRobot adversaire, IProjectile p) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void touche(IProjectile p) {
						// TODO Auto-generated method stub
						
					}
					
				}, "serialisation");
	}
	
	public Robot(int x, int y, int v, int e, Color c, IGraphisme graphisme, IDeplacement deplacement, IAttaque attaque, String nom) {
		this.graphisme = graphisme;
		this.deplacement = deplacement;
		this.attaque = attaque;
		this.color = c;
		this.x = x;
		this.y = y;
		setV(v);
		setE(e);
		this.setWidth(50); this.setHeight(50);
		nomAttaque = attaque.getClass().getName();
		nomDeplacement = deplacement.getClass().getName();
		nomGraphisme = graphisme.getClass().getName();
		this.nom = nom;
	}

	/**
	 * 	Appel du plugin graphique pour l'afficher
	 */
	public void drawRobot(Graphics g) {
		graphisme.draw(this, g);
	}
	
	public void moveRobot() {
		deplacement.move(this);
		if(getE() <10){
			setE(getE()+1);
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
					break;
				// attaque vers le bas
				case 1:
					result = ((posXProjectilFin <= (x + 50)) && (posXProjectilFin >= (x))) && (((y+50) <= posYProjctilFin) && (y >= posYProjectilInit));
					break;
				// attaque vers la gauche	
				case 2:
					result = (((x+50) <= posXProjectilInit) && (x >= posXProjectilFin)) && ((y <= posYProjctilFin) && ((y+50) >= posYProjctilFin));
					break;
				// attaque vers le haut
				case 3:
					result = ((posXProjectilFin <= (x + 50)) && (posXProjectilFin >= (x))) && ((y >= posYProjctilFin) && ((y+50) <= posYProjectilInit));
					break;
			}
			return result;
	}
	
	public void soustrairedelavie(int degas) {
		setV(getV() - degas);
	}
	
	public void soustrairedelenergie(int consum){
		setE(getE() - consum);
	}
	
	public String getNomGraphisme()
	{
		return nomGraphisme;
	}
	
	public void setNomGraphisme(String graphisme) {
		this.nomGraphisme = graphisme;
	}
	
	public String getNomDeplacement() {
		return nomDeplacement;
	}

	public void setNomDeplacement(String deplacement) {
		this.nomDeplacement = deplacement;
	}

	public String getNomAttaque() {
		return nomAttaque;
	}

	public void setNomAttaque(String attaque) {
		this.nomAttaque = attaque;
	}	
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public int getV(){
		return v;
	}
	
	public int getE(){
		return e;
	}
	
	public String getNom(){
		return nom;
	}
	
	public Color getColor() {
		return color;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void setNom(String nom)
	{
		this.nom = nom;
	}
	
	public void setV(int v){
		this.v = v;
	}
	
	public void setE(int e){
		this.e = e;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}

	public void setColor(Color c) {
		color = c;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}

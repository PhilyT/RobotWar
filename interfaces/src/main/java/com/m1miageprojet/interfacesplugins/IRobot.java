/**
 * @author Nicolas Kircun
 * Date de creation 10 nov. 2016
 * Nom du projet interfaces
 * com.m1miageprojet.interfacesplugins - IRobot.java
 * Licence 3 MIAGE - UNICE
 */
package com.m1miageprojet.interfacesplugins;

import java.awt.*;

/**
 * @author Nico
 *
 */
public interface IRobot {
	public void drawRobot(Graphics g);
	public int getX();
	public int getY();
	public Color getColor();
	public void setX(int x);
	public void setY(int y);
	public int getV();
	public int getE();
	public void setV(int vie);
	public void setE(int energie);
	public void soustrairedelavie(int degas);
	public void soustrairedelenergie(int consum);
	public boolean estTouche(double posXProjectil, double posYProjectil);
	public boolean estTouche(double posXProjectilInit, double posYProjectilInit, double posXProjectilFin, double posYProjctilFin, int direction);
	public int getHeight();
	public int getWidth();

	public String getNom();
}

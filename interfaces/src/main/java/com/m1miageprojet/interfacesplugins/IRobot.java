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
	public int getVie();
	public int getEnergie();
	public void subVie(int degas);
	public void subEnergie(int consum);
	public boolean estTouche(double posXProjectil, double posYProjectil);
	public boolean estTouche(double posXProjectilInit, double posYProjectilInit, double posXProjectilFin, double posYProjctilFin, int direction);

}

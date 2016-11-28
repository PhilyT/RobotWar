/**
 * @author Nicolas Kircun
 * Date de creation 10 nov. 2016
 * Nom du projet plugin
 * com.m1miageprojet.plugingraphisme - BarreDeVie.java
 * Master 1 MIAGE - UNICE
 */
package com.m1miageprojet.plugingraphisme;

import java.awt.Color;
import java.awt.Graphics;

import com.m1miageprojet.interfacesplugins.IGraphisme;
import com.m1miageprojet.interfacesplugins.IRobot;

public class BarreDeVie implements IGraphisme {
	
	public IGraphisme graphisme;
	
	public BarreDeVie(IGraphisme graphisme) {
		this.graphisme = graphisme;
	}

	@Override
	public void draw(IRobot r, Graphics g) {

		if(r.getV() > 5) {
			g.setColor(Color.GREEN);
			switch(r.getV()) {
			case 10:
				g.fillRect(r.getX(), r.getY() - 10, 50, 5);
				break;
			case 9:
				g.fillRect(r.getX(), r.getY() - 10, 45, 5);
				break;
			case 8:
				g.fillRect(r.getX(), r.getY() - 10, 40, 5);
				break;
			case 7:
				g.fillRect(r.getX(), r.getY() - 10, 35, 5);
				break;
			case 6:
				g.fillRect(r.getX(), r.getY() - 10, 30, 5);
				break;
			default:
				break;
			}
			
		} else if(r.getV() <= 5 && r.getV() > 3) {
			g.setColor(Color.YELLOW);
			
			switch (r.getV()) {
			case 5:
				g.fillRect(r.getX(), r.getY() - 10, 25, 5);
				break;
			case 4:
				g.fillRect(r.getX(), r.getY() - 10, 20, 5);
				break;
			default:
				break;
			}
		} else {
			g.setColor(Color.RED);
			
			switch (r.getV()) {
			case 3:
				g.fillRect(r.getX(), r.getY() - 10, 15, 5);
				break;
			case 2:
				g.fillRect(r.getX(), r.getY() - 10, 10, 5);
				break;
			case 1:
				g.fillRect(r.getX(), r.getY() - 10, 5, 5);
				break;
			default:
				break;
			}
		}
		
		if(graphisme!=null) {
			graphisme.draw(r, g);
		}
	}

}

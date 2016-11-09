/**
 * @author Nicolas Kircun
 * Date de creation 5 nov. 2016
 * Nom du projet RobotWar
 * com.m1miageprojet.plugingraphisme - Plateau.java
 * Licence 3 MIAGE - UNICE
 */
package com.m1miageprojet.plugingraphisme;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

/**
 * @author Nicolas Kircun
 *
 */
public class Plateau extends JPanel {
	
	private int robot1X = 10;
	private int robot1Y = 10;
	private int robot2X = 430;
	private int robot2Y = 410;
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.setColor(Color.RED);
		g.fillRect(robot1X, robot1Y, 50, 50);
		g.setColor(Color.BLUE);
		g.fillRect(robot2X, robot2Y, 50, 50);
	}
	
	public void moveRobot() {
		int moveRobot1X, moveRobot1Y, moveRobot2X, moveRobot2Y;
		Random rnd = new Random();
		moveRobot1X = rnd.nextInt(100);
		moveRobot1Y = rnd.nextInt(100);
		moveRobot2X = rnd.nextInt(100);
		moveRobot2Y = rnd.nextInt(100);
		
		
		// Mouvement sur x de robot1
		if(moveRobot1X % 2 == 0) {
			if(this.getRobot1X() + moveRobot1X + 50 < 500) {
				this.setRobot1X(this.getRobot1X() + moveRobot1X);
			}
		}  else {
			if(this.getRobot1X() - moveRobot1X > 0) {
				this.setRobot1X(this.getRobot1X() - moveRobot1X);
			}
		}
		
		// Mouvement sur y de robot1
		if(moveRobot1Y % 2 == 0) {
			if(this.getRobot1Y() + moveRobot1Y + 50 < 470) {
				this.setRobot1Y(this.getRobot1Y() + moveRobot1Y);
			}
		}  else {
			if(this.getRobot1Y() - moveRobot1Y > 0) {
				this.setRobot1Y(this.getRobot1Y() - moveRobot1Y);
			}
		}
		
		
		// Mouvement sur x de robot2
		if(moveRobot2X % 2 == 0) {
			if(this.getRobot2X() + moveRobot2X + 50 < 500) {
				this.setRobot2X(this.getRobot2X() + moveRobot2X);
			}
		}  else {
			if(this.getRobot2X() - moveRobot2X > 0) {
				this.setRobot2X(this.getRobot2X() - moveRobot2X);
			}
		}
		
		
		// Mouvement sur y de robot2
		if(moveRobot2Y % 2 == 0) {
			if(this.getRobot2Y() + moveRobot2Y + 50 < 470) {
				this.setRobot2Y(this.getRobot2Y() + moveRobot2Y);
			}
		}  else {
			if(this.getRobot2Y() - moveRobot2Y > 0) {
				this.setRobot2Y(this.getRobot2Y() - moveRobot2Y);			}
		}
	}

	/**
	 * @return the x
	 */
	public int getRobot1X() {
		return robot1X;
	}

	/**
	 * @param x the x to set
	 */
	public void setRobot1X(int x) {
		this.robot1X = x;
	}

	/**
	 * @return the y
	 */
	public int getRobot1Y() {
		return robot1Y;
	}

	/**
	 * @param y the y to set
	 */
	public void setRobot1Y(int y) {
		this.robot1Y = y;
	}

	/**
	 * @return robot2X
	 */
	public int getRobot2X() {
		return robot2X;
	}

	/**
	 * @param x the robot2X to set
	 */
	public void setRobot2X(int x) {
		robot2X = x;
	}

	/**
	 * @return robot2Y
	 */
	public int getRobot2Y() {
		return robot2Y;
	}

	/**
	 * @param y the robot2Y to set
	 */
	public void setRobot2Y(int y) {
		robot2Y = y;
	}
}

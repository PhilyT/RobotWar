package com.m1miageprojet.plugingraphisme;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.m1miageprojet.plugingraphisme.*;

public class GraphismeBase extends JFrame {
	private Plateau panel = new Plateau();
	
	public GraphismeBase() {
		
		// Création de la fenêtre
		this.setTitle("Robot War");
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.setContentPane(panel);
		this.setVisible(true);
		go();
	}

	
	private void go() {
		for (int i = 0; i < 100; i++) {
			
			panel.moveRobot();
			panel.repaint();
			
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		GraphismeBase gb = new GraphismeBase();
	}
}

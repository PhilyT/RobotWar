package com.m1miageprojet.plugingraphisme;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import com.m1miageprojet.plugingraphisme.*;

public class GraphismeBase extends JFrame {
	
	public GraphismeBase() {
		
		// Création de la fenêtre
		this.setTitle("Robot War");
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.setContentPane(new Plateau());
		this.setVisible(true);
	}

	
	public static void main(String[] args) {
		GraphismeBase gb = new GraphismeBase();
	}
}

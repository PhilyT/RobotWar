package com.m1miageprojet.app;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MySwingApp extends JFrame 
{
	public MySwingApp(JPanel pannel) 
	{
		// Création de la fenêtre
		this.setTitle("Robot War");
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		this.setContentPane(pannel);
		this.setVisible(true);
	}
}

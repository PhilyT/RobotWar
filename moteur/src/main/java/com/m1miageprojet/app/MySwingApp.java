package com.m1miageprojet.app;


import javax.swing.JFrame;

import com.m1miageprojet.interfacesplugins.IGraphisme;

public class MySwingApp extends JFrame 
{
	
	public MySwingApp(IGraphisme graphisme) 
	{
		MonPanel panel = new MonPanel(graphisme);		
		
		// Cr�ation de la fen�tre
		this.setTitle("Robot War");
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.setContentPane(panel);
		this.setVisible(true);
	}
}

package com.m1miageprojet.app;


import java.awt.Dimension;

import javax.swing.JFrame;

import com.m1miageprojet.interfacesplugins.IDeplacement;
import com.m1miageprojet.interfacesplugins.IGraphisme;

public class MySwingApp extends JFrame 
{
	
	public MySwingApp(IGraphisme graphisme, IDeplacement deplacement) 
	{
		MonPanel panel = new MonPanel(graphisme, deplacement);
		panel.setSize(new Dimension(500, 500));
		// Creation de la fenetre
		this.setTitle("Robot War");
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);


		this.setContentPane(panel);
		this.setVisible(true);
	}
}

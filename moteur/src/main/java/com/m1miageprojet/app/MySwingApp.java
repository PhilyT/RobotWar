package com.m1miageprojet.app;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.m1miageproject.interfacesplugin.IGraphisme;

public class MySwingApp extends JFrame 
{
	
	public MySwingApp(IGraphisme graphisme) 
	{
		JPanel pannel = new JPanel();
		
		// Création de la fenêtre
		this.setTitle("Robot War");
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);		
		System.out.println("Coucou");
//		graphisme = new IGraphisme() {
//			
//			public void draw(Graphics g) {
//				this.draw(g);				
//			}
//		};
		
		graphisme.draw(getGraphics());
		
		this.setContentPane(pannel);
		this.setVisible(true);
		
	}
}

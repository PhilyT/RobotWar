package com.m1miageprojet.app;


import java.awt.Dimension;

import javax.swing.*;

import com.m1miageprojet.interfacesplugins.IAttaque;
import com.m1miageprojet.interfacesplugins.IDeplacement;
import com.m1miageprojet.interfacesplugins.IGraphisme;

public class MySwingApp extends JFrame 
{
	private MonPanel panel;
	
	public MySwingApp(IGraphisme graphisme, IDeplacement deplacement, IAttaque attaque) 
	{
		panel = new MonPanel(graphisme, deplacement, attaque);
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
	
	public void run()
	{
		while(panel.getR1().getVie() > 0 && panel.getR2().getVie() > 0) {
			this.repaint();
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(panel.getR1().getVie() > 0)
		{
			System.out.println("Robot r1 win !");
		}
		else
		{
			System.out.println("Robot r2 win !");
		}
	}
}

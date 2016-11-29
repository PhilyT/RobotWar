package com.m1miageprojet.app;


import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;

import com.m1miageprojet.interfacesplugins.IAttaque;
import com.m1miageprojet.interfacesplugins.IDeplacement;
import com.m1miageprojet.interfacesplugins.IGraphisme;

public class MySwingApp 
{
	private MonPanel panel;
	private JFrame parent;
	private boolean running;
	
	public MySwingApp(JFrame parent, IGraphisme graphisme, IDeplacement deplacement, IAttaque attaque) 
	{
		
		this.parent = parent;
		panel = new MonPanel(graphisme, deplacement, attaque);
		panel.setSize(new Dimension(500, 500));
		// Creation de la fenetre
		parent.setTitle("Robot War");
		parent.setSize(500, 500);
		parent.setLocationRelativeTo(null);
		parent.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		parent.setResizable(false);

		parent.setContentPane(panel);


		parent.setVisible(true);
	}
	
	public void setPanel(IGraphisme graphisme, IDeplacement deplacement, IAttaque attaque)
	{
		running = false;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		panel = new MonPanel(graphisme, deplacement, attaque);
		parent.setContentPane(panel);
		run();
	}
	
	public ArrayList<Robot> getRobots()
	{
		return panel.getRobots();
	}
	
	/**
	 * Lance la partie.
	 */
	public void run()
	{
		running = true;
		System.out.println("Lancement de la partie");
		while(running) {
			if (panel.getR1().getV() <= 0 || panel.getR2().getV() <= 0)
			{
				running = false;
			}
			parent.repaint();
			try {
				// TODO A modifier
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(panel.getR1().getV() <= 0 && panel.getR2().getV() <= 0)
		{
			System.out.println("execo");
		}
		else if(panel.getR1().getV() <= 0)
		{
			System.out.println("Robot r2 win !");
		}
		else if(panel.getR2().getV() <= 0)
		{
			System.out.println("Robot r1 win !");
		}
	}
}

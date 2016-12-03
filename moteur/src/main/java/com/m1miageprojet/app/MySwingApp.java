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
	private Thread thread;
	
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
		parent.setVisible(false);
		panel = new MonPanel(graphisme, deplacement, attaque);
		panel.setSize(new Dimension(500, 500));
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
		thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				running = true;
				System.out.println("Lancement de la partie");
				parent.setVisible(true);
				
				while(running) {
					if(panel.getRobots().size() < 2)
					{
						running = false;
						break;
					}
					parent.repaint();
					try {
						Thread.sleep(1000);
					} catch(InterruptedException e) {
						e.printStackTrace();
					}
				}
				if(panel.getRobots().size() == 0)
				{
					System.out.println("Execo");
				}
				else if (panel.getRobots().size() == 1)
				{
					System.out.println(panel.getRobots().get(0).getNom() + " win !");
				}
			}
		});
		thread.start();
	}
}

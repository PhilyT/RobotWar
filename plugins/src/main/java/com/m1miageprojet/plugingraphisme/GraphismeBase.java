package com.m1miageprojet.plugingraphisme;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import com.m1miageprojet.interfacesplugins.IGraphisme;
import com.m1miageprojet.interfacesplugins.IProjectile;
import com.m1miageprojet.interfacesplugins.IRobot;

public class GraphismeBase implements IGraphisme {
	
	public IGraphisme graphisme;
	
	public GraphismeBase(IGraphisme graphisme)
	{
		this.graphisme = graphisme;
		addNameIGraphisme(getClass().getName());
	}
	
	public void draw(IRobot r, Graphics g) {
		g.setColor(r.getColor());
		g.fillRect(r.getX(), r.getY(), 50, 50);
		if(graphisme!=null)
		{
			graphisme.draw(r, g);
		}
	}

	@Override
	public void addNameIGraphisme(String name) {
		// TODO Auto-generated method stub
		graphisme.addNameIGraphisme(name);
	}

	@Override
	public ArrayList<String> getListeNames() {
		// TODO Auto-generated method stub
		return graphisme.getListeNames();
	}
}

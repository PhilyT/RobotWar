package com.m1miageprojet.app;

import java.awt.Container;
import java.util.ArrayList;

public class GraphismeDeBase extends Container 
{
	ArrayList<Robot> robots;
	
	public GraphismeDeBase()
	{
		robots = new ArrayList<Robot>();
	}
	
	public ArrayList<Robot> getRobots()
	{
		return robots;
	}
}
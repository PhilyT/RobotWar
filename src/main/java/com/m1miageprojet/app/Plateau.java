package com.m1miageprojet.app;

import java.awt.Container;
import java.util.ArrayList;

public class Plateau extends Container 
{
	ArrayList<Robot> robots;
	
	public Plateau()
	{
		robots = new ArrayList<Robot>();
	}
	
	public ArrayList<Robot> getRobots()
	{
		return robots;
	}
}
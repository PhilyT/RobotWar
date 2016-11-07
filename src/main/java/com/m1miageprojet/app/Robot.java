package com.m1miageprojet.app;

public class Robot 
{
	private Object attaque;
	private Object deplacement;
	private Object graphisme;
	
	public Robot(Object dep, Object att, Object graph)
	{
		this.attaque = att;
		this.deplacement = dep;
		this.graphisme = graph;
	}
}

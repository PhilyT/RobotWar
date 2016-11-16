package com.m1miageprojet.app;

import java.awt.Graphics;

import com.m1miageprojet.interfacesplugins.IProjectile;

public class Projectile implements IProjectile {
	
	private int x1, y1, x2, y2;
	
	public Projectile(int xDep, int yDep) {
		this.x1 = xDep;
		this.y1 = yDep;
		this.x2 = xDep + 20;
		this.y2 = yDep + 20;
	}

	@Override
	public void deplace() {
		this.x1 += 30;
		this.y1 += 30;
		this.x2 += 30;
		this.y2 += 30;
	}

	@Override
	public int getX1() {
		return x1;
	}

	@Override
	public int getY1() {
		return y1;
	}

	@Override
	public int getX2() {
		return x2;
	}

	@Override
	public int getY2() {
		return y2;
	}
	
	
}

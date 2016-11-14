package com.m1miageprojet.plugindeplacement;

import java.util.Random;

import com.m1miageprojet.interfacesplugins.IDeplacement;
import com.m1miageprojet.interfacesplugins.IRobot;

public class DeplacementSimple implements IDeplacement {
	
	public void move(IRobot r) {
		Random rnd = new Random();
		int moveX = rnd.nextInt(50);
		int moveY = rnd.nextInt(50);
		
		if(moveX % 2 == 0) {
			if(r.getX() + moveX + 50 < 490) {
				r.setX(r.getX() + moveX);
				System.out.println("r.getX1() : " + r.getX());
			} else {
				r.setX(r.getX() - moveX);
				System.out.println("r.getX2() : " + r.getX());
			}
		} else {
			if(r.getX() - moveX - 50 > 10) {
				r.setX(r.getX() - moveX);
				System.out.println("r.getX3() : " + r.getX());
			} else {
				r.setX(r.getX() + moveX);
				System.out.println("r.getX4() : " + r.getX());
			}
		}
		
		if(moveY % 2 == 0) {
			if(r.getY() + moveY + 50 < 490) {
				r.setY(r.getY() + moveY);
				System.out.println("r.getY1() : " + r.getY());
			} else {
				r.setY(r.getY() - moveY);
				System.out.println("r.getY2() : " + r.getY());
			}
		} else {
			if(r.getY() - moveY - 50 > 10) {
				r.setY(r.getY() - moveY);
				System.out.println("r.getY3() : " + r.getY());
			} else {
				r.setY(r.getY() + moveY);
				System.out.println("r.getY4() : " + r.getY());
			}
		}
	}
}

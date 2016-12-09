package com.m1miageprojet.plugindeplacement;


import java.util.ArrayList;
import java.util.Random;

import com.m1miageprojet.interfacesplugins.IDeplacement;
import com.m1miageprojet.interfacesplugins.IRobot;

public class DeplacementSimple implements IDeplacement {
	

	/**
	 * Necessaire pour la serialisation
	 */
	public DeplacementSimple()
	{
		
	}
	
	public void move(IRobot r, ArrayList<IRobot> adversaires) {

		Random rnd = new Random();
		int moveX = rnd.nextInt(50);
		int moveY = rnd.nextInt(50);
		
		if(moveX % 2 == 0) {
			if(r.getX() + moveX + 50 < 490) {
				r.setX(r.getX() + moveX);
			} else {
				r.setX(r.getX() - moveX);
			}
		} else {
			if(r.getX() - moveX - 50 > 10) {
				r.setX(r.getX() - moveX);
			} else {
				r.setX(r.getX() + moveX);
			}
		}
		
		if(moveY % 2 == 0) {
			if(r.getY() + moveY + 50 < 490) {
				r.setY(r.getY() + moveY);
			} else {
				r.setY(r.getY() - moveY);
			}
		} else {
			if(r.getY() - moveY - 50 > 10) {
				r.setY(r.getY() - moveY);
			} else {
				r.setY(r.getY() + moveY);
			}
		}
	}
}

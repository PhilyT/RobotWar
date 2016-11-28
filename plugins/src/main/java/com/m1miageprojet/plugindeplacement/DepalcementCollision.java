package com.m1miageprojet.plugindeplacement;

import com.m1miageprojet.interfacesplugins.IDeplacement;
import com.m1miageprojet.interfacesplugins.IRobot;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by deptinfo on 28/11/2016.
 */
public class DepalcementCollision implements IDeplacement {

    List<IRobot> adversaires = new ArrayList<IRobot>();
    public Random rand = new Random();


    @Override
    public void move(IRobot robot, List<IRobot> robots) {
        Random random1 = new Random();
        Random random2 = new Random();
        int newY;
        int newX;
        boolean collision = false;
        ArrayList<Integer> cordonnes = new ArrayList<Integer>();
        for (int i = 0; i < robots.size(); i++) {
            if (!robots.get(i).equals(robot)) {
                this.adversaires.add(robots.get(i));
            }
        }
        int nombreInitial = 1;
        int nbRandom = random1.nextInt(20);
        if (nbRandom == 0) {
            newX = -10;
        } else {
            newX = 10;
        }

        int nouveauX = robot.getX() + newX;
        int nbRandom1 = random2.nextInt(20);

        if (nbRandom1 == 0) {
            newY = -10;
        } else {
            newY = 10;
        }
        int nouveauY = robot.getY() + newY;
        int nbr = 1;

        if (((nouveauX <= adversaires.get(0).getX()) && (nouveauX + robot.getWidth() >= adversaires.get(0).getX())) && ((nouveauY <= adversaires.get(0).getY()) && (nouveauY + robot.getHeight() >= adversaires.get(0).getY()))) {
            collision = true;
        }
        nbr++;

    }

}
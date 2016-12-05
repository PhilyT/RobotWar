package com.m1miageprojet.plugindeplacement;

import com.m1miageprojet.interfacesplugins.IDeplacement;
import com.m1miageprojet.interfacesplugins.IRobot;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by deptinfo on 05/12/2016.
 */
public class DeplacementSansCollision implements IDeplacement {


    @Override
    public void move(IRobot robot, ArrayList<IRobot> robots) {
        List<IRobot> adversaires = new ArrayList<IRobot>();
        boolean collision = false;
        Random rand = new Random();
        int addX = 0;
        int addY = 0;
        int nbr = rand.nextInt(5);
        int nbrToAdd = rand.nextInt(80);

        switch (nbr) {
            case 0:
                addY = -nbrToAdd;
                break;
            case 1:
                addY = nbrToAdd;
                break;
            case 2:
                addX = nbrToAdd;
                break;
            case 3:
                addX = -nbrToAdd;
                break;
            case 4:
                addX = 0;
                break;
        }

        int nouveauX = robot.getX() + addX;
        int nouveauY = robot.getY() + addY;
        int mouvX = nouveauX + robot.getWidth();
        int mouvY = nouveauY+robot.getHeight();

        for (int i = 0; i < robots.size(); i++) {
            if (!robots.get(i).getNom().equals(robot.getNom())) {
                adversaires.add(robots.get(i));
            }
        }
        if (adversaires.size() == 0) {
            System.out.println("Partie terminée");
        }
        else {
            for (IRobot advr : adversaires) {
                int advrsX = advr.getX();
                int advrsY = advr.getY();
                int largeur = advr.getWidth();
                int hauteur = advr.getHeight();
                if (nouveauX < advrsX + largeur &&
                        nouveauX + robot.getWidth() > advrsX &&
                        nouveauY < advrsY + hauteur &&
                        robot.getHeight() + nouveauY > advrsY) {

                    collision = true;

                }
            }
            if (!collision){
                if (mouvX>490)
                {
                    nouveauX=nouveauX-(mouvX-490);
                }
                if (mouvX<10)
                {
                    nouveauX=10;
                }
                if (mouvY>490)
                {
                    nouveauY=nouveauY-(mouvY-490);
                }
                if (mouvY<10)
                {
                    nouveauY=10;
                }
                robot.setX(nouveauX);
                robot.setY(nouveauY);
            }

            else
                {
                System.out.println(" Collision "+collision);
                switch (nbr){
                    case 0:
                        nouveauY=robot.getY()-addY;
                        break;
                    case 1:
                        nouveauY= robot.getY()-addY;
                        break;
                    case 2:
                        nouveauX=robot.getX()-addX;
                        break;
                    case 3:
                        nouveauX= robot.getX()-addX;
                        break;
                }
                robot.setX(nouveauX);
                robot.setY(nouveauY);
            }


        }
    }
}
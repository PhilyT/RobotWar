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

    public void move(IRobot robot, ArrayList<IRobot> robots) {

        Random random1 = new Random();
        int addY;
        int addX;
        boolean collision = false;
        //ArrayList<Integer> cordonnes = new ArrayList<Integer>();
        for (int i = 0; i < robots.size(); i++) {
            if (!robots.get(i).equals(robot)) {
                System.out.println("non");
                this.adversaires.add(robots.get(i));
            }

        }
        int nombreInitial = 1;
        int nbRandom = random1.nextInt(50);
        if (nbRandom == 0) {
            addX = -10;
        } else {
            addX = nbRandom;
        }

        int nouveauX = robot.getX() + addX;
        int nbRandom1 = random1.nextInt(50);

        if (nbRandom1 == 0) {
            addY = -10;
        } else {
            addY = nbRandom1;
        }
        int nouveauY = robot.getY() + addY;
        int nbr = 1;
       /* if (nouveauX < rect2.x + rect2.width &&
                rect1.x + rect1.width > rect2.x &&
                rect1.y < rect2.y + rect2.height &&
                rect1.height + rect1.y > rect2.y)*/
        if (((nouveauX <= adversaires.get(1).getX()+adversaires.get(1).getWidth()) && (nouveauX + robot.getWidth() >= adversaires.get(1).getX())) && ((nouveauY <= adversaires.get(1).getY()+adversaires.get(1).getHeight()) && (nouveauY + robot.getHeight() >= adversaires.get(1).getY()))) {
            collision = true;

        }
        if(!collision ){
            System.out.println("est la");
            int mouvX = nouveauX + robot.getWidth();
            int mouvY = nouveauY+robot.getHeight();
                if(mouvX>490) {
                    nouveauX = 10;
                }
                if (mouvY>490){
                    nouveauY=10;
                }
                    robot.setX(nouveauX);
                    robot.setY(nouveauY);
            }

        else{
            System.out.println(" Collision "+collision);
            robot.setX(10);
            robot.setY(10);
            adversaires.get(1).setX(430);
            adversaires.get(1).setY(10);
        }

    }}




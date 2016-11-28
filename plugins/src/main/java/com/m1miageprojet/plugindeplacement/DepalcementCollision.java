package com.m1miageprojet.plugindeplacement;

import com.m1miageprojet.interfacesplugins.IDeplacement;
import com.m1miageprojet.interfacesplugins.IRobot;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by deptinfo on 28/11/2016.
 */
public class DepalcementCollision implements IDeplacement {

        public Random rand = new Random();

        @Override
        public void move(IRobot robot) {
            IRobot r2 = robot.getAdversaire();
            ArrayList<int> p1 =new ArrayList<int>();
            int[] p2 = {r2.getX()+r2.getLargeur(),r2.getY()};
            int[] p3 = {r2.getX(),r2.getY()+r2.getHauteur()};
            int[] p4 = {r2.getX()+r2.,r2.getY()+r2.getHauteur()};
            int[][] liste = {p1,p2,p3,p4};
            int nb = 1;
            Random rand1 = new Random();
            int nbRandom = rand1.nextInt(2);
            int ajoutX;
            if(nbRandom == 0){
                ajoutX = -10;

            }else{
                ajoutX = 10;
            }
            int nextX = r.getX()+ajoutX;

            Random rand2 = new Random();
            int nbRandom1 = rand2.nextInt(2);
            int ajoutY;

            if(nbRandom1 == 0){
                ajoutY = -10;
            }else{
                ajoutY = 10;
            }
            int nextY = r.getY()+ajoutY;

            boolean collision = false;
            int nbr = 1;
            for(int[] point : liste){
                if(((nextX <= point[0]) && (nextX+r.getLargeur() >= point[0])) && ((nextY <= point[1]) && (nextY+r.getHauteur() >= point[1]))){
                    collision = true;
                    break;
                }
                nbr++;

            }

            if(collision == false){
                if(r.getEnergie()>=10 && rand.nextBoolean()){
                    if(nextX >= 0 && nextX < (590 - r.getLargeur())){

                        int origineR1X = nextX;
                        int origineR2X = r.getAdversaire().getX();
                        int totalX = nextX + r.getLargeur();
                        int totalY = r.getAdversaire().getY() + r.getAdversaire().getHauteur();
                        r.modifierEnergie(-10);
                        r.setX(nextX);
                    }
                }
                if(r.getEnergie()>=10 && rand.nextBoolean()){



                    if(nextY >= 0 && nextY < (570 - r.getHauteur())){
                        int origineR1Y = nextY;
                        int origineR2Y = r.getAdversaire().getY();
                        int totalY = nextY + r.getLargeur();
                        int totalX = r.getAdversaire().getX() + r.getAdversaire().getHauteur();
                        System.out.println(" leY "+nextY);
                        r.setY(nextY);
                        r.modifierEnergie(-10);
                    }
                }
            }else{
                System.out.println(" Collision "+collision);
            }

        }


    }





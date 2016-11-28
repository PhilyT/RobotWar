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
        ArrayList<Integer> cordonnes = new ArrayList<Integer>();
        for (int i = 0; i < robots.size(); i++) {
            if (!robots.get(i).equals(robot)) {
                this.adversaires.add(robots.get(i));
            }
        }
        int nombreInitial = 1;
        int nbRandom = random1.nextInt(2);
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

    }
}

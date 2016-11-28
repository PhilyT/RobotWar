/*package com.m1miageprojet.plugingraphisme;

import com.m1miageprojet.interfacesplugins.IGraphisme;
import com.m1miageprojet.interfacesplugins.IProjectile;
import com.m1miageprojet.interfacesplugins.IRobot;

import java.awt.*;
import java.util.Random;

public class GraphismeFleur implements IGraphisme {


    @Override
    public void draw(IRobot r, Graphics g) {
       /* int rayon = (int) (50/2)+10;
        int rX = (int) r.getX();
        int rY = (int) r.getY();
        g.setColor(new Color(100, 0, 0));
        g.fillOval(rX-rayon,rY-rayon,rayon*2, rayon*2);
        g.setColor(r.getColor());
        g.drawOval(rX-rayon+8,rY-rayon+8,rayon*2, rayon*2);

        }*/



/*
    @Override
    public void drawWeapon(IProjectile p, Graphics g, int direction) {

            g.setColor(Color.GREEN);

            switch (direction) {
                // attaque vers la droite
                case 0:
                    g.drawLine(p.getX(), p.getY(), p.getX() + p.getTaille(), p.getY());
                    break;
                // attaque vers le bas
                case 1:
                    g.drawLine(p.getX(), p.getY(), p.getX(), p.getY() + p.getTaille());
                    break;
                // attaque vers la gauche
                case 2:
                    g.drawLine(p.getX(), p.getY(), p.getX() - p.getTaille(), p.getY());
                    break;
                // attaque vers le haut
                case 3:
                    g.drawLine(p.getX(), p.getY(), p.getX(), p.getY() - p.getTaille());
                    break;
                default:
                    break;
            }
        }

    }
*/
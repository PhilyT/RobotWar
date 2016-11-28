package com.m1miageprojet.plugingraphisme;

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
/*
	g.setColor(Color.GRAY);
		g.drawRect((int) (b.getX() - b.getWidth() / 2),
					(int) (b.getY() + b.getWidth() / 2 + 20),
					(int) b.getWidth(), 5);

		// BAR DE VIE CONTENU
		double barWidth = b.getWidth() - 2;
		double barToFill = (barWidth / Robot.MAXIMUM_LIFE) * b.getLife();
		g.setColor(Color.GREEN);
		g.fillRect((int) (b.getX() - b.getWidth() / 2 + 1),
				(int) (b.getY() + b.getWidth() / 2 + 1 + 20),
				(int) barToFill,
				3);

		// BAR D ENERGIE CADRE
		g.setColor(Color.GRAY);
		g.drawRect((int) (b.getX() - b.getWidth() / 2),
					(int) (b.getY() + b.getWidth() / 2 + 30),
					(int) b.getWidth(), 5);

		// BAR D ENERGIE CONTENU
		double barEToFill = (barWidth / Robot.MAXIMUM_ENERGIE) * b.getEnergy();
		g.setColor(Color.BLUE);
		g.fillRect((int) (b.getX() - b.getWidth() / 2 + 1),
				(int) (b.getY() + b.getWidth() / 2 + 1 + 30),
				(int) barEToFill,
				3);

		int r = (int) (b.getHeight()/2)+15;
		int bx = (int) b.getX();
		int by = (int) b.getY();
		if (b.getChosesVues().size() > 0 ) {
			iSaw=300;
			}
			if(iSaw>0){
				g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
				iSaw--;
				g.setColor(Color.white);
				g.fillRect(bx + 50, by - 20, myInsulte.length() * 10, 20);
				g.setColor(Color.black);
				g.drawString(myInsulte, bx + 50, by - 5);
			}
		//DESSIN DU ROBOT
		g.setColor(b.getCouleur());
		g.drawOval(bx-r,by-r,r*2, r*2);
		//g.setColor(new Color(153, 0, 0));
		g.setColor(couleurFond);
		g.fillOval(bx-r,by-r,r*2, r*2);

		double direction = b.getDirectionCourante();
		//DESSIN DES YEUX
		int x1 = (int) (bx + (r-8) * Math.cos(direction-0.6));
		int y1 = (int) (by + (r-8) * Math.sin(direction-0.6));
		int x2 = (int) (bx + (r-8) * Math.cos(direction+0.6));
		int y2 = (int) (by + (r-8) * Math.sin(direction+0.6));

        g.setColor(Color.white);
        g.fillOval(x1-7,y1-7,14, 14);
        g.fillOval(x2-7,y2-7,14, 14);

        g.setColor(Color.black);
        g.fillOval(x1-4,y1-4,8, 8);
        g.fillOval(x2-4,y2-4,8, 8);

     // SABRE
        int jx = (int) (bx + (r+3) * Math.cos(direction+Math.PI/2));
        int jy = (int) (by + (r+3) * Math.sin(direction+Math.PI/2));
        int kx = (int) (bx + (r+10) * Math.cos(direction+Math.PI/2));
        int ky = (int) (by + (r+10) * Math.sin(direction+Math.PI/2));
        int lx = (int) (bx + (r+50) * Math.cos(direction));
        int ly = (int) (by + (r+50) * Math.sin(direction));

        g.setColor(Color.yellow);
        g.fillPolygon(new int[]{jx,kx,lx}, new int[]{jy,ky,ly}, 3);
        g.setColor(couleurFond);
        g.drawPolygon(new int[]{jx,kx,lx}, new int[]{jy,ky,ly}, 3);

	}
 */
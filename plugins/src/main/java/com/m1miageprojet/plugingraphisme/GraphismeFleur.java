package com.m1miageprojet.plugingraphisme;

import com.m1miageprojet.interfacesplugins.IGraphisme;
import com.m1miageprojet.interfacesplugins.IProjectile;
import com.m1miageprojet.interfacesplugins.IRobot;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class GraphismeFleur implements IGraphisme {
    public IGraphisme graphisme;
    public GraphismeFleur(IGraphisme graphisme)
    {
        this.graphisme = graphisme;
        addNameIGraphisme(getClass().getName());
    }

    @Override
    public void draw(IRobot r, Graphics g) {
        if(graphisme!=null) {
			graphisme.draw(r, g);
		}
        final int  k=10;
        int rayon = 25;
        int rX = r.getX();
        int rY = r.getY();
        g.setColor(r.getColor());
        g.fillOval(rX-rayon,rY-rayon,(rayon*2), (rayon*2));
        g.setColor(Color.WHITE);
        g.fillOval(rX-rayon+20,rY-rayon+20,(int)rayon/2, (int)rayon/2);
        g.setColor(Color.green);
        g.fillOval(rX-rayon+30,rY-rayon+30,rayon, rayon);
        int x1 = (int) (rX + (rayon) * Math.cos(Math.PI-0.6));
        int y1 = (int) (rY + (rayon) * Math.sin(Math.PI-0.6));
        int x2 = (int) (rX + (rayon-50) * Math.cos((Math.PI)-0.6));
        int y2 = (int) (rY + (rayon-50) * Math.sin((Math.PI)-0.6));
        int x3 = (int) (rX + (rayon+18) * Math.cos(Math.PI));
        int y3 = (int) (rY + (rayon+18) * Math.sin(Math.PI));
        int x4 = (int) (rX + (rayon) * Math.cos(Math.PI));
        int y4 = (int) (rY + (rayon) * Math.sin(Math.PI));
        int x5 = (int) (rX + (rayon) * Math.cos(Math.PI+0.8));
        int y5 = (int) (rY + (rayon) * Math.sin(Math.PI+0.8));
        g.setColor(Color.green);
        g.fillOval(x1,y1,rayon, rayon);
        g.setColor(Color.green);
        g.fillOval(x2,y2,rayon, rayon);
        g.setColor(Color.green);
        g.fillOval(x3,y3,rayon, rayon);
        g.setColor(Color.green);
        g.fillOval(x4-20,y4-23,rayon, rayon);
        g.setColor(Color.green);
        g.fillOval(x5-15,y5-20,rayon, rayon);
        g.setColor(Color.green);
        g.fillOval(x5+10,y5-23,rayon, rayon);
        g.setColor(Color.green);
        g.fillOval(x5+30,y5-16,rayon, rayon);
    }

    @Override
    public void addNameIGraphisme(String name) {
        graphisme.addNameIGraphisme(name);
    }

    @Override
    public ArrayList<String> getListeNames() {
        return graphisme.getListeNames();
    }

    }

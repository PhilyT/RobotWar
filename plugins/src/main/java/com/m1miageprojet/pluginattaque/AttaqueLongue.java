package com.m1miageprojet.pluginattaque;

import java.awt.Graphics;

import com.m1miageprojet.interfacesplugins.IAttaque;
import com.m1miageprojet.interfacesplugins.IGraphismeAttaque;
import com.m1miageprojet.interfacesplugins.IProjectile;
import com.m1miageprojet.interfacesplugins.IRobot;
import com.m1miageprojet.plugingraphisme.attaque.GraphismeAttaqueLongue;

public class AttaqueLongue implements IAttaque {
	
	private IGraphismeAttaque graphismeAttaque;
	
	public AttaqueLongue() {
		graphismeAttaque = new GraphismeAttaqueLongue();
	}

	@Override
	public void attaque(Graphics gr, IRobot adversaire, IProjectile p) {
		if(p.getNouveau() && p.getTireur().getE()-3>=0)
		{
			calculLaDirection(adversaire, p);
			p.getTireur().soustrairedelenergie(3);
			p.setNouveau(false);
			p.setEnMouvement(true);
			//Haut
			if(p.getDirection() >= 0 && p.getDirection() <3)
			{
				p.setX(p.getTireur().getX() + 25);
				p.setY(p.getTireur().getY());
			}
			//Droite
			else if(p.getDirection() >= 3 && p.getDirection() <6)
			{
				p.setX(p.getTireur().getX() + 50);
				p.setY(p.getTireur().getY() + 25);
			}
			//Bas
			else if(p.getDirection() >= 6 && p.getDirection() <9)
			{
				p.setX(p.getTireur().getX() + 25);
				p.setY(p.getTireur().getY() + 50);
			}
			//Gauche
			else
			{
				p.setX(p.getTireur().getX());
				p.setY(p.getTireur().getY() + 25);
			}
		}
		if(p.getEnMouvement())
		{
			if(p.getDirection() == 0 || p.getDirection() == 11)
			{
				p.setX(p.getX() - 25);
				p.setY(p.getY() - 25);
			}
			else if(p.getDirection() == 3 || p.getDirection() == 2)
			{
				p.setX(p.getX() + 25);
				p.setY(p.getY() - 25);
			}
			else if(p.getDirection() == 6 || p.getDirection() == 5)
			{
				p.setX(p.getX() + 25);
				p.setY(p.getY() + 25);
			}
			if(p.getDirection() == 9 || p.getDirection() == 8)
			{
				p.setX(p.getX() - 25);
				p.setY(p.getY() + 25);
			}
			else if(p.getDirection() == 1)
			{
				p.setY(p.getY() - 25);
			}
			else if(p.getDirection() == 4)
			{
				p.setX(p.getX() + 25);
			}
			else if(p.getDirection() == 7)
			{
				p.setY(p.getY() + 25);
			}
			else
			{
				p.setX(p.getX() - 25);
			}
			graphismeAttaque.drawWeapon(p, gr, p.getDirection());
			if(p.getAdversaire().estTouche(p.getX(), p.getY()))
			{
				touche(p);
				p.setEnMouvement(false);
				System.out.println("Robot touche { nom : "+ p.getAdversaire().getNom() +" vie : " + p.getAdversaire().getV() + " energie : " + p.getAdversaire().getE());
			}
			else
			{
				if(p.getX() > 500 || p.getY() > 500 || p.getX() < 0 || p.getY()<0)
				{
					p.setEnMouvement(false);
				}
			}
		}
	}
	
	private void calculLaDirection(IRobot adversaire, IProjectile p)
	{
		int posXCentreTireur = p.getTireur().getX()+25;
		int posYCentreTireur = p.getTireur().getY()+25;
		int posXCentreAdversaire = adversaire.getX()+25;
		int posYCentreAdversaire = adversaire.getY()+25;
		if(posXCentreAdversaire >= (posXCentreTireur-25) && posXCentreAdversaire <= (posXCentreTireur+25))
		{
			if(posYCentreAdversaire > posYCentreTireur)
			{
				p.setDirection(7);
			}
			else
			{
				p.setDirection(1);
			}
		}
		else if(posYCentreAdversaire >= (posYCentreTireur-25) && posYCentreAdversaire <= (posYCentreTireur+25))
		{
			if(posXCentreAdversaire > posXCentreTireur)
			{
				p.setDirection(4);
			}
			else
			{
				p.setDirection(10);
			}
		}
		else if(posYCentreAdversaire <= (posYCentreTireur-25) && posXCentreAdversaire <= (posXCentreTireur-25))
		{
			int rdm = (int)Math.random();
			if(rdm ==0)
			{
				p.setDirection(0);
			}
			else
			{
				p.setDirection(11);
			}
		}
		else if(posYCentreAdversaire <= (posYCentreTireur-25) && posXCentreAdversaire >= (posXCentreTireur+25))
		{
			int rdm = (int)Math.random();
			if(rdm ==0)
			{
				p.setDirection(2);
			}
			else
			{
				p.setDirection(3);
			}
		}
		else if(posYCentreAdversaire >= (posYCentreTireur-25) && posXCentreAdversaire >= (posXCentreTireur+25))
		{
			int rdm = (int)Math.random();
			if(rdm ==0)
			{
				p.setDirection(5);
			}
			else
			{
				p.setDirection(6);
			}
		}
		else
		{
			int rdm = (int)Math.random();
			if(rdm ==0)
			{
				p.setDirection(8);
			}
			else
			{
				p.setDirection(9);
			}
		}
	}

	@Override
	public void touche(IProjectile p) {
		p.getAdversaire().soustrairedelavie(3);
	}

}

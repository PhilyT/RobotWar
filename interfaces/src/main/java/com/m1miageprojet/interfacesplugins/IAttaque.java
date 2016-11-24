package com.m1miageprojet.interfacesplugins;

import java.awt.Graphics;

/**
 * Created by deptinfo on 11/11/2016.
 */
public interface IAttaque {
//    public int degats();
//    public int getNbrArme();
	public void attaque(Graphics gr, IGraphisme g, IRobot adversaire, IProjectile p);
	public void touche(IProjectile p);
}

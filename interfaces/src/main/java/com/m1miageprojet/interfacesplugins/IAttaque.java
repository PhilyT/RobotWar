package com.m1miageprojet.interfacesplugins;

import java.awt.Graphics;

/**
 * Created by deptinfo on 11/11/2016.
 */
public interface IAttaque {
//    public int degats();
//    public int getNbrArme();
	public void tirer(IProjectile p, Graphics g);
	public void deplace(IProjectile p, Graphics g);
	public void touche(IProjectile p);
}

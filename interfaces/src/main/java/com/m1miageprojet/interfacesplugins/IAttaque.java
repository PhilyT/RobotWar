package com.m1miageprojet.interfacesplugins;

import java.awt.Graphics;

/**
 * Created by deptinfo on 11/11/2016.
 */
public interface IAttaque {
//    public int degats();
//    public int getNbrArme();
	public void attaque(Graphics gr, IRobot adversaire, IProjectile p);
	
	/**
	 * Action lorsque un projectile touche un adversaire.
	 * @param p projectile touchant un adversaire
	 */
	public void touche(IProjectile p);
}

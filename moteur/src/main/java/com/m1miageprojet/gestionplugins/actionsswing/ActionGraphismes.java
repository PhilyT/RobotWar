package com.m1miageprojet.gestionplugins.actionsswing;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import com.m1miageprojet.gestionplugins.SwingRepository;

public class ActionGraphismes extends AbstractAction {

	private String nomplugins;
	private SwingRepository swing;
	private boolean selected;
	
	public ActionGraphismes(String name, SwingRepository swing)
	{
		super(name);
		nomplugins = name;
		this.swing = swing;
		selected = swing.getNomPluginsGraphismesSelectionne().contains(nomplugins);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(!selected)
    	{
			swing.getNomPluginsGraphismesSelectionne().add(nomplugins);
			selected = true;
    	}
		else
		{
			swing.getNomPluginsGraphismesSelectionne().remove(nomplugins);
			selected = false;
		}
        swing.chargement(swing.getRepo());
        swing.getOutils().encodeToFile(swing.getApp().getRobots(), "Sauvegarde.xml");

	}

}

package com.m1miageprojet.gestionplugins;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.KeyStroke;

import com.m1miageprojet.app.MySwingApp;
import com.m1miageprojet.app.Robot;
import com.m1miageprojet.interfacesplugins.IAttaque;
import com.m1miageprojet.interfacesplugins.IDeplacement;
import com.m1miageprojet.interfacesplugins.IGraphisme;
import com.m1miageprojet.interfacesplugins.IRobot;
import com.m1miageprojet.sauvegarde.XMLTools;
/**
 * Created by deptinfo on 12/11/2016.
 */

public class SwingRepository {
    String selectedpath="";
    PluginRepository repo;
    private XMLTools outils = new XMLTools();
    private MySwingApp app;
    private String nomPluginAttaqueSelectionne = "com.m1miageprojet.pluginattaque.AttaqueCourte";
    private String nomPluginDeplacementSelectionne = "com.m1miageprojet.plugindeplacement.DeplacementSimple";
    private ArrayList<String> nomPluginsGraphismesSelectionne = new ArrayList<String>();
    
    public SwingRepository()
    {
    	nomPluginsGraphismesSelectionne.add("com.m1miageprojet.plugingraphisme.GraphismeBase");
    	nomPluginsGraphismesSelectionne.add("com.m1miageprojet.plugingraphisme.BarreDeVie");
    }

    public void showFrame() {
        if (frame == null) {
            frame = new JFrame("Test menu");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setBounds(100, 100, 450, 300);
            JButton button = new JButton("charger");
            JFileChooser fc = new JFileChooser();
            fc.setCurrentDirectory(new File("."));
            fc.setDialogTitle("charger plugins");
            fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            while(fc.showOpenDialog(button)!=JFileChooser.APPROVE_OPTION){
            	
            }
            selectedpath=fc.getSelectedFile().getAbsolutePath();
        }
        buildMenu();
    }

    JFrame frame;

    @SuppressWarnings("serial")
    void buildMenu() {
        JMenuBar bar = new JMenuBar();
        frame.setJMenuBar(bar);
        JMenu fileM = new JMenu("Menu");
        //JMenuItem chargerPlugins=new JMenuItem();
        //chargerPlugins.setText("charger Plugins");
        //fileM.add(chargerPlugins);
        bar.add(fileM);
        fileM.add(new AbstractAction("Save", new ImageIcon("res/save-icon16.png")) {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                outils.encodeToFile(app.getRobots(), "Sauvegarde.xml");
            }

            @Override
            public Object getValue(String arg0) {
                if (arg0 == Action.ACCELERATOR_KEY) // cannot be changed later (use putValue when possible - not anonymous)
                    return KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK);
                return super.getValue(arg0);
            }
        });
        fileM.add(new AbstractAction("Charge") {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                ArrayList<Robot> robots  = outils.decodeFromFile("Sauvegarde.xml");
                nomPluginAttaqueSelectionne = robots.get(0).getNomAttaque();
                nomPluginDeplacementSelectionne = robots.get(0).getNomDeplacement();
                nomPluginsGraphismesSelectionne = robots.get(0).getNomsGraphismes();
                chargement(repo);
            }
        });
        JMenu Attaque = new JMenu("Attaques");
        JMenu graphisme= new JMenu("Graphismes");
        JMenu deplacement= new JMenu("Deplacements");
        bar.add(Attaque);
        bar.add(graphisme);
        bar.add(deplacement);
        try {
        	repo = new PluginRepository(new File(selectedpath)); //
            repo.load();
            chargement(repo);
            for (Class<?> c : repo.getPluginsDeplacment()) {

                deplacement.add(c.getName());
            }
            for (Class<?> c : repo.getPluginsAttaque()) {

                Attaque.add(c.getName());
            }
            for (Class<?> c : repo.getPluginsGraphisme()) {

                graphisme.add(c.getName());
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }  catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    
    /**
     * Instancie MySwingApp avec les plugins selectionnes.
     * @param repo
     */
    public void chargement(PluginRepository repo)
    {
    	try
    	{
    		IGraphisme g = new IGraphisme(){    	
            	ArrayList<String> result = new ArrayList<String>();
            	
				@Override
				public void draw(IRobot r, Graphics g) {
					
				}
				
				@Override
				public void addNameIGraphisme(String name) {
					getListeNames().add(name);				
				}

				@Override
				public ArrayList<String> getListeNames() {
					return result;
				}
            };
            IDeplacement d = (IDeplacement)repo.getPluginsDeplacementbyName(nomPluginDeplacementSelectionne).newInstance();
            IAttaque a = (IAttaque)repo.getPluginsAttaquebyName(nomPluginAttaqueSelectionne).newInstance();
            for(String s : nomPluginsGraphismesSelectionne)
            {
            	Constructor gconstruct = repo.getPluginsGraphismebyName(s).getConstructors()[0];
            	g = (IGraphisme) gconstruct.newInstance(g);
            }
            if(app == null)
            {
            	app = new MySwingApp(frame,g,d,a);
                app.run();
            }
            else
            {
            	app.setPanel(g, d, a);
            }
    	}catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public static void main(String[] args) {
        SwingRepository f = new SwingRepository();
        f.showFrame();
    }
}








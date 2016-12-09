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
import com.m1miageprojet.gestionplugins.actionsswing.ActionAttaque;
import com.m1miageprojet.gestionplugins.actionsswing.ActionDeplacement;
import com.m1miageprojet.gestionplugins.actionsswing.ActionGraphismes;
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
    private PluginRepository repo;
    private XMLTools outils = new XMLTools();
    private MySwingApp app;
    private String nomPluginAttaqueSelectionne = "com.m1miageprojet.pluginattaque.AttaqueCourte";
    private String nomPluginDeplacementSelectionne = "com.m1miageprojet.plugindeplacement.DeplacementSimple";
    private ArrayList<String> nomPluginsGraphismesSelectionne = new ArrayList<String>();
    
    public SwingRepository()
    {
    	getNomPluginsGraphismesSelectionne().add("com.m1miageprojet.plugingraphisme.GraphismeBase");
    	//nomPluginsGraphismesSelectionne.add("com.m1miageprojet.plugingraphisme.BarreDeVie");
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

                getOutils().encodeToFile(getApp().getRobots(), "Sauvegarde.xml");
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

                ArrayList<Robot> robots  = getOutils().decodeFromFile("Sauvegarde.xml");
                setNomPluginAttaqueSelectionne(robots.get(0).getNomAttaque());
                setNomPluginDeplacementSelectionne(robots.get(0).getNomDeplacement());
                setNomPluginsGraphismesSelectionne(robots.get(0).getNomsGraphismes());
                chargement(getRepo());
            }
        });
        JMenu Attaque = new JMenu("Attaques");
        JMenu graphisme= new JMenu("Graphismes");
        JMenu deplacement= new JMenu("Deplacements");
        bar.add(Attaque);
        bar.add(graphisme);
        bar.add(deplacement);
        try {
        	setRepo(new PluginRepository(new File(selectedpath))); //
            getRepo().load();
            chargement(getRepo());
            for (Class<?> c : getRepo().getPluginsDeplacment()) {

                deplacement.add(new ActionDeplacement(c.getName(), this));
            }
            for (Class<?> c : getRepo().getPluginsAttaque()) {

                Attaque.add(new ActionAttaque(c.getName(), this));
            }
            for (Class<?> c : getRepo().getPluginsGraphisme()) {

                graphisme.add(new ActionGraphismes(c.getName(), this));
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
            IDeplacement d = (IDeplacement)repo.getPluginsDeplacementbyName(getNomPluginDeplacementSelectionne()).newInstance();
            IAttaque a = (IAttaque)repo.getPluginsAttaquebyName(getNomPluginAttaqueSelectionne()).newInstance();
            for(String s : getNomPluginsGraphismesSelectionne())
            {
            	Constructor gconstruct = repo.getPluginsGraphismebyName(s).getConstructors()[0];
            	g = (IGraphisme) gconstruct.newInstance(g);
            }
            if(getApp() == null)
            {
            	setApp(new MySwingApp(frame,g,d,a));
                getApp().run();
            }
            else
            {
            	getApp().setPanel(g, d, a);
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

    public String getNomPluginAttaqueSelectionne() {
		return nomPluginAttaqueSelectionne;
	}

	public void setNomPluginAttaqueSelectionne(String nomPluginAttaqueSelectionne) {
		this.nomPluginAttaqueSelectionne = nomPluginAttaqueSelectionne;
	}

	public static void main(String[] args) {
        SwingRepository f = new SwingRepository();
        f.showFrame();
    }

	public String getNomPluginDeplacementSelectionne() {
		return nomPluginDeplacementSelectionne;
	}

	public void setNomPluginDeplacementSelectionne(String nomPluginDeplacementSelectionne) {
		this.nomPluginDeplacementSelectionne = nomPluginDeplacementSelectionne;
	}

	public ArrayList<String> getNomPluginsGraphismesSelectionne() {
		return nomPluginsGraphismesSelectionne;
	}

	public void setNomPluginsGraphismesSelectionne(ArrayList<String> nomPluginsGraphismesSelectionne) {
		this.nomPluginsGraphismesSelectionne = nomPluginsGraphismesSelectionne;
	}

	public PluginRepository getRepo() {
		return repo;
	}

	public void setRepo(PluginRepository repo) {
		this.repo = repo;
	}

	public XMLTools getOutils() {
		return outils;
	}

	public void setOutils(XMLTools outils) {
		this.outils = outils;
	}

	public MySwingApp getApp() {
		return app;
	}

	public void setApp(MySwingApp app) {
		this.app = app;
	}
}

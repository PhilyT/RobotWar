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
import com.m1miageprojet.interfacesplugins.IAttaque;
import com.m1miageprojet.interfacesplugins.IDeplacement;
import com.m1miageprojet.interfacesplugins.IGraphisme;
import com.m1miageprojet.interfacesplugins.IProjectile;
import com.m1miageprojet.interfacesplugins.IRobot;
/**
 * Created by deptinfo on 12/11/2016.
 */

public class SwingRepository {
    String selectedpath="";

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
        frame.setVisible(true);
    }

    JFrame frame;

    @SuppressWarnings("serial")
    void buildMenu() {
        JMenuBar bar = new JMenuBar();
        frame.setJMenuBar(bar);
        JMenu fileM = new JMenu("plugins");
        //JMenuItem chargerPlugins=new JMenuItem();
        //chargerPlugins.setText("charger Plugins");
        //fileM.add(chargerPlugins);
        bar.add(fileM);
        fileM.add(new AbstractAction("Save", new ImageIcon("res/save-icon16.png")) {
            @Override
            public void actionPerformed(ActionEvent arg0) {

                System.out.println("DoSaveAction:" + arg0);
            }

            @Override
            public Object getValue(String arg0) {
                if (arg0 == Action.ACCELERATOR_KEY) // cannot be changed later (use putValue when possible - not anonymous)
                    return KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK);
                return super.getValue(arg0);
            }
        });
        JMenu Attaque = new JMenu("Attaque");
        JMenu graphisme= new JMenu("graphisme");
        JMenu deplacement= new JMenu("deplacement");
        bar.add(Attaque);
        bar.add(graphisme);
        bar.add(deplacement);
        try {
        	PluginRepository repo = new PluginRepository(new File(selectedpath)); //
            ArrayList<Class<?>> resultat = (ArrayList<Class<?>>) repo.load();
            Constructor gconstruct = repo.getPluginsGraphisme().get(0).getConstructors()[0];
            IGraphisme g = (IGraphisme) gconstruct.newInstance(new IGraphisme(){

				@Override
				public void draw(IRobot r, Graphics g) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void drawWeapon(IProjectile p, Graphics g, int direction) {
					// TODO Auto-generated method stub
					
				}
            	
            });
            IDeplacement d = (IDeplacement)repo.getPluginsDeplacment().get(0).newInstance();
            IAttaque a = (IAttaque)repo.getPluginsAttaque().get(0).newInstance();
            MySwingApp app = new MySwingApp(frame,g,d,a);

            for (Class<?> c : repo.getPluginsDeplacment()) {

                deplacement.add(c.getName());
            }
            for (Class<?> c : repo.getPluginsAttaque()) {

                Attaque.add(c.getName());
            }
            for (Class<?> c : repo.getPluginsGraphisme()) {

                graphisme.add(c.getName());
            }

            app.run();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

    public static void main(String[] args) {
        SwingRepository f = new SwingRepository();
        f.showFrame();
    }
}








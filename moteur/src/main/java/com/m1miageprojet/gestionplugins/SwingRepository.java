package com.m1miageprojet.gestionplugins;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;
/**
 * Created by deptinfo on 12/11/2016.
 */

public class SwingRepository {
    String selectedpath="";

    void showFrame() {
        if (frame == null) {
            frame = new JFrame("Test menu");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setBounds(100, 100, 450, 300);
            contentPane = new JPanel();
            JButton button = new JButton("charger");
            JFileChooser fc = new JFileChooser();
            fc.setCurrentDirectory(new File("."));
            fc.setDialogTitle("charger plugins");
            fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            if(fc.showOpenDialog(button)==JFileChooser.APPROVE_OPTION){

            }
            JTable tableau= new JTable();
            selectedpath=fc.getSelectedFile().getAbsolutePath();
            System.out.println("12 "+ selectedpath);
            tableau.setSize(300,300);
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            contentPane.setLayout(new BorderLayout(0, 0));
            frame.setContentPane(contentPane);
            frame.add(tableau);
        }
        buildMenu();
        frame.setVisible(true);
    }

    JFrame frame;
    private JPanel contentPane;

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
        JMenu dynamicM = new JMenu("Dynamic");
        bar.add(dynamicM);
        try {

             System.out.println("swing repository : " +selectedpath);
             PluginRepository repo = new PluginRepository(new File(selectedpath)); //

          ArrayList<Class<?>> resultat = (ArrayList<Class<?>>) repo.load();
           System.out.println("Teeeeest "+repo.getPluginsAttaque().get(0).getName());
          //  System.out.println(resultat.isEmpty());


            for (Class<?> c : resultat) {
                // System.out.println(c.getName());
                dynamicM.add(c.getName());
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        SwingRepository f = new SwingRepository();
        f.showFrame();
    }
}








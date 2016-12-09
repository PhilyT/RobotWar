package com.m1miageprojet.plugingraphisme;

import com.m1miageprojet.interfacesplugins.IGraphisme;
import com.m1miageprojet.interfacesplugins.IRobot;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by tanouti on 04/11/2016.
 */
public class GraphismePictureLoaded implements IGraphisme {

        public IGraphisme graphisme;
        private BufferedImage pic;

        public GraphismePictureLoaded(IGraphisme graphisme) {
            this.graphisme = graphisme;
            addNameIGraphisme(getClass().getName());
            JFrame PictureChooserFrame = new JFrame("Choose an  picture");
            JFileChooser fc = new JFileChooser(new File("."));
            fc.setMultiSelectionEnabled(true);
            fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fc.setFileFilter(new FileFilter() {
                @Override
                public boolean accept(File pictureFile) {
                    if (pictureFile.isDirectory()||pictureFile.getName().endsWith(".png")|| pictureFile.getName().endsWith(".jpg")  || pictureFile.getName().endsWith(".jpeg")|| pictureFile.getName().endsWith(".gif"))
                        return true;
                    else
                        return false;
                }
                @Override
                public String getDescription() {
                    return null;
                }
            });
            if (fc.showOpenDialog(PictureChooserFrame) == JFileChooser.APPROVE_OPTION) {
                try {
                    this.pic= ImageIO.read(fc.getSelectedFile());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    @Override
    public void draw(IRobot r, Graphics g) {
    	if(graphisme!=null) {
			graphisme.draw(r, g);
		}
        g.drawImage(pic, r.getX(), r.getY(), r.getHeight(), r.getWidth(), null);
        g.setFont(new Font("SansSerif", Font.PLAIN, 10));
        g.setColor(r.getColor());
        g.drawString(r.getNom(),r.getX(),r.getY());
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



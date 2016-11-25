/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author HJH
 */

public class RotateImage extends Applet {

    public Image image;
//    float width = image.getWidth(null);
//    float height = image.getHeight(null);
    
//    BufferedImage bimg=(BufferedImage) image; 
//    int width          = bimg.getWidth();
//    int height         = bimg.getHeight();
//    AffineTransform identity = new AffineTransform();

//    private URL getURL(String filename) {
//        URL url = null;
//        try {
//            url = this.getClass().getResource(filename);
//        } catch (Exception e) {
//        }
//        return url;
//    }

    @Override
    public void init() {
        try {
            image = ImageIO.read((ClassLoader.getSystemResource(
                    "Resources/"
                            + "Scout"
                            + "Y"
                            + ".png")));
                    } catch (IOException ex) {
            Logger.getLogger(RotateImage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform trans = new AffineTransform();
//        trans.setTransform(identity);
//        trans.rotate(22.2);
//        trans.rotate(5, 5);
//        trans.rotate(Math.toRadians(666), width, height);

//System.out.println(image.getWidth(null));
        trans.rotate(5.14);
        g2d.drawImage(image, trans, null);
        g2d.dispose();
    }
}

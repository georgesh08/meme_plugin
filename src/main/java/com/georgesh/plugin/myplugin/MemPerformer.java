package com.georgesh.plugin.myplugin;

import javax.swing.*;

import java.awt.*;

public class MemPerformer extends JFrame {
    public MemPerformer() {
        super() ;
        setTitle( "Chill time" ) ;
        Panel p = new Panel();
        setContentPane(p);
        this.setSize(p.getWidth(), p.getHeight());
        this.setLocationRelativeTo(null);
        setVisible(true) ;
    }

    public static class Panel extends JPanel {
        private final Image image;
        public Panel() {
            setLayout(new BorderLayout()) ;
            Provider provider = new Provider();
            image = provider.getRandomMeme();
            if( image == null ) {
                System.out.println( "Image is null" );
            }
            int width = image.getWidth(this)/2;
            int height = image.getHeight(this)/2;
            this.setSize(width, height);
        }
        public void drawBackground(Graphics g) {
            int width = this.getWidth();
            int height = this.getHeight();
            g.drawImage(image, 0, 0, width, height, this);
        }
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            drawBackground(graphics);
        }
    }



    public static void main() {
        new MemPerformer();
    }
}

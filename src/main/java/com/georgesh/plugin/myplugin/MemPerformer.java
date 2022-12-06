package com.georgesh.plugin.myplugin;

import javax.swing.*;

import java.awt.*;

public class MemPerformer extends JFrame {
    public MemPerformer() {
        super() ;
        setTitle( "Chill time" ) ;
        Panel p = new Panel();
        setContentPane(p); ;
        setExtendedState(JFrame.MAXIMIZED_BOTH);
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
        }
        public void drawBackground(Graphics g) {
            int w = getWidth() ;
            int h = getHeight() ;
            int width = image.getWidth( this ) ;
            int height = image.getHeight( this ) ;
            for( int i = 0 ; i < w ; i += width ) {
                for( int j = 0 ; j < h ; j += height ) {
                    g.drawImage(image, i , j , this ) ;
                }
            }
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

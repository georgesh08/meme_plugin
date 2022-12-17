package com.georgesh.plugin.myplugin;

import jnr.a64asm.Mem;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Provider {
    MemPerformer performer;
    private List<BufferedImage> images = new ArrayList<>();
    public Provider(){
        getMemesFromDirectory();
    }
    public BufferedImage getRandomMeme(){
        Random random = new Random();
        int randNumber = random.nextInt(images.size());
        return images.get(randNumber);
    }

    public void display(){
        if (performer == null){
            performer = new MemPerformer();
        }
        else {
            performer.dispose();
            performer = new MemPerformer();
        }
    }

    private void getMemesFromDirectory(){
        for (int i = 1; i < 9; i++){
            try {
                images.add(ImageIO.read(Objects.requireNonNull(Provider.class
                        .getResource("/memes/" + i + ".jpg"))));
            }

            catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

package com.georgesh.plugin.myplugin;

import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.openapi.vfs.VfsUtilCore;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Provider {
    MemPerformer performer;
    private List<BufferedImage> images = new ArrayList<>();
    public Provider() throws IOException {
        String folderName = Adapter.getInstance().GetFolder();
        if (folderName.equals("default")){
            getMemesFromDefaultDirectory();
        }
        else{
            getMemesFromCustomDirectory(folderName);
        }
    }

    public BufferedImage getRandomMeme(){
        Random random = new Random();
        int randNumber = random.nextInt(images.size());
        return images.get(randNumber);
    }

    public void display() throws IOException {
        if (performer == null){
            performer = new MemPerformer();
        }
        else {
            performer.dispose();
            performer = new MemPerformer();
        }
    }

    private void getMemesFromCustomDirectory(String folder) throws IOException {
        var directory = VfsUtil.findFile(Path.of(folder), true);
        directory.refresh(false, true);
        var files = directory.getChildren();
        for (int i = 0; i < files.length; ++i){
            images.add(ImageIO.read(files[i].getInputStream()));
        }
    }

    private void getMemesFromDefaultDirectory(){
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

package com.georgesh.plugin.myplugin;

public class Adapter {
    private static Adapter instance = new Adapter();
    private static String folder;

    private Adapter(){}

    public String GetFolder() {
        return folder;
    }

    public void SetFolder(String value) {
        folder = value;
    }

    public static Adapter getInstance(){
        if (instance == null){
            instance = new Adapter();
        }
        return instance;
    }
}

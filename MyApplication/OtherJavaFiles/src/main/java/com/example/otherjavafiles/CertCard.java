package com.example.otherjavafiles;

import java.io.File;
import java.io.IOException;

public class CertCard {
    private File imgFront = null;
    private File imgBack = null;
    private String type;

    //Constructor takes the file location/name of the front and back images of the card, and the type of card being saved
    CertCard(String fileFront, String fileBack, String type){
        setCard(fileFront, fileBack);
        setType(type);
    }

    private void setCard(String fileFront, String fileBack){
        try {
            imgFront = new File(fileFront);
            imgBack = new File(fileBack);
            if(!imgFront.exists()||!imgBack.exists())
                throw new IOException("File read error, check file path/name");
            System.out.println("File read successful");
        }
        catch(IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public File getCardFront() {
        return imgFront;
    }

    public File getCardBack() {
        return imgBack;
    }

    private void setType(String type) {
        this.type = type;
    }

    public String getType() {
        String temp = type;
        return temp;
    }

    public String toString() {
        return "Image Type: " + type;
    }
}
package com.example.ratemyplateuploadplate;

import android.graphics.Bitmap;

public class Plate {
    private String name;
    private String caption;
    private Bitmap image;

    public Plate(String name, String caption, Bitmap image){
        this.name = name;
        this.caption = caption;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}

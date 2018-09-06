package com.semicolonindia.navigationdrawertask3.model;

/**
 * Created by RANJAN SINGH on 8/16/2017.
 */

public class ItemObject {

    private int image;
    private String name;

    public ItemObject(int image, String name) {
        this.image = image;
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

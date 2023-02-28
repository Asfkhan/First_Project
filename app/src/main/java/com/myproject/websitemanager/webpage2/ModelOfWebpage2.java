package com.myproject.websitemanager.webpage2;

public class ModelOfWebpage2 {
    private int image;
    private String name;
    private int color;
    private boolean isclicked;

    public ModelOfWebpage2() {
    }

    public ModelOfWebpage2(int image, String name, int color, boolean isclicked) {
        this.image = image;
        this.name = name;
        this.color = color;
        this.isclicked = isclicked;
    }

    public int getimage() {
        return image;
    }

    public void setimage(int image) {
        this.image = image;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public boolean isIsclicked() {
        return isclicked;
    }

    public void setIsclicked(boolean isclicked) {
        this.isclicked = isclicked;
    }
}

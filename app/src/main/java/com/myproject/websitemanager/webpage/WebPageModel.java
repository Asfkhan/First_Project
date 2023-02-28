package com.myproject.websitemanager.webpage;

public class WebPageModel {
    private int themeimage;
    private String themename;
    private int color;
    private boolean isclicked;

    public WebPageModel() {
    }

    public int getThemeimage() {
        return themeimage;
    }

    public void setThemeimage(int themeimage) {
        this.themeimage = themeimage;
    }

    public WebPageModel(int themeimage,String themename,boolean isclicked) {
        this.themename = themename;
        this.isclicked = isclicked;
        this.themeimage = themeimage;
    }

    public String getThemename() {
        return themename;
    }

    public int setThemename(int color) {
        this.color = color;
        return color;
    }

    public boolean isIsclicked() {
        return isclicked;
    }

    public void setIsclicked(boolean isclicked) {
        this.isclicked = isclicked;
    }
}

package com.myproject.websitemanager.ui.home.createwebsiteactivity.ui.set_theme;

public class SliderLayoutView {
    private int canvaslayout;
    private String templatename;

    public SliderLayoutView(int canvaslayout, String templatename) {
        this.canvaslayout = canvaslayout;
        this.templatename = templatename;
    }


    public void setCanvaslayout(int canvaslayout) {
        this.canvaslayout = canvaslayout;
    }

    public int getCanvaslayout() {
        return canvaslayout;
    }


    public String getTemplatename() {
        return templatename;
    }

    public void setTemplatename(String templatename) {
        this.templatename = templatename;
    }
}
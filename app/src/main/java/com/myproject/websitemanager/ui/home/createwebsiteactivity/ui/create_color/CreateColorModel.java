package com.myproject.websitemanager.ui.home.createwebsiteactivity.ui.create_color;

public class CreateColorModel{

    private int scrollviewbackgroundcolor;
    private boolean okpressed;

    public CreateColorModel() {
    }

    public int getScrollviewbackgroundcolor() {
        return scrollviewbackgroundcolor;
    }

    public void setScrollviewbackgroundcolor(int scrollviewbackgroundcolor) {
        this.scrollviewbackgroundcolor = scrollviewbackgroundcolor;
    }
    public CreateColorModel(int scrollviewbackgroundcolor, boolean okpressed) {
        this.scrollviewbackgroundcolor = scrollviewbackgroundcolor;
        this.okpressed = okpressed;
    }

    public boolean isOkpressed() {
        return okpressed;
    }

    public void setOkpressed(boolean okpressed) {
        this.okpressed = okpressed;
    }


}
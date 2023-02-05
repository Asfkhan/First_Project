package com.myproject.websitemanager;

public class MyColorList {
  private   String colorDiscription ;
   private Integer colorpreview ;

    public MyColorList(String colorDiscription,Integer colorpreview)
    {
        this.colorDiscription = colorDiscription;
        this.colorpreview = colorpreview;
    }

    public String getColorDiscription() {
        return colorDiscription;
    }

    public void setColorDiscription(String colorDiscription) {
        this.colorDiscription = colorDiscription;
    }

    public Integer getColorpreview() {
        return colorpreview;
    }

    public void setColorpreview(Integer colorpreview) {
        this.colorpreview = colorpreview;
    }
}

package com.myproject.websitemanager;


public class DataStoredClass {
    private String toptexteditTxt;
    private String headingeditText;
    private String descripeditText;
    private String description2edit;
    private String about_edittxt_variable;
    private String contact_us_editxt_var;
    private String gmaildedittxt_var;
    private String bannerimg;
    private String post1img;
    private String post2img;

    private String headingSectionColor;

    private String headingTextColor;

    private String tableSectionColor;
    private String instaLinks;

    private String twitterLinks;

    private String whatsAppLinks;

    private String layout1Color;

    private String layout2Color;

    private String headingfontSize;

    public String getHeadingfontSize() {
        return headingfontSize;
    }

    public String getLayout1Color() {
        return layout1Color;
    }

    public String getLayout2Color() {
        return layout2Color;
    }

    public String getHeadingSectionColor() {
        return headingSectionColor;
    }

    public String getHeadingTextColor() {
        return headingTextColor;
    }

    public String getTableSectionColor() {
        return tableSectionColor;
    }

    public DataStoredClass( String toptexteditTxt, String headingeditText,
                           String descripeditText, String description2edit,
                           String about_edittxt_variable, String contact_us_editxt_var, String gmaildedittxt_var,
                           String bannerimg, String post1img, String post2img, String instaLinks,
                           String twitterLinks, String whatsAppLinks, String headingSectionColor, String headingTextColor, String tableSectionColor
    , String layout1Color, String layout2Color, String headingfontSize) {
        this.toptexteditTxt = toptexteditTxt;
        this.headingeditText = headingeditText;
        this.descripeditText = descripeditText;
        this.description2edit = description2edit;
        this.about_edittxt_variable = about_edittxt_variable;
        this.contact_us_editxt_var = contact_us_editxt_var;
        this.gmaildedittxt_var = gmaildedittxt_var;
        this.bannerimg = bannerimg;
        this.post1img = post1img;
        this.post2img = post2img;
        this.instaLinks = instaLinks;
        this.twitterLinks = twitterLinks;
        this.whatsAppLinks = whatsAppLinks;
        this.headingSectionColor = headingSectionColor;
        this.headingTextColor = headingTextColor;
        this.tableSectionColor = tableSectionColor;
        this.layout1Color = layout1Color;
        this.layout2Color = layout2Color;
        this.headingfontSize = headingfontSize;
    }

    public String getToptexteditTxt() {
        return toptexteditTxt;
    }

    public String getHeadingeditText() {
        return headingeditText;
    }

    public String getDescripeditText() {
        return descripeditText;
    }

    public String getDescription2edit() {
        return description2edit;
    }

    public String getAbout_edittxt_variable() {
        return about_edittxt_variable;
    }

    public String getContact_us_editxt_var() {
        return contact_us_editxt_var;
    }

    public String getGmaildedittxt_var() {
        return gmaildedittxt_var;
    }

    public String getBannerimg() {
        return bannerimg;
    }

    public String getPost1img() {
        return post1img;
    }

    public String getPost2img() {
        return post2img;
    }

    public String getInstaLinks() {
        return instaLinks;
    }

    public String getTwitterLinks() {
        return twitterLinks;
    }

    public String getWhatsAppLinks() {
        return whatsAppLinks;
    }

    public DataStoredClass() {
    }
}

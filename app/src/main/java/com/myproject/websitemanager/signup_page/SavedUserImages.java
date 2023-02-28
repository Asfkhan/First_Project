package com.myproject.websitemanager.signup_page;

public class SavedUserImages {
  private   String userimg;

    public String getUserimg() {
        return userimg;
    }

    public String getUserName() {
        return userName;
    }

    private String userName;

    public String getEmail() {
        return email;
    }

    private String email;

    public SavedUserImages(String userimg, String userName, String email) {
        this.userimg = userimg;
        this.userName = userName;
        this.email = email;
    }

    public SavedUserImages() {

    }
    }


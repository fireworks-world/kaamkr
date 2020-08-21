package com.blakoo;

public class LogoStoreHomePage {

    //** Init. store logo in home page.

    int image;
    String name;

    public LogoStoreHomePage(int image, String name) {
        this.image = image;
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }
}

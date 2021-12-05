package com.davronxolboyev.app.walpapersapk.model;

/**
 * Created by Davron Xolboyev on 30.11.2021.
 */

public class ONwallpapers {

    int id;
    String themeName;
    String image;

    public ONwallpapers(int id, String themeName, String image) {
        this.id = id;
        this.themeName = themeName;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getThemeName() {
        return themeName;
    }

    public String getImage() {
        return image;
    }
}

package com.davronxolboyev.app.walpapersapk.model;

/**
 * Created by Davron Xolboyev on 05.12.2021.
 */
public class OFFwallpapers {
    int id;
    String themeName;
    int image;

    public OFFwallpapers(int id, String themeName, int image) {
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

    public int getImage() {
        return image;
    }
}

package com.example.trabalhoimplementacao.model;

import android.widget.ImageView;

import java.util.List;
import java.util.ArrayList;

public class Restaurant {

    private String name;
    private String description;
    private int image;
    private Franchise[] franchiseList;

    public Restaurant(String name, String description, int image, Franchise[] franchiseList) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.franchiseList = franchiseList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Franchise[] getFranchiseList() {
        return franchiseList;
    }

    public void setFranchiseList(Franchise[] franchiseList) {
        this.franchiseList = franchiseList;
    }
}

package com.example.trabalhoimplementacao.model;

public class Franchise {

    private String name;
    private String address;
    private String city;
    private int image;

    public Franchise(String name, String address, String city, int image) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public int getImage() {
        return image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setImage(int image) {
        this.image = image;
    }
}

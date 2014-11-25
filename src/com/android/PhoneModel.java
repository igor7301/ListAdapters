package com.android;

/**
 * Created by v-ikomarov on 11/17/2014.
 */
public class PhoneModel {
    private String name;
    private String model;
    private String price;

    public PhoneModel(String name, String model, String price) {
        this.model = model;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

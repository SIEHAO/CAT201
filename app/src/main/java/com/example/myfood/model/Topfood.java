package com.example.myfood.model;

public class Topfood {

    String name;
    String price;
    Integer image_source;

    public Topfood(String name, String price, Integer image_link) {
        this.name = name;
        this.price = price;
        this.image_source = image_link;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public Integer getImage_source() {
        return image_source;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setImage_source(Integer image_source) {
        this.image_source = image_source;
    }
}
// whatever comments

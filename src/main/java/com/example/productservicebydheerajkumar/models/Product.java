package com.example.productservicebydheerajkumar.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private long id;
    private String title;
    private String description;
    private double price;
    private String imageUrl;
    private String category;


    //no args constructor
    public Product() {
    }

    //all args constructor

    public Product(long id, String title, String description, double price, String imageUrl, String category) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
        this.category = category;
    }

}

package com.example.productservicebydheerajkumar.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category {
    private long id;
    private String name;

    //no args constructor

    public Category() {
    }


    //all args constructor

    public Category(long id, String name) {
        this.id = id;
        this.name = name;
    }
}

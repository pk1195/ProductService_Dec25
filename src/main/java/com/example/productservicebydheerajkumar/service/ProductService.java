package com.example.productservicebydheerajkumar.service;

import com.example.productservicebydheerajkumar.exceptions.ProductNotFoundException;
import com.example.productservicebydheerajkumar.models.Product;

import java.util.List;

public interface ProductService {

    //get single product
    Product getSingleProduct(Long id) throws ProductNotFoundException;

    //get all products
    List<Product> getAllProducts();

    //create product
    Product createProduct(Long id, String title, String description, Double price, String imageUrl);

    //update product
    Product updateProduct(Long id, String title, String description, Double price, String imageUrl);

    //delete product
    Product deleteProduct(Long id);

}

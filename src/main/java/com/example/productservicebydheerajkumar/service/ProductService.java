package com.example.productservicebydheerajkumar.service;

import com.example.productservicebydheerajkumar.models.Product;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long id);
    List<Product> getAllProducts();
    Product createProduct(Product product);


}

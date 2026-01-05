package com.example.productservicebydheerajkumar.service;

import com.example.productservicebydheerajkumar.exceptions.ProductNotFoundException;
import com.example.productservicebydheerajkumar.models.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {

    //get single product
    Product getSingleProduct(Long id) throws ProductNotFoundException;

    //get product by title
    List<Product> getProductByCategoryTitle(String categoryTitle);

    //get all products
    Page<Product> getAllProducts(int pageNumber, int pageSize, String fieldName);

    List<Product> getAllProducts();

    //create product
    Product createProduct(Long id, String title, String description, Double price, String category);

    //update product
    Product updateProduct(Long id, String title, String description, Double price, String imageUrl);

    //delete product
    Product deleteProduct(Long id);

}

package com.example.productservicebydheerajkumar.controller;

//how will spring know that this is a controller class or this is api class for that we use annotation called @RestController

import com.example.productservicebydheerajkumar.models.Product;
import com.example.productservicebydheerajkumar.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
//crud apis

    // a link is created her to connect controller with service layer
    private ProductService productService;

    //creating constructor for product service


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //this will help to create product
    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {
       Product p = productService.createProduct(product.getId(), product.getTitle(), product.getDescription(),
                product.getPrice(),product.getCategory());
         return p;
    }

    //this will help to get product by id
    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        System.out.println("Starting the api here");
        Product p = productService.getSingleProduct(id);
        System.out.println("Ending the api here");
        return p;
    }


    // this will help to update product
    public void updateProduct(Product product) {
    }

    //this will help to delete product by id
    public void deleteProduct(Long id) {
    }
}

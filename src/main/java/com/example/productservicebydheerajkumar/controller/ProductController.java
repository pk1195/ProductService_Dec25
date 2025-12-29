package com.example.productservicebydheerajkumar.controller;

//how will spring know that this is a controller class or this is api class for that we use annotation called @RestController

import com.example.productservicebydheerajkumar.models.Product;
import com.example.productservicebydheerajkumar.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //get all products using List
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // this will help to update product
    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
    return productService.updateProduct(id,
            product.getTitle(),
            product.getDescription(),
            product.getPrice(),
            product.getCategory()
           // product.getImage()
    );
    }

    //this will help to delete product by id
    @DeleteMapping("/products/{id}")
    public Product deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }
}

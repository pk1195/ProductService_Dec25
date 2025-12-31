package com.example.productservicebydheerajkumar.controller;

//how will spring know that this is a controller class or this is api class for that we use annotation called @RestController

import com.example.productservicebydheerajkumar.dto.ErrorDto;
import com.example.productservicebydheerajkumar.exceptions.ProductNotFoundException;
import com.example.productservicebydheerajkumar.models.Product;
import com.example.productservicebydheerajkumar.repository.CategoryRepository;
import com.example.productservicebydheerajkumar.service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class ProductController {
    private final CategoryRepository categoryRepository;
//crud apis

    // a link is created her to connect controller with service layer
    private ProductService productService;
    List<Product> products = new ArrayList<>();

    //creating constructor for product service
    public ProductController(@Qualifier("SelfProductService") ProductService productService, CategoryRepository categoryRepository) {

        this.productService = productService;
        this.categoryRepository = categoryRepository;
    }

    //this will help to create product
    @PostMapping("/products")
    public Product createProduct(@RequestBody Product product) {
       Product p = productService.createProduct(product.getId(),
                product.getTitle(), product.getDescription(),
                product.getPrice(), product.getCategory().getTitle());

        return p;
    }

    //this will help to get product by id
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
        System.out.println("Starting the api here");
        Product p = productService.getSingleProduct(id);
        System.out.println("Ending the api here");

        ResponseEntity<Product> response = new ResponseEntity<>(
                p, HttpStatus.OK
        );

        return response;
    }

    //handling exception using @ExceptionHandler
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDto> handleProductNotFoundException(Exception e) {
        //create object of error dto
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMessage(e.getMessage());

        ResponseEntity<ErrorDto> response = new ResponseEntity<>(
                errorDto, HttpStatus.NOT_FOUND
        );
        return response;
    }

    //get all products using List
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    //get product by category title
    @GetMapping("/products/category/title/{categoryTitle}")
    public ResponseEntity<List<Product>> getProductByCategoryTitle(@PathVariable("categoryTitle") String categoryTitle)  {
        List<Product> products = productService.getProductByCategoryTitle(categoryTitle);
        return ResponseEntity.ok(products);
    }
    // this will help to update product
    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
    return productService.updateProduct(id,
            product.getTitle(),
            product.getDescription(),
            product.getPrice(),
            String.valueOf(product.getCategory())
           // product.getImage()
    );
    }

    //this will help to delete product by id
    @DeleteMapping("/products/{id}")
    public Product deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);



    }
}

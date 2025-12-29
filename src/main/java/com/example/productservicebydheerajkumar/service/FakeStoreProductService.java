package com.example.productservicebydheerajkumar.service;

import com.example.productservicebydheerajkumar.dto.FakeStoreProductDto;
import com.example.productservicebydheerajkumar.exceptions.ProductNotFoundException;
import com.example.productservicebydheerajkumar.models.Category;
import com.example.productservicebydheerajkumar.models.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
//@Primary
public class FakeStoreProductService implements ProductService{

    //bean is called from application configuration class
    private RestTemplate restTemplate;
    private String category;

    //creating constructor for rest template
    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(Long id) throws ProductNotFoundException{
        System.out.println("Inside FakeStoreProductApi service");
        //here it will map json response to FakeStoreProductDto class
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/"
                +id, FakeStoreProductDto.class);
      //  System.out.println("Response from FakeStore API: "+fakeStoreProductDto.toString());

        if(fakeStoreProductDto == null){
            throw new ProductNotFoundException("Product not found with id: "+id);
        }

        return fakeStoreProductDto.getProduct();
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDto[] fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/",
                FakeStoreProductDto[].class);

        List<Product> products = new ArrayList<>();
        for (FakeStoreProductDto dto : fakeStoreProductDto) {
            products.add(dto.getProduct());
        }
        return products;
    }

    @Override
    public Product createProduct(Long id, String title, String description, Double price, String imageUrl) {
        //here we are creating object of FakeStoreProductDto and setting values
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setId(id);
        fakeStoreProductDto.setTitle(title);
        fakeStoreProductDto.setDescription(description);
        fakeStoreProductDto.setCategory(category);
        fakeStoreProductDto.setPrice(price);
        fakeStoreProductDto.setImage(imageUrl);

        //
        FakeStoreProductDto response = restTemplate.postForObject("https://fakestoreapi.com/products",
                fakeStoreProductDto, FakeStoreProductDto.class);

        return response.getProduct();
    }

    // update product is done using put method

    public Product updateProduct(Long id, String title, String description, Double price, String image) {
        // Update product logic can be implemented here
        //creating DTO object
        FakeStoreProductDto dto = new FakeStoreProductDto();
        dto.setCategory(category);
        dto.setId(id);
        dto.setTitle(title);
        dto.setDescription(description);
        dto.setPrice(price);
        dto.setImage(image);

        //wrap DTO in HttpEntity and send PUT request
        HttpEntity<FakeStoreProductDto> request =
                new HttpEntity<>(dto);

//calling fakestore PUT api using rest template
        ResponseEntity<FakeStoreProductDto> response = restTemplate.exchange("https://fakestoreapi.com/products/" +id,
                 HttpMethod.PUT,request, FakeStoreProductDto.class);
        return response.getBody().getProduct();
    }

    // delete product is done using delete method

    @DeleteMapping("/products/{id}")
    public Product deleteProduct(Long id) {
        // Delete product logic can be implemented here
        ResponseEntity <FakeStoreProductDto> response = restTemplate.exchange("https://fakestoreapi.com/products/" +id,
                HttpMethod.DELETE,null,
                FakeStoreProductDto.class);
        return response.getBody().getProduct();
    }
}

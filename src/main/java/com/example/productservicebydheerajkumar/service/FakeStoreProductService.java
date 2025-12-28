package com.example.productservicebydheerajkumar.service;

import com.example.productservicebydheerajkumar.dto.FakeStoreProductDto;
import com.example.productservicebydheerajkumar.models.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreProductService implements ProductService{

    //bean is called from application configuration class
    private RestTemplate restTemplate;

    //creating constructor for rest template
    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(Long id) {
        System.out.println("Inside FakeStoreProductApi service");
        //here it will map json response to FakeStoreProductDto class
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/"+id, FakeStoreProductDto.class);
        System.out.println("Response from FakeStore API: "+fakeStoreProductDto.toString());
        return fakeStoreProductDto.getProduct();
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }
}

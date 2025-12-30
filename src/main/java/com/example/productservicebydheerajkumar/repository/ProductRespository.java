package com.example.productservicebydheerajkumar.repository;

import com.example.productservicebydheerajkumar.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRespository extends JpaRepository<Product, Long> {
    //save, get, getall, delete, update

    //update is handled by save method itself
    Product save(Product product);

    //custom method to find product by title
    Product findByTitle(String title);

    //custom method to find product by description
    Product findByDescription(String description);
}

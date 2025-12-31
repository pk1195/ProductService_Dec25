package com.example.productservicebydheerajkumar.repository;

import com.example.productservicebydheerajkumar.models.Category;
import com.example.productservicebydheerajkumar.models.Product;
import org.hibernate.boot.jaxb.mapping.spi.JaxbPersistentAttribute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CategoryRepository extends JpaRepository<Category,Long> {

    //custom method to find category by title
//    static Optional<Category> findByTitle(String title) {
//        return null;
//    }

     Optional<Category> findByTitle(String categoryTitle);


}

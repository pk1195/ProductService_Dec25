package com.example.productservicebydheerajkumar.repository;

import com.example.productservicebydheerajkumar.models.Category;
import com.example.productservicebydheerajkumar.models.Product;
import org.hibernate.boot.jaxb.mapping.spi.JaxbPersistentAttribute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    //custom method to find category by title
    Category findByTitle(String title);
}

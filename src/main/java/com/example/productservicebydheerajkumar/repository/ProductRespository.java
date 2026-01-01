package com.example.productservicebydheerajkumar.repository;

import com.example.productservicebydheerajkumar.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRespository extends JpaRepository<Product, Long> {
    //save, get, getall, delete, update

    //update is handled by save method itself
    Product save(Product product);

    //custom method to find product by category title
    List<Product> findByCategoryTitle(String categoryTitle);

    //custom method to find product by description
    Product findByDescription(String description);

    //HQL implementation can be done here if needed
//@Query - here we tell spring that this is defined by us
    //here Product P is our class name not table name
    @Query("select p from Product p where p.category.id =: categoryId ")

    //@Param is used to tell spring that the value of categoryId used is from the method parameter
    List<Product> getProductByCategoryId(@Param("categoryId") Long categoryId);

    List<Product> getProductByCategoryId(long l);

    //Implement Native Query
    @Query(value = "SELECT * FROM product p WHERE p.category_id = :categoryId", nativeQuery = true)

    List<Product> getProductByCategoryIdNativeQueries(@Param("categoryId") Long categoryId);

    //Projection Interface
    @Query("select p.title as title, p.id as id from Product p where p.category.id = :categoryId ")

    List<ProductProjection> getProductByCategoryIdUsingProjection(@Param("categoryId") Long categoryId);
}

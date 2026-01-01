package com.example.productservicebydheerajkumar;

import com.example.productservicebydheerajkumar.models.Category;
import com.example.productservicebydheerajkumar.models.Product;
import com.example.productservicebydheerajkumar.repository.CategoryRepository;
import com.example.productservicebydheerajkumar.repository.ProductProjection;
import com.example.productservicebydheerajkumar.repository.ProductRespository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
class ProductServiceByDheerajKumarApplicationTests {

    @Autowired
    private ProductRespository productRespository;

    @Autowired
    private CategoryRepository categoryRepository;


    @Test
    void contextLoads() {
    }

    @Test
    void testQueries() {
        // Add test cases for custom queries in ProductRepository
        //  List<Product> allProducts = productRespository.getProductByCategoryId(1L);   //for HQL
//        List<Product> allProducts = productRespository.getProductByCategoryIdNativeQueries(1L); // for Native Query
//        for(Product product : allProducts) {
//            System.out.println(product);
//        }

        //projecttion
        List<ProductProjection> allProductsProjection = productRespository.getProductByCategoryIdUsingProjection(1L);
        System.out.println(allProductsProjection.get(0).getId());
    }

    @Test
    void fetchTypeTest()
    {
        Category cat = categoryRepository.findById(2L).get();
        System.out.println(cat);
        System.out.println("We are done here with eager fetch type");

        List<Product> products = cat.getProducts();
        System.out.println("Size of products is "+products.size());

        System.out.println("We are done here with lazy fetch type");
    }
}

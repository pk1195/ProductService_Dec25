package com.example.productservicebydheerajkumar.service;

import com.example.productservicebydheerajkumar.exceptions.ProductNotFoundException;
import com.example.productservicebydheerajkumar.models.Category;
import com.example.productservicebydheerajkumar.models.Product;
import com.example.productservicebydheerajkumar.repository.CategoryRepository;
import com.example.productservicebydheerajkumar.repository.ProductRespository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("SelfProductService")
public class SelfProductService implements ProductService{

    //to interact with database we need repository and object of it
    private ProductRespository productRespository;
    private CategoryRepository categoryRepository;

    //defining constructor for dependency injection for repositories
    public SelfProductService(ProductRespository productRespository, CategoryRepository categoryRepository) {
        this.productRespository = productRespository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getSingleProduct(Long id) throws ProductNotFoundException {
        //optional is a container object which may or may not contain a non-null value
        Optional<Product> p = productRespository.findById(id);
        if(p.isPresent())
        {
            return p.get();
        }
        else
        {
            throw new ProductNotFoundException("Product with id "+id+" not found");
        }
    }

    @Override
    public List<Product> getAllProducts() {

        return productRespository.findAll();
    }


    @Override
    public Product createProduct(Long id, String title, String description, Double price, String imageUrl ,String categoryTitle) {
       //1. check if category is there in db
        //2. If not then create it and save it while using product
        //3. if yes then use it directly

        Product p = new Product();
        Optional<Category> category1 = categoryRepository.findByTitle(categoryTitle);
        if (category1.isEmpty()) {
            //create new category
            Category newCategory = new Category();
            newCategory.setTitle(categoryTitle);
            Category savedCategory = categoryRepository.save(newCategory);
            p.setCategory(savedCategory);
        } else {
            Category mCategory = category1.get();
            p.setCategory(mCategory);
        }
        p.setTitle(title);
        p.setDescription(description);
        p.setPrice(price);
        p.setImageUrl(imageUrl);
        return productRespository.save(p);
    }

//    @Override
//    public Product createProduct(Long id, String title, String description, Double price, String imageUrl, String Category) {
//        return null;
//    }

    @Override
    public Product updateProduct(Long id, String title, String description, Double price, String imageUrl) {
        return null;
    }

    @Override
    public Product deleteProduct(Long id) {
        return null;
    }

//    @Override
//    public Product createProduct(Long id, String title, String description, double price, Category category) {
//        return null;
//    }
}

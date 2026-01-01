package com.example.productservicebydheerajkumar.service;

import com.example.productservicebydheerajkumar.exceptions.ProductNotFoundException;
import com.example.productservicebydheerajkumar.models.Category;
import com.example.productservicebydheerajkumar.models.Product;
import com.example.productservicebydheerajkumar.repository.CategoryRepository;
import com.example.productservicebydheerajkumar.repository.ProductRespository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//import static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyles.title;

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

    //search product by title getProductByCategoryTitle
    public List<Product> getProductByCategoryTitle(String categoryTitle)  {
        return (List<Product>) productRespository.findByCategoryTitle(categoryTitle);
    }

    @Override
    public List<Product> getAllProducts() {

        return productRespository.findAll();
    }



    public Product createProduct(Long id, String title, String description, Double price, String category) {

        // 1. Check is category is there in db
        // 2. If not there, create it and use it while saving product
        // 3. If there , use it in product directly
        Product p = new Product();
        Optional<Category> currentCat = categoryRepository.findByTitle(category);
        if(currentCat.isEmpty()) {
            // This means category is not present in our db
            Category newCat = new Category();
            newCat.setTitle(category);
            Category newRow = categoryRepository.save(newCat);
            p.setCategory(newRow);
        } else {
            Category currentCategory = currentCat.get();
            p.setCategory(currentCategory);
        }
        p.setTitle(title);
        p.setDescription(description);
//        p.setImageUrl(im);
        p.setPrice(price);
        Product savedproduct = productRespository.save(p);

        return savedproduct;
    }

    @Override
    public Product updateProduct(Long id, String title, String description, Double price, String imageUrl) {
       Product p1 = productRespository.findById(id)
               .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

       if(title != null) p1.setTitle(title);
       if(description != null) p1.setDescription(description);
       if(price != null) p1.setPrice(price);
       if(imageUrl != null) p1.setImageUrl(imageUrl);
//        if (categoryTitle != null) {
//            Optional<Category> categoryOpt = categoryRepository.findByTitle(categoryTitle);
//            Category category = categoryOpt.orElseGet(() -> { Category newCat = new Category();
//                newCat.setTitle(categoryTitle);
//            return categoryRepository.save(newCat); }); p1.setCategory(category); }
        return productRespository.save(p1);
    }

    @Override
    public Product deleteProduct(Long id) {
        Product p = productRespository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        productRespository.deleteById(id);
        return p;
    }

}

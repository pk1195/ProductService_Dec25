package com.example.productservicebydheerajkumar.dto;

import com.example.productservicebydheerajkumar.models.Category;
import com.example.productservicebydheerajkumar.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {
    // Fakestore API product JSON structure or example

    private Long id;
    private String title;
    private Double price;
    private String description;
    private String category;
    private String image;

    @Override
    public String toString() {
        return "FakeStoreProductDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    //create a link between Product and FakeStoreProductDto and get product of my implementation using values from FakeStore
    public Product getProduct(){
        Product product = new Product();
        product.setId(this.id);
        product.setTitle(this.title);
        product.setPrice(this.price);
        product.setDescription(this.description);
        product.setImageUrl(this.image);

        // for category
        Category cat = new Category();
        cat.setTitle(category);
        product.setCategory(cat);
        return product;




    }

}

package com.mte.GProduits.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mte.GProduits.Entities.Category;
import com.mte.GProduits.Entities.Product;
import com.mte.GProduits.services.ServiceCategory;


@Component
public class Converter {

    @Autowired
    ServiceCategory serviceCategory;

    public Product productFormToProductAdd(Product productForm){

        Product product = new Product();



        product.setId(productForm.getId());

        product.setName(productForm.getName());
        product.setCurrentPrice(productForm.getCurrentPrice());
        product.setDescription(productForm.getDescription());
        product.setQuantity(productForm.getQuantity());
        Category category = serviceCategory.getCategoryById(productForm.getCategory().getId()).get();  //this.categoryFormToCategory(productForm.getCategory());
        product.setCategory(category);

        if(product.getQuantity()==0){
            product.setAvailable(false);
        }
        else {
            product.setAvailable(true);
        }



        return product;
    }

    public Category categoryFormToCategory(Category categoryForm){
        Category category = new Category();
        category.setId(categoryForm.getId());
        category.setName(categoryForm.getName());
        category.setDescription(categoryForm.getDescription());
        return category;
    }
    
}

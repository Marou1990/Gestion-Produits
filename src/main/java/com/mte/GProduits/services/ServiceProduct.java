package com.mte.GProduits.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mte.GProduits.Entities.Product;

import java.util.List;

public interface ServiceProduct {

    public Product addorUpdateProduct(Product product);
    public void deleteProduct(Integer idProduct);
    public void deleteProduct(Product product);
    public Page<Product> listProducts(String motCle, Pageable pageable);
    public List<Product> getDisponibleProducts();
    Page<Product> listProductsByCat(Integer idCat, String motCle, Pageable pageable);
    
}

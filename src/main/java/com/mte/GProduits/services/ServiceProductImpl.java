package com.mte.GProduits.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mte.GProduits.Entities.Product;
import com.mte.GProduits.Repository.ProductRepository;
import com.mte.GProduits.converters.Converter;


@Service
public class ServiceProductImpl  implements ServiceProduct{

    @Autowired
    Converter converter;

    @Autowired
    public ProductRepository productRepository;

    @Override
    public Product addorUpdateProduct(Product productForm) {
        Product product = converter.productFormToProductAdd(productForm);
        product = productRepository.save(product);
        return product;
    }

    @Override
    public void deleteProduct(Integer idProduct) {
        productRepository.deleteById(idProduct);
    }

    @Override
    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }

    @Override
    public Page<Product> listProducts(String motCle, Pageable pageable) {
        return this.productRepository.findAll(motCle,pageable);
    }

    @Override
    public List<Product> getDisponibleProducts() {
        return productRepository.findAll();
    }

    @Override
    public Page<Product> listProductsByCat(Integer idCat, String motCle, Pageable pageable) {
        return this.productRepository.findAllByCategory_Id(idCat,motCle,pageable);
    }
    
}

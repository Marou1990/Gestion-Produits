package com.mte.GProduits.Repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.mte.GProduits.Entities.Product;

@Service
public interface CustomProductRepository {
    
    Page<Product> findProductByPage(String motCle, Pageable pageable);
}

package com.mte.GProduits.Repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.mte.GProduits.Entities.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

    //@Query("{'name' : {$regex:?0, $options: i}}")
    Page<Product> findAll(String motCle, Pageable pageable);

    //@Query("{'name' : {$regex:?1, $options: i},'category.id' : ?0 }")
    Page<Product> findAllByCategory_Id(Integer idCat, String motCle, Pageable pageable);
    
    
}

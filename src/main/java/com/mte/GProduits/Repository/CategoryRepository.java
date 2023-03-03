package com.mte.GProduits.Repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mte.GProduits.Entities.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
  
    
    //@Query("{'name' : {$regex:?0, $options: i}}")
    Page<Category> findAll(String motCle, Pageable pageable); 

}

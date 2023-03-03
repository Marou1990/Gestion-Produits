package com.mte.GProduits.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mte.GProduits.Entities.Category;

public interface ServiceCategory {


    public Category addorUpdateCategory(Category category);
    public void deleteCategory(Integer idCategory);
    public void deleteCategory(Category category);
    public Page<Category> listCategories(String motCle, Pageable pageable);
    public List<Category> listCategories();
    public Optional<Category> getCategoryById(Integer id);
}

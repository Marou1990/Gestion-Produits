package com.mte.GProduits.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mte.GProduits.Entities.Category;
import com.mte.GProduits.Repository.CategoryRepository;
import com.mte.GProduits.converters.Converter;


@Service
public class ServiceCategoryImpl implements ServiceCategory {


    @Autowired
    public CategoryRepository categoryRepository;
    @Autowired
    public Converter converter;

    @Override
    public Category addorUpdateCategory(Category categoryform) {
        Category category = converter.categoryFormToCategory(categoryform);
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Integer idCategory) {
        categoryRepository.deleteById(idCategory);
    }

    @Override
    public void deleteCategory(Category category) {
        categoryRepository.delete(category);
    }

    @Override
    public Page<Category> listCategories(String motCle, Pageable pageable) {
        return this.categoryRepository.findAll(motCle,pageable);
    }

    @Override
    public List<Category> listCategories() {
        return this.categoryRepository.findAll();
    }

    @Override
    public Optional<Category> getCategoryById(Integer id) {
        return categoryRepository.findById(id);
    }
    
}

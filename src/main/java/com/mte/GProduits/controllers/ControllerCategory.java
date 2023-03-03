package com.mte.GProduits.controllers;

import com.mte.GProduits.Entities.Category;
import com.mte.GProduits.converters.Converter;
import com.mte.GProduits.services.ServiceCategoryImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ControllerCategory {
    @Autowired
    public ServiceCategoryImpl serviceCategory;

    @Autowired
    public Converter converter;

    @PostMapping("/addCategory")
    public Category addProduct(@RequestBody Category categoryForm){

        return serviceCategory.addorUpdateCategory(categoryForm);

    }

    @PutMapping("/editCategory")
    public Category editProduct(@RequestBody Category categoryForm){

        return serviceCategory.addorUpdateCategory(categoryForm);

    }


    @RequestMapping(value="/getAllCategories",method = RequestMethod.GET)
    public Page<Category> listCategories(@RequestParam(name = "size",defaultValue = "6")int size,
                                       @RequestParam(name = "page",defaultValue = "0")int page,
                                       @RequestParam(name = "motCle",defaultValue ="")String motCle ){


        Pageable pageable = PageRequest.of(page, size);
        return serviceCategory.listCategories(motCle,pageable);
    }

    @GetMapping("/getListCategories")
    public List<Category> listCategories(){
        return serviceCategory.listCategories();
    }

    @DeleteMapping("/delete/{idCategory}")
    public void removeProduct(@PathVariable("idCategory") Integer idCategory){
         serviceCategory.deleteCategory(idCategory);
    }  
}

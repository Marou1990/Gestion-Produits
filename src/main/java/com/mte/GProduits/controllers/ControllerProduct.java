package com.mte.GProduits.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mte.GProduits.Entities.Product;
import com.mte.GProduits.converters.Converter;
import com.mte.GProduits.services.ServiceProductImpl;

@CrossOrigin("*")
@RestController
@RequestMapping("/products")
public class ControllerProduct {

    @Autowired
    public ServiceProductImpl serviceProduct;

    @Autowired
    public Converter converter;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product productForm){


        return serviceProduct.addorUpdateProduct(productForm);

    }

    @PutMapping("/editProduct")
    public Product editProduct(@RequestBody Product productForm){

        return serviceProduct.addorUpdateProduct(productForm);

    }

    @RequestMapping(value = "/getAllProducts" ,method = RequestMethod.GET)
    public Page<Product> listProducts(@RequestParam(name = "size",defaultValue = "6")int size,
                                      @RequestParam(name = "page",defaultValue = "0")int page,
                                      @RequestParam(name = "motCle",defaultValue ="")String motCle ){


        Pageable pageable = PageRequest.of(page, size);
        return serviceProduct.listProducts(motCle,pageable);
    }


    @GetMapping(path = "/disponibleProducts")
    public List<Product> getDisponibleProductsPerMotCle(){
        List<Product> products;
        products= serviceProduct.getDisponibleProducts();
        return products;
    }

    @DeleteMapping(path = "/delete/{idProduct}")
    public void deleteProduct(@PathVariable("idProduct") Integer idProduit){

        serviceProduct.deleteProduct(idProduit);
    }

    @RequestMapping(value = "/getProductsByCat/{idCat}" ,method = RequestMethod.GET)
    public Page<Product> listProducts(@RequestParam(name = "size",defaultValue = "6")int size,
                                      @RequestParam(name = "page",defaultValue = "0")int page,
                                      @RequestParam(name = "motCle",defaultValue ="")String motCle,
                                      @PathVariable("idCat") Integer idCat
                                      ){


        Pageable pageable = PageRequest.of(page, size);
        return serviceProduct.listProductsByCat(idCat,motCle,pageable);
    }
}


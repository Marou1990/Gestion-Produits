package com.mte.GProduits.Entities;

import lombok.AllArgsConstructor;
import lombok.Data; 
import lombok.NoArgsConstructor;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

//@Entity
@Data
//@Table(name="category")
@NoArgsConstructor
@AllArgsConstructor
public class Category {


    @Id//
    private Integer Id ;
    private String name ;
    private String description;

    @OneToMany(mappedBy="produit")
    private ArrayList<Product> products; 
    
    public Integer getId() {
        return Id;
    }
    public void setId(Integer id) {
        Id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString() {
        return "Category [Id=" + Id + ", name=" + name + ", description=" + description + "]";
    }


    
    
}

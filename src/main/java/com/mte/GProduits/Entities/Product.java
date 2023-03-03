package com.mte.GProduits.Entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.Id;


//@Entity //hibernate will make a table from entity  defintion
@Data
@NoArgsConstructor
@AllArgsConstructor
//@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id ;

    private String name;
    private String description;
    private double currentPrice ;
    private Boolean available ;
    private Integer quantity ;

    @ManyToOne
    @JoinColumn(name="id", nullable=false)
    private Category category; 

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
    public double getCurrentPrice() {
        return currentPrice;
    }
    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }
    public Boolean getAvailable() {
        return available;
    }
    public void setAvailable(Boolean available) {
        this.available = available;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    @Override
    public String toString() {
        return "Product [Id=" + Id + ", name=" + name + ", description=" + description + ", currentPrice="
                + currentPrice + ", available=" + available + ", quantity=" + quantity + "]";
    }
    

    
}

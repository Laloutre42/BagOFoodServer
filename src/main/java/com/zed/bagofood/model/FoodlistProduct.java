package com.zed.bagofood.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.zed.bagofood.model.product.Product;

import lombok.Data;

/**
 * Created by Arnaud on 03/05/2015.
 */
@Data
@Entity
public class FoodlistProduct {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @ManyToOne
    @JoinColumn
    private Foodlist foodlist;
    
    @ManyToOne
    @JoinColumn
    private Product product;
    
    private double weight;
    
    private String category;
    
    @ManyToOne
    @JoinColumn
    private Catalog catalog;

}

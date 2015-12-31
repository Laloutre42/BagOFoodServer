package com.zed.bagofood.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

/**
 * Created by Arnaud on 03/05/2015.
 */
@Data
@Entity
public class Foodlist {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private String name;
    
    private String description;
    
    @ManyToOne
    private User user;
    
    @OneToMany(mappedBy = "foodlist")
    private List<FoodlistProduct> foodListProductList = new ArrayList<>(0);

}

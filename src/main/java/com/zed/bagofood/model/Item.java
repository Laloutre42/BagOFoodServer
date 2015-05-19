package com.zed.bagofood.model;

import com.zed.bagofood.enumeration.Category;
import lombok.Data;

/**
 * Created by Arnaud on 03/05/2015.
 */
@Data
public class Item {

    private String id;
    private String name;
    private Category category;
    private Integer energyFor100;
    private Integer weight;
    private String productId;

    protected Item() {
    }

    public Item(String name, Category category, Integer energyFor100, Integer weight, String productId) {
        this.name = name;
        this.category = category;
        this.energyFor100 = energyFor100;
        this.weight = weight;
        this.productId = productId;
    }
}
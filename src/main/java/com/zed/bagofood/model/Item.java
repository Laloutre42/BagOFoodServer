package com.zed.bagofood.model;

import lombok.Data;

/**
 * Created by Arnaud on 03/05/2015.
 */
@Data
public class Item {

    private String id;
    private String name;
    private String category;
    private Float energyFor100;
    private Integer weight;
    private String catalog;
    private String productId;

}
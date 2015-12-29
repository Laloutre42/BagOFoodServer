package com.zed.bagofood.model.product;

import lombok.Data;

/**
 * Created by Arnaud on 09/11/2015.
 */
@Data
public class ProductField {

    private String name;
    private Object value;

    public ProductField(String name, Object value){
        this.name = name;
        this.value = value;
    }
}

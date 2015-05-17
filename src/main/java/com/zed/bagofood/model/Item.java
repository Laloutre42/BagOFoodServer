package com.zed.bagofood.model;

import com.zed.bagofood.enumeration.Category;
import lombok.Data;
import org.bson.types.ObjectId;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Arnaud on 03/05/2015.
 */
@Data
@Document
public class Item {

    @Id
    private String id;
    private String name;
    private Category category;
    private Integer energyFor100;
    private Integer weight;

    protected Item() {
    }

    public Item(String name, Category category, Integer energyFor100, Integer weight) {
        this.name = name;
        this.category = category;
        this.energyFor100 = energyFor100;
        this.weight = weight;
    }
}
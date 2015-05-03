package com.zed.bagofood.model;

import com.zed.bagofood.enumeration.Category;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Arnaud on 03/05/2015.
 */
@Entity
@Table(name = "item", schema = "", catalog = "bagofood")
public class Item {

    private int id;
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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @NotBlank
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Enumerated
    @Column(name = "category")
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Basic
    @NotNull
    @Column(name = "energyFor100")
    public Integer getEnergyFor100() {
        return energyFor100;
    }

    public void setEnergyFor100(Integer energyFor100) {
        this.energyFor100 = energyFor100;
    }

    @Basic
    @NotNull
    @Column(name = "weight")
    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

}

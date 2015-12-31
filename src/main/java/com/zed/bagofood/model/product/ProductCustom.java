package com.zed.bagofood.model.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public abstract class ProductCustom extends Product{

	private String name;
	private double energie_kcal_100g;
	
}

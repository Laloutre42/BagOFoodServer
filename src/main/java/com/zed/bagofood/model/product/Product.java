package com.zed.bagofood.model.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public abstract class Product {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected long id;
}

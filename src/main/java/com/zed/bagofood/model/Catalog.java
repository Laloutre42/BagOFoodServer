package com.zed.bagofood.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;

import lombok.Data;

/**
 * 
 * @author Arnaud
 *
 */
@Data
@Entity
public class Catalog {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank
    private String name;

}
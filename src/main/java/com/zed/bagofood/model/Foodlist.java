package com.zed.bagofood.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
    private User user;
    //private List<Item> itemList = new ArrayList<>(0);

}

package com.zed.bagofood.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Arnaud on 03/05/2015.
 */
@Data
@Document
public class Foodlist {

    @Id
    private String id;
    private String name;
    private String description;
    private User user;
    private List<Item> itemList = new ArrayList<>(0);

}

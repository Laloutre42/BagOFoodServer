package com.zed.bagofood.repository;

/**
 * Created by Arnaud on 30/04/2015.
 */

import com.zed.bagofood.model.Foodlist;
import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface FoodListRepository extends CrudRepository<Foodlist, String> {

    List<Foodlist> findByUser_Id(String userId);
}

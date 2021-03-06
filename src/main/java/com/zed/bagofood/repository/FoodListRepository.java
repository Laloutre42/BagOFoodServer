package com.zed.bagofood.repository;

/**
 * Created by Arnaud on 30/04/2015.
 */

import com.zed.bagofood.model.Foodlist;
import com.zed.bagofood.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface FoodListRepository extends CrudRepository<Foodlist, String> {

    @Query("{ 'user._id' : ?0 }")
    List<Foodlist> findByUserId(ObjectId userId);
}

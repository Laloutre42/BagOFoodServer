package com.zed.bagofood.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Arnaud on 30/04/2015.
 */

import com.zed.bagofood.model.Foodlist;

public interface FoodListRepository extends CrudRepository<Foodlist, Long> {

	@Query("SELECT f FROM Foodlist f WHERE f.user.id = :userId")
    List<Foodlist> findByUserId(String userId);
}

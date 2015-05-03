package com.zed.bagofood.controller;

import com.zed.bagofood.model.Foodlist;
import com.zed.bagofood.repository.FoodListRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by Arnaud on 01/05/2015.
 */

@RestController
@RequestMapping("/foodlist")
public class FoodListController {

    /**
     * Class Logger
     */
    private static final Logger logger = LoggerFactory.getLogger(FoodListController.class);

    @Autowired
    FoodListRepository foodListRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Foodlist> getAllFoodList() {
        return StreamSupport.stream(foodListRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Foodlist getFoodListById(@PathVariable int id) {
        return foodListRepository.findOne(id);
    }

    @RequestMapping(value = "/userId/{userId}", method = RequestMethod.GET)
         public List<Foodlist> getFoodListByUserId(@PathVariable int userId) {
        return foodListRepository.findByUser_Id(userId);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Foodlist addFoodList(@Valid @RequestBody Foodlist foodList) {
        logger.debug("Save FoodlistEntity " + foodList);
        Foodlist result = foodListRepository.save(foodList);
        return null;
    }

}

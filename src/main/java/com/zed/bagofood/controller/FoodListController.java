package com.zed.bagofood.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zed.bagofood.model.Foodlist;
import com.zed.bagofood.repository.FoodListRepository;

/**
 * Created by Arnaud on 01/05/2015.
 */

@RestController
@RequestMapping("/api/foodlist")
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
    public Foodlist getFoodListById(@PathVariable long id) {
        return foodListRepository.findOne(id);
    }

    @RequestMapping(value = "/userId/{userId}", method = RequestMethod.GET)
    public List<Foodlist> getFoodListByUserId(@PathVariable String userId) {
        return foodListRepository.findByUserId(userId);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Foodlist addFoodList(@Valid @RequestBody Foodlist foodList) {
        return foodListRepository.save(foodList);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public Foodlist updateFoodList(@Valid @RequestBody Foodlist foodList) {
        return foodListRepository.save(foodList);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteFoodList(@PathVariable long id) {
        foodListRepository.delete(id);
    }

    /**
     * Get all items on food list id
     *
     * @param id
     * @return
     */
//    @RequestMapping(value = "/{id}/items", method = RequestMethod.GET)
//    public List<Item> getFoodListItemsById(@PathVariable String id) {
//        Foodlist foodlist = foodListRepository.findOne(id);
//        return (foodlist == null) ? new ArrayList<Item>(0) : foodlist.getItemList();
//    }

    /**
     * Add item on food list id
     *
     * @param id
     * @param item
     * @return
     */
    // TODO
//    @RequestMapping(value = "/{id}/items", method = RequestMethod.POST)
//    public Foodlist addItemOnFoodList(@PathVariable String id, @Valid @RequestBody Item item) {
//
//        // Set unique id
//        //item.setId(new ObjectId().toString());
//
//        Foodlist foodList = foodListRepository.findOne(id);
//        foodList.getItemList().add(item);
//        return foodListRepository.save(foodList);
//    }

    /**
     * Update item on food list id
     *
     * @param id
     * @param item
     * @return
     */
    // TODO
//    @RequestMapping(value = "/{id}/items/{itemId}", method = RequestMethod.POST)
//    public Foodlist updateItemOnFoodList(@PathVariable String id, @PathVariable String itemId, @Valid @RequestBody Item item) {
//
//        // Todo : refactor en Stream
//        int index = -1;
//        Foodlist foodList = foodListRepository.findOne(id);
//        for (int i = 0; i < foodList.getItemList().size(); i++) {
//
//            if (foodList.getItemList().get(i).getId().equals(item.getId())) {
//                index = i;
//            }
//        }
//        if (index > -1) {
//            foodList.getItemList().set(index, item);
//        }
//        else{
//            throw new RuntimeException("Unable to find item");
//        }
//
//        return foodListRepository.save(foodList);
//    }

    /**
     * Delete item on food list id
     *
     * @param id
     * @param itemId
     * @return
     */
    // TODO
//    @RequestMapping(value = "/{id}/items/{itemId}", method = RequestMethod.DELETE)
//    public Foodlist deleteItemOnFoodList(@PathVariable String id, @PathVariable String itemId) {
//
//        // Todo : refactor en Stream
//        int index = -1;
//        Foodlist foodList = foodListRepository.findOne(id);
//        for (int i = 0; i < foodList.getItemList().size(); i++) {
//
//            if (foodList.getItemList().get(i).getId().equals(itemId)) {
//                index = i;
//            }
//        }
//        if (index > -1) {
//            foodList.getItemList().remove(index);
//        }
//        else{
//            throw new RuntimeException("Unable to find item");
//        }
//
//        return foodListRepository.save(foodList);
//    }

}

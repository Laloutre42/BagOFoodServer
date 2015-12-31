package com.zed.bagofood.controller;

import java.util.ArrayList;
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
import com.zed.bagofood.model.FoodlistProduct;
import com.zed.bagofood.model.product.Product;
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
	@RequestMapping(value = "/{id}/items", method = RequestMethod.GET)
	public List<FoodlistProduct> getFoodListItemsById(@PathVariable long id) {
		Foodlist foodlist = foodListRepository.findOne(id);
		return (foodlist == null) ? new ArrayList<FoodlistProduct>(0) : foodlist.getFoodListProductList();
	}

	/**
	 * Add item on food list id
	 *
	 * @param id
	 * @param item
	 * @return
	 */
	@RequestMapping(value = "/{id}/items", method = RequestMethod.POST)
	public Foodlist addItemOnFoodList(@PathVariable long id, @Valid @RequestBody FoodlistProduct item) {
		Foodlist foodList = foodListRepository.findOne(id);
		foodList.getFoodListProductList().add(item);
		return foodListRepository.save(foodList);
	}

	/**
	 * Update item on food list id
	 *
	 * @param id
	 * @param item
	 * @return
	 */
	@RequestMapping(value = "/{id}/items/{itemId}", method = RequestMethod.POST)
	public Foodlist updateItemOnFoodList(@PathVariable long id, @PathVariable long itemId, @Valid @RequestBody FoodlistProduct item) {

		// TODO : refactor en Stream
		int index = -1;
		Foodlist foodList = foodListRepository.findOne(id);
		for (int i = 0; i < foodList.getFoodListProductList().size(); i++) {

			if (foodList.getFoodListProductList().get(i).getId() == item.getId()) {
				index = i;
			}
		}
		if (index > -1) {
			foodList.getFoodListProductList().set(index, item);
		}
		else {
			throw new RuntimeException("Unable to find item");
		}

		return foodListRepository.save(foodList);
	}

	/**
	 * Delete item on food list id
	 *
	 * @param id
	 * @param itemId
	 * @return
	 */
	@RequestMapping(value = "/{id}/items/{itemId}", method = RequestMethod.DELETE)
	public Foodlist deleteItemOnFoodList(@PathVariable long id, @PathVariable long itemId) {

		// Todo : refactor en Stream
		int index = -1;
		Foodlist foodList = foodListRepository.findOne(id);
		
		for (int i = 0; i < foodList.getFoodListProductList().size(); i++) {
			if (foodList.getFoodListProductList().get(i).getId() == itemId) {
				index = i;
			}
		}
		if (index > -1) {
			foodList.getFoodListProductList().remove(index);
		}
		else {
			throw new RuntimeException("Unable to find item");
		}

		return foodListRepository.save(foodList);
	}

}

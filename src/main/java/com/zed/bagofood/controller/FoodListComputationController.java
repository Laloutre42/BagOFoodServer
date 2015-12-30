package com.zed.bagofood.controller;

import com.zed.bagofood.model.Foodlist;
import com.zed.bagofood.repository.FoodListRepository;
import com.zed.bagofood.view.FoodListCategoryDataInformations;
import com.zed.bagofood.view.FoodListDataInformations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by Arnaud on 01/05/2015.
 */

@RestController
@RequestMapping("/api/foodlistComputation")
public class FoodListComputationController {

    /**
     * Class Logger
     */
    private static final Logger logger = LoggerFactory.getLogger(FoodListComputationController.class);

    @Autowired
    FoodListRepository foodListRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Foodlist> getAllFoodList() {
        return StreamSupport.stream(foodListRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    /**
     * Get a food list and return a total object which contains summary
     * @param id
     * @return
     */
    @RequestMapping(value = "/statisticsTable/{id}", method = RequestMethod.GET)
    public Collection<FoodListCategoryDataInformations> getStatisticsTableFromFoodListById(@PathVariable long id) {
        FoodListDataInformations foodListDataInformations = new FoodListDataInformations(foodListRepository.findOne(id));
        return foodListDataInformations.statisticsTable();
    }

    @RequestMapping(value = "/statisticsChartHisto/{id}", method = RequestMethod.GET)
    public Map<String, List<Object>> getStatisticsChartHistoFromFoodListById(@PathVariable long id) {
        FoodListDataInformations foodListDataInformations = new FoodListDataInformations(foodListRepository.findOne(id));
        return foodListDataInformations.statisticsChartHisto();
    }





}

package com.zed.bagofood.controller;

import com.zed.bagofood.repository.FoodListRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Arnaud on 01/05/2015.
 */

@RestController
@RequestMapping("/item")
public class ItemController {

    /**
     * Class Logger
     */
    private static final Logger logger = LoggerFactory.getLogger(FoodListController.class);

}

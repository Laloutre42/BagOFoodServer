package com.zed.bagofood.controller;

import com.zed.bagofood.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Arnaud on 01/05/2015.
 */

@RestController
@RequestMapping("/user")
public class ItemController {

    @Autowired
    ItemRepository itemRepository;

}

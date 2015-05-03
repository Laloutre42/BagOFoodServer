package com.zed.bagofood.controller;

import com.zed.bagofood.model.Foodlist;
import com.zed.bagofood.model.User;
import com.zed.bagofood.repository.FoodListRepository;
import com.zed.bagofood.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by Arnaud on 01/05/2015.
 */

@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * Class Logger
     */
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<User> getAllUser() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public java.util.Collection<User> getUserByName(@PathVariable String name) {
        return userRepository.findByName(name);
    }

}

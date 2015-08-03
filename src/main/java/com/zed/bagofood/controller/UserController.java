package com.zed.bagofood.controller;

import com.zed.bagofood.model.User;
import com.zed.bagofood.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by Arnaud on 01/05/2015.
 */

@RestController
@RequestMapping("/api/user")
public class UserController {

    /**
     * Class Logger
     */
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public User login(@RequestBody User user) {

        User userInDb = userRepository.findByNameAndPassword(user.getName(), user.getPassword());
        if (userInDb == null){
            throw new InternalError("Invalid user name or password");
        }
        else {
            return userInDb;
        }
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public User signUp(@Valid @RequestBody User user) {

        if ((user.getId() != null && userRepository.exists(user.getId())) || (userRepository.findByName(user.getName()) != null)){
            throw new InternalError("User already exist");
        }
        return userRepository.save(user);
    }

    @RequestMapping("/principalUser")
    public Principal user(Principal user) {
        return user;
    }
    
    @RequestMapping(value = "/testA", method = RequestMethod.GET)
    public List<User> getAllUsersA() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @RequestMapping(value = "/testNA", method = RequestMethod.GET)
    public List<User> getAllUsersNA() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }
}

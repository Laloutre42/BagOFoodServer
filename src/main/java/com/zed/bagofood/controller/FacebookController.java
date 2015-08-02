package com.zed.bagofood.controller;

import com.zed.bagofood.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Arnaud on 01/05/2015.
 */

@RestController
@RequestMapping("/api/facebook")
public class FacebookController {

    /**
     * Class Logger
     */
    private static final Logger logger = LoggerFactory.getLogger(FacebookController.class);

//    @Inject
//    private Facebook facebook;
//
//    @RequestMapping(value = "", method = RequestMethod.GET)
//    public String getUserName() {
//        return facebook.userOperations().getUserProfile().getName();
//    }
}

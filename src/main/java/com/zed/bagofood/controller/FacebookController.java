package com.zed.bagofood.controller;

import com.zed.bagofood.repository.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

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

    @Inject
    Facebook facebook;
	
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String getUserName() {
    	    	
        if (facebook == null){
            logger.debug("Redirect to log in");
            return "";            
        }
        else{
            return "name: "+facebook.userOperations().getUserProfile().getName() + "mail: "+facebook.userOperations().getUserProfile().getEmail();        	
        }
    }
}

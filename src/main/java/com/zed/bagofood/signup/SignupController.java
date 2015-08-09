/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.zed.bagofood.signup;

import javax.inject.Inject;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import com.zed.bagofood.controller.UserController;

@RestController
@RequestMapping(value="/api/signup")
public class SignupController {
	
    /**
     * Class Logger
     */
    private static final Logger logger = LoggerFactory.getLogger(SignupController.class);	

    @Inject
	private ProviderSignInUtils providerSignInUtils;

	@RequestMapping(value="", method=RequestMethod.GET)
	public String signupForm(WebRequest request) {
		
		logger.info("[SignupController] Sign up");
		
		Connection<?> connection = providerSignInUtils.getConnectionFromSession(request);
		if (connection != null) {
			logger.info("[SignupController] Sign up OK");
			UserProfile userProfile = connection.fetchUserProfile();
            return "ok "+userProfile.getName()+ " - "+userProfile.getEmail();
			//request.setAttribute("message", new Message(MessageType.INFO, "Your " + StringUtils.capitalize(connection.getKey().getProviderId()) + " account is not associated with a Spring Social Showcase account. If you're new, please sign up."), WebRequest.SCOPE_REQUEST);
		} else {
			logger.info("[SignupController] Sign up KO");
            return "ko";
		}
	}

}

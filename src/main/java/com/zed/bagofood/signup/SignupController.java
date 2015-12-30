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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

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
            return "[SignupController] Sign up OK";
		} else {
			logger.info("[SignupController] Sign up KO");
            return "[SignupController] Sign up NOT OK";
		}
	}

}

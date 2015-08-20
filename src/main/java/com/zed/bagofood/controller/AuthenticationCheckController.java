package com.zed.bagofood.controller;

import com.zed.bagofood.model.User;
import com.zed.bagofood.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Arnaud on 08/08/2015.
 */
@RestController
@RequestMapping("/api/authenticationCheck")
public class AuthenticationCheckController {

    /**
     * Class Logger
     */
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationCheckController.class);

    @Inject
    UserRepository userRepository;

    private GrantedAuthority ROLE_ANONYMOUS = new SimpleGrantedAuthority("ROLE_ANONYMOUS");

    @RequestMapping(value = "", method = RequestMethod.GET)
    public User checkAuthentication(HttpServletResponse response) {

        if ((SecurityContextHolder.getContext().getAuthentication() != null && SecurityContextHolder.getContext().getAuthentication().isAuthenticated()
                && SecurityContextHolder.getContext().getAuthentication().getAuthorities().contains(ROLE_ANONYMOUS)) ) {
            logger.debug("[checkAuthentication] NOT authenticated");

            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return null;
        } else {
            logger.debug("[checkAuthentication] Authenticated OK");

            String nameProviderId = SecurityContextHolder.getContext().getAuthentication().getName();

            User user = userRepository.findByNameProviderId(nameProviderId);
            if (user == null) {
                throw new InternalError("Cannot find user by username for nameProviderId [" + nameProviderId + "]");
            }
            return user;
        }

    }
}

package com.zed.bagofood.signup;

import com.zed.bagofood.model.User;
import com.zed.bagofood.model.UserRole;
import com.zed.bagofood.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UserProfile;

/**
 * Created by Arnaud on 04/08/2015.
 */
public class UserConnectionSignUp implements ConnectionSignUp {

    @Autowired
    UserRepository userRepository;

    public String execute(Connection<?> connection) {
        UserProfile profile = connection.fetchUserProfile();

        User user = new User();
        user.setName(profile.getUsername());
        user.setPassword("");
        user.setEmail(profile.getEmail());
        user.setRole(UserRole.USER);

        userRepository.save(user);

        return user.getName();
    }

}
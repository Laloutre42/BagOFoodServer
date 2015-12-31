package com.zed.bagofood.signup;

import com.zed.bagofood.model.User;
import com.zed.bagofood.model.UserRole;
import com.zed.bagofood.repository.UserRepository;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UserProfile;

/**
 * Created by Arnaud on 04/08/2015.
 */
public class UserConnectionSignUp implements ConnectionSignUp {

    private final UserRepository userRepository;

	public UserConnectionSignUp(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public String execute(Connection<?> connection) {
        UserProfile profile = connection.fetchUserProfile();
        
        if (userRepository.findByName(profile.getName()) != null){
        	return null;
        }

        User user = new User();
        user.setName(profile.getName());
        user.setPassword("?");
        user.setEmail(profile.getEmail());
        user.setRole(UserRole.USER);
        user.setProviderId(connection.getKey().getProviderId());
        user.setNameProviderId(user.getUserId());
        
        userRepository.save(user);

        return user.getName();
    }

}
package com.zed.bagofood.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import com.zed.mong.model.UserSocialConnection;
import org.springframework.stereotype.Repository;

public interface UserSocialConnectionRepository extends MongoRepository<UserSocialConnection, String> {
	
    List<UserSocialConnection> findByProviderIdAndProviderUserId(String providerId, String providerUserId);
    
    List<UserSocialConnection> findByProviderIdAndProviderUserIdIn(String providerId, Collection<String> providerUserIds);

	List<UserSocialConnection> findByUserIdAndProviderId(String userId, String providerId);

	UserSocialConnection findByUserIdAndProviderIdAndProviderUserId(String userId, String providerId, String providerUserId);

	List<UserSocialConnection> findByUserId(String userId);    
}

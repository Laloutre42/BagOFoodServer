package com.zed.bagofood.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.zed.bagofood.model.UserSocialConnection;

public interface UserSocialConnectionRepository extends CrudRepository<UserSocialConnection, String> {
	
    List<UserSocialConnection> findByProviderIdAndProviderUserId(String providerId, String providerUserId);
    
    List<UserSocialConnection> findByProviderIdAndProviderUserIdIn(String providerId, Collection<String> providerUserIds);

	List<UserSocialConnection> findByUserIdAndProviderId(String userId, String providerId);

	UserSocialConnection findByUserIdAndProviderIdAndProviderUserId(String userId, String providerId, String providerUserId);

	List<UserSocialConnection> findByUserId(String userId);    
}

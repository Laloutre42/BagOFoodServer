package com.zed.bagofood.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.zed.bagofood.model.UserConnection;

public interface UserSocialConnectionRepository extends CrudRepository<UserConnection, Long> {
	
    List<UserConnection> findByProviderIdAndProviderUserId(String providerId, String providerUserId);
    
    List<UserConnection> findByProviderIdAndProviderUserIdIn(String providerId, Collection<String> providerUserIds);

	List<UserConnection> findByUserIdAndProviderId(String userId, String providerId);

	UserConnection findByUserIdAndProviderIdAndProviderUserId(String userId, String providerId, String providerUserId);

	List<UserConnection> findByUserId(String userId);    
}

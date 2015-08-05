package com.zed.mong.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.zed.bagofood.repository.UserSocialConnectionRepository;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionKey;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UsersConnectionRepository;

import com.zed.mong.model.UserSocialConnection;

public class MongoUsersConnectionRepository implements UsersConnectionRepository{
	
	private final UserSocialConnectionRepository userSocialConnectionRepository;
	
	private final ConnectionFactoryLocator connectionFactoryLocator;

	private final TextEncryptor textEncryptor;

	private ConnectionSignUp connectionSignUp;	
	
	public MongoUsersConnectionRepository(UserSocialConnectionRepository userSocialConnectionRepository, ConnectionFactoryLocator connectionFactoryLocator, TextEncryptor textEncryptor) {
		this.userSocialConnectionRepository = userSocialConnectionRepository;
		this.connectionFactoryLocator = connectionFactoryLocator;
		this.textEncryptor = textEncryptor;
	}	
	
	/**
	 * The command to execute to create a new local user profile in the event no user id could be mapped to a connection.
	 * Allows for implicitly creating a user profile from connection data during a provider sign-in attempt.
	 * Defaults to null, indicating explicit sign-up will be required to complete the provider sign-in attempt.
	 * @param connectionSignUp a {@link ConnectionSignUp} object
	 * @see #findUserIdsWithConnection(Connection)
	 */
	public void setConnectionSignUp(ConnectionSignUp connectionSignUp) {
		this.connectionSignUp = connectionSignUp;
	}	

	@Override
	public List<String> findUserIdsWithConnection(Connection<?> connection) {
		
        ConnectionKey key = connection.getKey();
        List<UserSocialConnection> userSocialConnectionList = this.userSocialConnectionRepository.findByProviderIdAndProviderUserId(key.getProviderId(), key.getProviderUserId());
        List<String> localUserIds = new ArrayList<String>();
        
        if (userSocialConnectionList != null){     	
        	userSocialConnectionList.stream().forEach(usc -> localUserIds.add(usc.getUserId()));
        }
        
		if (localUserIds.size() == 0 && connectionSignUp != null) {
			String newUserId = connectionSignUp.execute(connection);
			if (newUserId != null){
				createConnectionRepository(newUserId).addConnection(connection);
				return Arrays.asList(newUserId);
			}
		}
		return localUserIds;
    }

	@Override
	public Set<String> findUserIdsConnectedTo(String providerId, Set<String> providerUserIds) {
		
        final Set<String> localUserIds = new HashSet<String>();

        List<UserSocialConnection> userSocialConnectionList = this.userSocialConnectionRepository.findByProviderIdAndProviderUserIdIn(providerId, providerUserIds);
        
        if (userSocialConnectionList != null){     	
        	userSocialConnectionList.stream().forEach(usc -> localUserIds.add(usc.getUserId()));
        }
        return localUserIds;
    }

	@Override
	public ConnectionRepository createConnectionRepository(String userId) {
		if (userId == null) {
            throw new IllegalArgumentException("userId cannot be null");
        }
        return new MongoConnectionRepository(userId, userSocialConnectionRepository, connectionFactoryLocator, textEncryptor);
	}

}

package com.zed.mong.repository;

import java.util.LinkedList;
import java.util.List;

import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionKey;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.util.MultiValueMap;

import com.zed.mong.model.UserSocialConnection;

public class MongoConnectionRepository implements ConnectionRepository {

	private final String userId;
	
	private final UserSocialConnectionRepository userSocialConnectionRepository;
	
	private final ConnectionFactoryLocator connectionFactoryLocator;
	
	private final TextEncryptor textEncryptor;
	
	public MongoConnectionRepository(String userId, UserSocialConnectionRepository userSocialConnectionRepository, ConnectionFactoryLocator connectionFactoryLocator, TextEncryptor textEncryptor){
		this.userId = userId;
		this.userSocialConnectionRepository = userSocialConnectionRepository;
		this.connectionFactoryLocator = connectionFactoryLocator;
		this.textEncryptor = textEncryptor;
	}
	
	@Override
	public MultiValueMap<String, Connection<?>> findAllConnections() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Connection<?>> findConnections(String providerId) {
		List<Connection<?>> resultList = new LinkedList<Connection<?>>();
        List<UserSocialConnection> userSocialConnectionList = this.userSocialConnectionRepository.findByUserIdAndProviderId(userId, providerId);
        for (UserSocialConnection userSocialConnection : userSocialConnectionList) {
            resultList.add(buildConnection(userSocialConnection));
        }
        return resultList;
	}

	@Override
	public <A> List<Connection<A>> findConnections(Class<A> apiType) {
        List<?> connections = findConnections(getProviderId(apiType));
        return (List<Connection<A>>) connections;
	}

	@Override
	public MultiValueMap<String, Connection<?>> findConnectionsToUsers(
			MultiValueMap<String, String> providerUserIds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Connection<?> getConnection(ConnectionKey connectionKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <A> Connection<A> getConnection(Class<A> apiType,
			String providerUserId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <A> Connection<A> getPrimaryConnection(Class<A> apiType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <A> Connection<A> findPrimaryConnection(Class<A> apiType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addConnection(Connection<?> connection) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateConnection(Connection<?> connection) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeConnections(String providerId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeConnection(ConnectionKey connectionKey) {
		// TODO Auto-generated method stub
		
	}
	
    // internal helpers

    private Connection<?> buildConnection(UserSocialConnection userSocialConnection) {
        ConnectionData connectionData = new ConnectionData(userSocialConnection.getProviderId(),
                userSocialConnection.getProviderUserId(), userSocialConnection.getDisplayName(),
                userSocialConnection.getProfileUrl(), userSocialConnection.getImageUrl(),
                decrypt(userSocialConnection.getAccessToken()), decrypt(userSocialConnection.getSecret()),
                decrypt(userSocialConnection.getRefreshToken()), userSocialConnection.getExpireTime());
        ConnectionFactory<?> connectionFactory = this.socialAuthenticationServiceLocator.getConnectionFactory(connectionData.getProviderId());
        return connectionFactory.createConnection(connectionData);
    }

    private Connection<?> findPrimaryConnection(String providerId) {
        List<UserSocialConnection> userSocialConnectionList = this.userSocialConnectionRepository.findByUserIdAndProviderId(userId, providerId);

        return buildConnection(userSocialConnectionList.get(0));
    }

    private <A> String getProviderId(Class<A> apiType) {
        return connectionFactoryLocator.getConnectionFactory(apiType).getProviderId();
    }

    private String encrypt(String text) {
        return text != null ? textEncryptor.encrypt(text) : text;
    }

    private String decrypt(String encryptedText) {
        return encryptedText != null ? textEncryptor.decrypt(encryptedText) : encryptedText;
    }	

}

package com.zed.bagofood.config;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.google.api.Google;
import org.springframework.social.google.api.impl.GoogleTemplate;
import org.springframework.social.google.connect.GoogleConnectionFactory;

import com.zed.bagofood.repository.UserRepository;
import com.zed.bagofood.signup.UserConnectionSignUp;

/**
 * Created by Arnaud on 04/08/2015.
 */
@Configuration
@EnableSocial
public class SocialConfiguration extends SocialConfigurerAdapter {
	
	@Inject
    UserRepository userRepository;	
	
    @Inject
	DataSource dataSource;
    
    @Override
    public void addConnectionFactories(ConnectionFactoryConfigurer cfConfig, Environment env) {
    	
    	FacebookConnectionFactory facebookConnectionFactory = new FacebookConnectionFactory(
                env.getProperty("facebook.clientId"),
                env.getProperty("facebook.clientSecret"));
    	facebookConnectionFactory.setScope("email");
        cfConfig.addConnectionFactory(facebookConnectionFactory);

        GoogleConnectionFactory googleConnectionFactory = new GoogleConnectionFactory(
                env.getProperty("google.consumerKey"),
                env.getProperty("google.consumerSecret"));
        googleConnectionFactory.setScope("email");
        cfConfig.addConnectionFactory(googleConnectionFactory);
    }

    @Override
    @Scope(value="singleton", proxyMode=ScopedProxyMode.INTERFACES)    
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
    	JdbcUsersConnectionRepository usersConnectionRepository = new JdbcUsersConnectionRepository(dataSource, connectionFactoryLocator, Encryptors.noOpText());
        usersConnectionRepository.setConnectionSignUp(new UserConnectionSignUp(userRepository));
        return usersConnectionRepository;
    }

    @Bean
    @Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
    public Facebook facebook(ConnectionRepository repository) {
        Connection<Facebook> connection = repository.findPrimaryConnection(Facebook.class);
        return (connection != null) ? connection.getApi() : null;
    }

    @Bean
    @Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
    public Google google(ConnectionRepository repository) {
        Connection<Google> connection = repository.findPrimaryConnection(Google.class);
        return (connection != null) ? connection.getApi() : new GoogleTemplate();
    }

    @Bean
    public ProviderSignInUtils providerSignInUtils(ConnectionFactoryLocator connectionFactoryLocator, UsersConnectionRepository connectionRepository) {
        return new ProviderSignInUtils(connectionFactoryLocator, connectionRepository);
    }

}

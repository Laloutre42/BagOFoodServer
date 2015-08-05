package com.zed.bagofood.config;

import com.zed.bagofood.repository.UserRepository;
import com.zed.bagofood.signup.UserConnectionSignUp;
import com.zed.mong.repository.MongoUsersConnectionRepository;
import com.zed.bagofood.repository.UserSocialConnectionRepository;
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
import org.springframework.social.connect.web.ConnectController;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;

import javax.inject.Inject;

/**
 * Created by Arnaud on 04/08/2015.
 */
@Configuration
@EnableSocial
public class SocialConfiguration extends SocialConfigurerAdapter {

    @Autowired
    UserSocialConnectionRepository userSocialConnectionRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public void addConnectionFactories(ConnectionFactoryConfigurer cfConfig, Environment env) {
        cfConfig.addConnectionFactory(new FacebookConnectionFactory(
                env.getProperty("facebook.clientId"),
                env.getProperty("facebook.clientSecret")));
    }

//    @Bean
//    @Scope(value="singleton", proxyMode=ScopedProxyMode.INTERFACES)
//    public UsersConnectionRepository usersConnectionRepository(AccountRepository accountRepository) {
//        JdbcUsersConnectionRepository repository = new JdbcUsersConnectionRepository(
//                dataSource, connectionFactoryLocator(), Encryptors.noOpText());
//        repository.setConnectionSignUp(new AccountConnectionSignUp(accountRepository));
//        return repository;
//    }

    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
        //JdbcUsersConnectionRepository repository = new JdbcUsersConnectionRepository(dataSource, connectionFactoryLocator, Encryptors.noOpText());
        MongoUsersConnectionRepository repository = new MongoUsersConnectionRepository(userSocialConnectionRepository, connectionFactoryLocator, Encryptors.noOpText());
        return repository;
    }

    /**
     * Request-scoped data access object providing access to the current user's connections.
     */
    @Bean
    @Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
    public ConnectionRepository connectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
        UserAccount user = AccountUtils.getLoginUserAccount();
        User user =
        return getUsersConnectionRepository(connectionFactoryLocator).createConnectionRepository(user.getUsername());
    }

    @Bean
    public ConnectController connectController(ConnectionFactoryLocator connectionFactoryLocator, ConnectionRepository connectionRepository) {
        ConnectController connectController = new ConnectController(connectionFactoryLocator, connectionRepository);
        connectController.setApplicationUrl("http://localhost:3000");
        return connectController;
    }

    @Bean
    @Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
    public Facebook facebook(ConnectionRepository repository) {
        Connection<Facebook> connection = repository.findPrimaryConnection(Facebook.class);
        return connection != null ? connection.getApi() : null;
    }

    @Bean
    public ProviderSignInUtils providerSignInUtils(ConnectionFactoryLocator connectionFactoryLocator, UsersConnectionRepository connectionRepository) {
        return new ProviderSignInUtils(connectionFactoryLocator, connectionRepository);
    }
}

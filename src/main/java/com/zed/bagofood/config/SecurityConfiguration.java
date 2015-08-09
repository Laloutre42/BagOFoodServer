package com.zed.bagofood.config;

import com.zed.bagofood.filter.CsrfHeaderFilter;
import com.zed.bagofood.repository.UserRepository;
import com.zed.bagofood.security.SimpleSocialUsersDetailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.social.UserIdSource;
import org.springframework.social.security.AuthenticationNameUserIdSource;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * Created by Arnaud on 03/08/2015.
 */
@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
    @Autowired
    UserRepository userRepository;	
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService((UserDetailsService) socialUsersDetailService());
    }    
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
//            .httpBasic()
//        .and()
            .formLogin()
                .loginPage("http://localhost:3000/signin")
        .and()
            .authorizeRequests()
            .antMatchers("/api/authenticationCheck", "/auth/**").permitAll()
            .anyRequest().authenticated()
        .and()
            .logout()
                .deleteCookies("JSESSIONID")
                .logoutUrl("/api/logout")
        .and()
            .rememberMe()
        .and()
            .apply(getSpringSocialConfigurer())
        .and()
            .csrf()
                .disable();
//            .csrfTokenRepository(csrfTokenRepository())
//        .and()
//            .addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class);
    }

    private CsrfTokenRepository csrfTokenRepository() {
        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
        repository.setHeaderName("X-XSRF-TOKEN");
        return repository;
    }

    @Bean
    public SocialUserDetailsService socialUsersDetailService() {
        return new SimpleSocialUsersDetailService(userRepository);
    }

    @Bean
    public UserIdSource userIdSource() {
        return new AuthenticationNameUserIdSource();
    }

    private SpringSocialConfigurer getSpringSocialConfigurer() {
        final SpringSocialConfigurer config = new SpringSocialConfigurer();
        config.alwaysUsePostLoginUrl(true);
        config.postLoginUrl("http://localhost:3000");
        return config;
    }
}

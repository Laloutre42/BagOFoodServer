package com.zed.bagofood.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import lombok.Data;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.social.security.SocialUserDetails;

/**
 * Created by Arnaud on 03/05/2015.
 */
@Data
@Document
public class User implements SocialUserDetails {

    @Id
    private String id;

    @NotBlank
    private String name;

    @NotBlank
    private String password;

    private UserRole role = UserRole.USER;

    @NotBlank
    private String email;
    
    private boolean accountLocked;    

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new UserRole[] { role });
	}

	@Override
	public String getUsername() {
		return getUserId();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return !accountLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String getUserId() {
		return this.name;
	}

}
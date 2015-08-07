package com.zed.bagofood.model;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by Arnaud on 01/08/2015.
 */
public enum UserRole implements GrantedAuthority {

    ADMIN,
    USER;

	@Override
	public String getAuthority() {
		return this.toString();
	}
}

package com.zed.bagofood.model;

import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.social.security.SocialUserDetails;

import lombok.Data;

/**
 * Created by Arnaud on 03/05/2015.
 */
@Data
@Entity
public class User implements SocialUserDetails {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank
    private String name;

    @NotBlank
    private String password;

    private UserRole role = UserRole.USER;

    @NotBlank
    private String email;

    private String providerId;

    private String nameProviderId;

    private boolean accountLocked;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new UserRole[]{role});
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
        return this.name + "["+ this.providerId + "]";
    }

}
package com.zed.bagofood.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class UserSocialConnection {
	
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
    private long userId;
    private String providerId;
    private String providerUserId;
    private int rank;
    private String displayName;
    private String profileUrl;
    private String imageUrl;
    private String accessToken;
    private String secret;
    private String refreshToken;
    private long expireTime;

    public UserSocialConnection(long userId, String providerId, String providerUserId, int rank, String displayName, String profileUrl,
                                String imageUrl, String accessToken, String secret, String refreshToken, Long expireTime) {
        this.userId = userId;
        this.providerId = providerId;
        this.providerUserId = providerUserId;
        this.rank = rank;
        this.displayName = displayName;
        this.profileUrl = profileUrl;
        this.imageUrl = imageUrl;
        this.accessToken = accessToken;
        this.secret = secret;
        this.refreshToken = refreshToken;
        this.expireTime = expireTime;
    }
}

package com.zed.social.mongo.model;

import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class UserSocialConnection {
	
    @Id
    private String id;
	
    private String userId;
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

    public UserSocialConnection(String userId, String providerId, String providerUserId, int rank, String displayName, String profileUrl,
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

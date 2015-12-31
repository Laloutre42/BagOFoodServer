package com.zed.bagofood.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "userconnection")
public class UserConnection {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "userId", length = 255, nullable = false)
	private String userId;

	@Column(name = "providerId", length = 255, nullable = false)
	private String providerId;

	@Column(name = "providerUserId", length = 255)
	private String providerUserId;

	@Column(name = "rank", nullable = false)
	private int rank;

	@Column(name = "displayName", length = 255)
	private String displayName;

	@Column(name = "profileUrl", length = 512)
	private String profileUrl;

	@Column(name = "imageUrl", length = 512)
	private String imageUrl;

	@Column(name = "accessToken", length = 512, nullable = false)
	private String accessToken;

	@Column(name = "secret", length = 512)
	private String secret;

	@Column(name = "refreshToken", length = 512)
	private String refreshToken;

	@Column(name = "expireTime")
	private long expireTime;

	public UserConnection(String userId,
			String providerId,
			String providerUserId,
			int rank,
			String displayName,
			String profileUrl,
			String imageUrl,
			String accessToken,
			String secret,
			String refreshToken,
			long expireTime) {
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

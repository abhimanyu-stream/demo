package com.analytiq.jobportalunnati.core.service;

import java.time.Instant;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.analytiq.jobportalunnati.core.dao.RefreshTokenRepository;
import com.analytiq.jobportalunnati.core.dao.UserRepository;
import com.analytiq.jobportalunnati.core.exception.TokenRefreshException;
import com.analytiq.jobportalunnati.core.model.RefreshToken;

@Service
public class RefreshTokenService {

	@Value("${app.jwtRefreshExpirationMs}")
	private Long refreshTokenDurationMs;

	@Autowired
	private RefreshTokenRepository refreshTokenRepository;

	@Autowired
	private UserRepository userRepository;

	public RefreshToken findByRefreshToken(String token) {
		// String token is of type RefreshToken
		
		
		return refreshTokenRepository.findByToken(token);
	}

	public RefreshToken createRefreshToken(Long userId) {
		RefreshToken refreshToken = new RefreshToken();

		refreshToken.setUser(userRepository.findById(userId).get());
		refreshToken.setExpiryDate(Instant.now().plusMillis(refreshTokenDurationMs));
		refreshToken.setToken(UUID.randomUUID().toString());

		refreshToken = refreshTokenRepository.save(refreshToken);
		return refreshToken;
	}

	@Transactional
	public Long deleteByUserId(Long userId) {
		return refreshTokenRepository.deleteByUser(userRepository.findById(userId).get());
	}

	
	public RefreshToken verifyRefreshTokenExpiration(RefreshToken refreshToken) throws TokenRefreshException {

		if (refreshToken.getExpiryDate().compareTo(Instant.now()) < 0) {
			//delete invalid refreshToken from db
			refreshTokenRepository.delete(refreshToken);
			System.out.println(refreshToken.getToken() + "   Refresh token was expired. Please make a new signin request");
			throw  new TokenRefreshException(refreshToken.getToken(), "Refresh token was expired. Please make a new signin request");
		}

		return refreshToken;// now still RefreshTokenis valid
	}
}
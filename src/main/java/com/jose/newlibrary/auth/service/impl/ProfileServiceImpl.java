
package com.jose.newlibrary.auth.service.impl;

import java.util.UUID;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jose.newlibrary.auth.model.dto.ProfileRequest;
import com.jose.newlibrary.auth.model.dto.ProfileResponse;
import com.jose.newlibrary.auth.model.entity.UserEntity;
import com.jose.newlibrary.auth.repository.UserRepository;
import com.jose.newlibrary.auth.service.ProfileService;

import lombok.RequiredArgsConstructor;

/**
 * ProfileServiceImpl
 */
@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

	@Override
	public ProfileResponse createProfile(ProfileRequest request) {
        UserEntity newProfile = convertToUserEntity(request);
        newProfile = userRepository.save(newProfile);
        return convertToProfileResponse(newProfile);
	}

    private ProfileResponse convertToProfileResponse(UserEntity newProfile) {
        return ProfileResponse.builder()
            .name(newProfile.getName())
            .email(newProfile.getEmail())
            .userId(newProfile.getUserId())
            .isAccountVerified(newProfile.getIsAccountVerified())
            .build();
	}

	private UserEntity convertToUserEntity(ProfileRequest request) {
        return UserEntity.builder()
            .name(request.getName())
            .email(request.getEmail())
            .userId(UUID.randomUUID().toString())
            .password(passwordEncoder.encode(request.getPassword()))
            .isAccountVerified(false)
            .resetOtpExpireAt(0L)
            .resetOtp(null)
            .verifyOtp(null)
            .verifyOtpExpireAt(0L)
            .build();
    }
    
}

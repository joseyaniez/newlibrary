
package com.jose.newlibrary.auth.service;

import com.jose.newlibrary.auth.model.dto.ProfileRequest;
import com.jose.newlibrary.auth.model.dto.ProfileResponse;

/**
 * ProfileService
 */
public interface ProfileService {
    ProfileResponse createProfile(ProfileRequest request);
}

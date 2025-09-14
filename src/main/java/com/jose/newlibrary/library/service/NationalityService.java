
package com.jose.newlibrary.library.service;

import com.jose.newlibrary.library.model.dto.request.NationalityRequest;
import com.jose.newlibrary.library.model.dto.response.NationalityResponse;

/**
 * NationalityService
 */
public interface NationalityService {
    NationalityResponse createNationality(NationalityRequest nationalityRequest);
    NationalityResponse getNationality(Long id);
    NationalityResponse updateNationality(Long id, NationalityRequest nationalityRequest);
    void deleteNationality(Long id);
}

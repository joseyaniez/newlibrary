
package com.jose.newlibrary.library.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jose.newlibrary.core.exception.exceptions.ResourceNotFoundException;
import com.jose.newlibrary.library.model.dto.request.NationalityRequest;
import com.jose.newlibrary.library.model.dto.response.NationalityResponse;
import com.jose.newlibrary.library.model.entity.Nationality;
import com.jose.newlibrary.library.repository.NationalityRepository;
import com.jose.newlibrary.library.service.NationalityService;

/**
 * NationalityServiceImpl
 */
@Service
public class NationalityServiceImpl implements NationalityService {

    private final NationalityRepository nationalityRepository;

    public NationalityServiceImpl(NationalityRepository nationalityRepository){
        this.nationalityRepository = nationalityRepository;
    }

	@Override
	public NationalityResponse createNationality(NationalityRequest nationalityRequest) {
        if(!nationalityRepository.existsByNameIgnoreCase(nationalityRequest.name())){
            throw new IllegalArgumentException("El nombre de nacionalidad ya existe");
        }
        Nationality nationality = new Nationality();
        nationality.setName(nationalityRequest.name());

        nationalityRepository.save(nationality);

        return new NationalityResponse(
            nationality.getId(),
            nationality.getName(),
            nationality.getAuthors()
        );
	}

	@Override
	public NationalityResponse getNationality(Long id) {
        Nationality nationality = nationalityRepository.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("La nacionalidad con id " + id + " no existe")
        );

        return new NationalityResponse(
            nationality.getId(),
            nationality.getName(),
            nationality.getAuthors()
        );
	}

	@Override
	public NationalityResponse updateNationality(Long id, NationalityRequest nationalityRequest) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'updateNationality'");
	}

	@Override
	public Boolean deleteNationality(Long id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'deleteNationality'");
	}

    
}

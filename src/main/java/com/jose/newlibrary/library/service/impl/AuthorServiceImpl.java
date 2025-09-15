
package com.jose.newlibrary.library.service.impl;

import org.springframework.stereotype.Service;

import com.jose.newlibrary.core.exception.exceptions.ResourceNotFoundException;
import com.jose.newlibrary.library.model.dto.request.AuthorRequest;
import com.jose.newlibrary.library.model.dto.response.AuthorResponse;
import com.jose.newlibrary.library.model.entity.Author;
import com.jose.newlibrary.library.model.entity.Nationality;
import com.jose.newlibrary.library.repository.AuthorRepository;
import com.jose.newlibrary.library.repository.NationalityRepository;
import com.jose.newlibrary.library.service.AuthorService;

/**
 * AuthorServiceImpl
 */
@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;
    private final NationalityRepository nationalityRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, NationalityRepository nationalityRepository){
        this.authorRepository = authorRepository;
        this.nationalityRepository = nationalityRepository;
    }

	@Override
	public AuthorResponse createAuthor(AuthorRequest authorRequest) {
        // Vamos a suponer que no pueden existir dos autores con el mismo nombre
        if(authorRepository.existsByNameIgnoreCase(authorRequest.name())){
            throw new IllegalArgumentException("Este nombre de escritor ya existe");
        }
        Nationality nationality = nationalityRepository.findById(authorRequest.nationalityId())
            .orElseThrow(() -> new ResourceNotFoundException("La nacionalidad con id " + authorRequest.nationalityId() + " para el autor no existe"));
        Author author = new Author();
        author.setName(authorRequest.name());
        if(authorRequest.birthDate() != null){
            author.setBirthdate(authorRequest.birthDate());
        }
        if(authorRequest.deathDate() != null){
            author.setDeathdate(authorRequest.deathDate());
        }
        author.setNationality(nationality);
        authorRepository.save(author);
        return new AuthorResponse(
            author.getId(),
            author.getName(),
            author.getBirthdate(),
            author.getDeathdate(),
            author.getNationality().getName()
        );
	}

	@Override
	public AuthorResponse getAuthor(Long id) {
        Author author = authorRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("El author con id " + id + " no existe"));
        return new AuthorResponse(
            author.getId(),
            author.getName(),
            author.getBirthdate(),
            author.getDeathdate(),
            author.getNationality().getName()
        );
	}

	@Override
	public AuthorResponse updateAuthor(Long id, AuthorRequest authorRequest) {
        Author author = authorRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("El author con id " + id + " no existe"));
        Nationality nationality = nationalityRepository.findById(authorRequest.nationalityId())
            .orElseThrow(() -> new ResourceNotFoundException("La nacionalidad con id " + authorRequest.nationalityId() + " para el autor no existe"));
        author.setName(authorRequest.name());
        if(authorRequest.birthDate() != null){
            author.setBirthdate(authorRequest.birthDate());
        }
        if(authorRequest.deathDate() != null){
            author.setDeathdate(authorRequest.deathDate());
        }
        author.setNationality(nationality);
        authorRepository.save(author);
        return new AuthorResponse(
            author.getId(),
            author.getName(),
            author.getBirthdate(),
            author.getDeathdate(),
            author.getNationality().getName()
        );
	}

	@Override
	public void deleteAuthor(Long id) {
        if(!authorRepository.existsById(id)){
            throw new ResourceNotFoundException("El autor con id " + id + " no existe");
        }
        authorRepository.deleteById(id);
	}

    
}

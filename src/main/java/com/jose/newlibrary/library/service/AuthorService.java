
package com.jose.newlibrary.library.service;

import com.jose.newlibrary.library.model.dto.request.AuthorRequest;
import com.jose.newlibrary.library.model.dto.response.AuthorResponse;

/**
 * AuthorService
 */
public interface AuthorService {
    AuthorResponse createAuthor(AuthorRequest authorRequest);
    AuthorResponse getAuthor(Long id);
    AuthorResponse getAuthorByName(String name);
    AuthorResponse updateAuthor(Long id, AuthorRequest authorRequest);
    void deleteAuthor(Long id);
}

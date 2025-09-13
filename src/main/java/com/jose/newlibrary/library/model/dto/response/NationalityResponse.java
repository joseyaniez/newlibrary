
package com.jose.newlibrary.library.model.dto.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jose.newlibrary.library.model.entity.Author;

/**
 * NationalityResponse
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record NationalityResponse(
    Long id,
    String name,
    List<Author> authors
) {}

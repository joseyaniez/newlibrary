
package com.jose.newlibrary.library.model.dto.response;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * BookResponse
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record BookResponse(
    Long id,
    String title,
    LocalDate publicationDate,
    String authorName
){}

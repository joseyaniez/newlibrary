
package com.jose.newlibrary.library.model.dto.response;

import java.time.LocalDate;

/**
 * BookResponse
 */
public record BookResponse(
    Long id,
    String title,
    LocalDate publicationDate,
    String authorName
){}

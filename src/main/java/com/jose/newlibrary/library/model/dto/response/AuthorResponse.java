
package com.jose.newlibrary.library.model.dto.response;

import java.time.LocalDate;

/**
 * AuthorResponse
 */
public record AuthorResponse(
    Long Id,
    String name,
    LocalDate birthDate,
    LocalDate deathDate,
    String nationality
){}

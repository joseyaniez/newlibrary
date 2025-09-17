
package com.jose.newlibrary.library.model.dto.request;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;

/**
 * BookRequest
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record BookRequest(
    @NotBlank
    @Pattern(
        regexp = "^[A-Za-zÁÉÍÓÚáéíóúÑñ ]+$",
        message = "El nombre solo puede contener letras y espacios"
    )
    String title,
    @PastOrPresent
    @JsonProperty("publication_date")
    LocalDate publicationDate,
    @NotNull
    @JsonAlias({"author_id", "author", "id_author"})
    Long authorId
) {}

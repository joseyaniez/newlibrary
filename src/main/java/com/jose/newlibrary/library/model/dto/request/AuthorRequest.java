
package com.jose.newlibrary.library.model.dto.request;

import java.time.LocalDate;

import org.antlr.v4.runtime.misc.NotNull;

import com.fasterxml.jackson.annotation.JsonAlias;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;

/**
 * AuthorRequest
 */
public record AuthorRequest(
    @NotBlank
    @Pattern(
        regexp = "^[A-Za-zÁÉÍÓÚáéíóúÑñ ]+$",
        message = "El nombre solo puede contener letras y espacios"
    )
    @JsonAlias({"name", "author_name", "author"})
    String name,

    @PastOrPresent(message = "La fecha de nacimiento no puede ser futura")
    @JsonAlias({"birth_date"})
    LocalDate birthDate,

    @PastOrPresent(message = "La fecha de fallecimiento no puede ser futura")
    @JsonAlias({"death_date"})
    LocalDate deathDate,

    @JsonAlias({"nationality_id", "nationality"})
    Long nationalityId
) {}

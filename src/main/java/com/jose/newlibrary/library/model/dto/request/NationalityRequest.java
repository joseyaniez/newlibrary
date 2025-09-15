

package com.jose.newlibrary.library.model.dto.request;

import com.fasterxml.jackson.annotation.JsonAlias;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

/**
 * NationalityRequest
 */
public record NationalityRequest(
    @NotBlank
    @Pattern(
        regexp = "^[A-Za-zÁÉÍÓÚáéíóúÑñ ]+$",
        message = "El nombre solo puede contener letras y espacios"
    )
    @JsonAlias({"nationality", "name", "nationality_name"})
    String name
) {}



package com.jose.newlibrary.library.model.dto.request;

import com.fasterxml.jackson.annotation.JsonAlias;

import jakarta.validation.constraints.NotBlank;

/**
 * NationalityRequest
 */
public record NationalityRequest(
    @NotBlank
    @JsonAlias({"nationality", "name", "nationality_name"})
    String name
) {}


package com.jose.newlibrary.auth.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * AuthResponse
 */
@Getter
@AllArgsConstructor
public class AuthResponse {
    private String email;
    private String token;
}

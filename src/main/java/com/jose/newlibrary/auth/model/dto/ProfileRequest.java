
package com.jose.newlibrary.auth.model.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * ProfileRequest
 */
@Data
@AllArgsConstructor
public class ProfileRequest {

    @NotBlank(message = "Debe proporcionar un nombre")
    private String name;

    @Email(message = "El Email enviado no es válido")
    @NotNull(message = "Debe proporcionar un email")
    private String email;

    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    private String password;
}

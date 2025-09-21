
package com.jose.newlibrary.auth.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * ProfileRequest
 */
@Data
@AllArgsConstructor
public class ProfileRequest {

    private String name;
    private String email;
    private String password;
}

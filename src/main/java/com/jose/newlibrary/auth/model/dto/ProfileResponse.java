
package com.jose.newlibrary.auth.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ProfileResponse
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfileResponse {

    private String userId;
    private String name;
    private String email;
    private Boolean isAccountVerified;
}


package com.jose.newlibrary.core.exception;

import java.time.LocalDateTime;

/**
 * ErrorResponse
 */
public record ErrorResponse(
    String error,
    String message,
    int status,
    LocalDateTime timestamp
) {}

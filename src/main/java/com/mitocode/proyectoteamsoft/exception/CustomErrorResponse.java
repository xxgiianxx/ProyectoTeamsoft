package com.mitocode.proyectoteamsoft.exception;

import java.time.LocalDateTime;

public record CustomErrorResponse(
        LocalDateTime datetime,
        String message,
        String path
) {
}
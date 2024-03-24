package com.micro.micro.dto.mensaje;

import java.time.LocalDateTime;

public record MensajeDto(Long id,
                         String creator,
                         String destinator,
                         String contenido,
                         LocalDateTime created_at) {
}

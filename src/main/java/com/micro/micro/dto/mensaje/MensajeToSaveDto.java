package com.micro.micro.dto.mensaje;

import com.micro.micro.dto.usuario.UsuarioDto;

import java.time.LocalDateTime;

public record MensajeToSaveDto(String creator,
                               String destinator,
                               String contenido,
                               LocalDateTime created_at,
                               UsuarioDto usuario) {
}

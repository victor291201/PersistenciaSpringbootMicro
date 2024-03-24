package com.micro.micro.dto.sugerencia;

import com.micro.micro.dto.usuario.UsuarioDto;

import java.time.LocalDateTime;

public record SugerenciaToSaveDto(String descripcion,
                                  LocalDateTime create_at,
                                  UsuarioDto usuario) {
}

package com.micro.micro.dto.partida;

import com.micro.micro.dto.usuario.UsuarioDto;

import java.time.LocalDateTime;
import java.util.Set;

public record PartidaToSaveDto(String creador,
                               String deporte,
                               String ciudad,
                               String Provincia,
                               LocalDateTime fecha,
                               LocalDateTime hora_comienzo,
                               LocalDateTime hora_final,
                               Integer participantes,
                               Integer suplentes,
                               String comentarios) {
}

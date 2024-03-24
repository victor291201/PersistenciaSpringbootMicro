package com.micro.micro.dto.usuario;

import com.micro.micro.dto.mensaje.MensajeDto;
import com.micro.micro.dto.sugerencia.SugerenciaDto;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

public record UsuarioDto(Long id,
                         String nombre,
                         String apellido,
                         Integer edad,
                         String username,
                         String email,
                         Boolean enabled,
                         String foto,
                         String rol,
                         Set<SugerenciaDto> sugerencias,
                         Set<MensajeDto> mensajes) {
    public Set<SugerenciaDto> sugerencias() {
        return Collections.unmodifiableSet( sugerencias );
    }

    public Set<MensajeDto> mensajes() {
        return Collections.unmodifiableSet( mensajes );
    }

}

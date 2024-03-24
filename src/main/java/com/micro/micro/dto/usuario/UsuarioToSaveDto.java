package com.micro.micro.dto.usuario;

public record UsuarioToSaveDto(String nombre,
                               String apellido,
                               Integer edad,
                               String username,
                               String email,
                               String password,
                               String rep_password,
                               Boolean enabled,
                               String foto,
                               String rol) {
}

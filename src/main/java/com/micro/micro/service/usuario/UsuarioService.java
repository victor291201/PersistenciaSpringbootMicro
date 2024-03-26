package com.micro.micro.service.usuario;

import com.micro.micro.dto.usuario.UsuarioDto;
import com.micro.micro.dto.usuario.UsuarioToSaveDto;
import com.micro.micro.exception.usuario.UsuarioNotFoundException;

import java.util.List;
import java.util.Set;

public interface UsuarioService {
    List<UsuarioDto> getAllUsers();
    UsuarioDto guardar(UsuarioToSaveDto usuario);
    UsuarioDto actualizar(Long id, UsuarioToSaveDto usuario);
    UsuarioDto buscarPorId(Long id) throws UsuarioNotFoundException;
    void eliminarUsuario(Long id);
}

package com.micro.micro.service.usuario;

import com.micro.micro.dto.usuario.UsuarioDto;
import com.micro.micro.dto.usuario.UsuarioMapperImpl;
import com.micro.micro.dto.usuario.UsuarioToSaveDto;
import com.micro.micro.entities.Usuario;
import com.micro.micro.exception.usuario.UsuarioNotFoundException;
import com.micro.micro.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapperImpl usuarioMapper;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, UsuarioMapperImpl usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public List<UsuarioDto> getAllUsers() {
        List<Usuario> usuarios = this.usuarioRepository.findAll();
        return this.usuarioMapper.usuariosToUsuariosDto(usuarios);
    }

    @Override
    public UsuarioDto guardar(UsuarioToSaveDto usuario) {
        return null;
    }

    @Override
    public UsuarioDto actualizar(Long id, UsuarioToSaveDto usuario) {
        return null;
    }

    @Override
    public UsuarioDto buscarPorId(Long id) throws UsuarioNotFoundException {
        return null;
    }

    @Override
    public void eliminarUsuario(Long id) {

    }
}

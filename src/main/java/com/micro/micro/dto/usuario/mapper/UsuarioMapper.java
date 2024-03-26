package com.micro.micro.dto.usuario.mapper;

import com.micro.micro.dto.usuario.UsuarioDto;
import com.micro.micro.dto.usuario.UsuarioToSaveDto;
import com.micro.micro.entities.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UsuarioMapper {

    UsuarioDto usuarioToUsuarioDto(Usuario usuario);
    Usuario usuarioToSaveDtoToUsuario(UsuarioToSaveDto usuarioToSaveDto);
}

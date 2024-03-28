package com.micro.micro.dto.usuario;

import com.micro.micro.dto.usuario.UsuarioDto;
import com.micro.micro.dto.usuario.UsuarioToSaveDto;
import com.micro.micro.entities.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UsuarioMapper {

    UsuarioDto usuarioToUsuarioDto(Usuario usuario);

    @Mapping(target = "rol", expression = "java(\"client\")")
    @Mapping(target = "enabled", expression = "java(true)")
    Usuario usuarioToSaveDtoToUsuario(UsuarioToSaveDto usuarioToSaveDto);
    List<UsuarioDto> usuariosToUsuariosDto( List<Usuario> usuarios );
}

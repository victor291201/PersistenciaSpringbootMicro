package com.micro.micro.dto.mensaje;

import com.micro.micro.entities.Mensaje;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MensajeMapper {

    MensajeDto mensajeToMensajeDto(Mensaje mensaje);
    Mensaje mensajeToSaveToMensaje(MensajeToSaveDto mensajeToSaveDto);
}

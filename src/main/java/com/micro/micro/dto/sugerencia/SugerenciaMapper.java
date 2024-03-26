package com.micro.micro.dto.sugerencia;


import com.micro.micro.entities.Sugerencia;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface SugerenciaMapper {

    SugerenciaDto sugerenciaToSugerenciaDto(Sugerencia sugerencia);
    Sugerencia sugerenciaToSaveToSugerencia( SugerenciaToSaveDto sugerenciaToSaveDto );
}

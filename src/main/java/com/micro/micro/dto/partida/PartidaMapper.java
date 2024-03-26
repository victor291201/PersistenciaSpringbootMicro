package com.micro.micro.dto.partida;

import com.micro.micro.entities.Partida;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PartidaMapper {
    PartidaDto partidaToPartidaDto(Partida partida);
    Partida partidaTosaveToPartida( PartidaToSaveDto partidaToSaveDto);
}

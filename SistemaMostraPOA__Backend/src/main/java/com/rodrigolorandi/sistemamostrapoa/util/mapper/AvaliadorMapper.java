package com.rodrigolorandi.sistemamostrapoa.util.mapper;

import com.rodrigolorandi.sistemamostrapoa.dto.AvaliadorCreateDTO;
import com.rodrigolorandi.sistemamostrapoa.dto.AvaliadorDTO;
import com.rodrigolorandi.sistemamostrapoa.entity.Avaliador;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface AvaliadorMapper {

    @Mapping(target = "id", ignore = true)
    Avaliador buildEntity(AvaliadorCreateDTO requestDTO);

    AvaliadorDTO buildDTO(Avaliador avaliador);

}

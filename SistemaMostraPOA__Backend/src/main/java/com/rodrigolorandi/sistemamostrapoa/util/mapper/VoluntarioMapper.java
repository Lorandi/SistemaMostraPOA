package com.rodrigolorandi.sistemamostrapoa.util.mapper;

import com.rodrigolorandi.sistemamostrapoa.dto.VoluntarioCreateDTO;
import com.rodrigolorandi.sistemamostrapoa.dto.VoluntarioDTO;
import com.rodrigolorandi.sistemamostrapoa.entity.Voluntario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface VoluntarioMapper {

    @Mapping(target = "id", ignore = true)
    Voluntario buildEntity(VoluntarioCreateDTO requestDTO);

    VoluntarioDTO buildDTO(Voluntario voluntario);

}

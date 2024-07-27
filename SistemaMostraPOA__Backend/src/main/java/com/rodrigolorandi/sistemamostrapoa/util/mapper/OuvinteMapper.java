package com.rodrigolorandi.sistemamostrapoa.util.mapper;


import com.rodrigolorandi.sistemamostrapoa.dto.OuvinteCreateDTO;
import com.rodrigolorandi.sistemamostrapoa.dto.OuvinteDTO;
import com.rodrigolorandi.sistemamostrapoa.entity.Ouvinte;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface OuvinteMapper {

    @Mapping(target = "id", ignore = true)
    Ouvinte buildEntity(OuvinteCreateDTO requestDTO);

    OuvinteDTO buildDTO(Ouvinte ouvinte);

}

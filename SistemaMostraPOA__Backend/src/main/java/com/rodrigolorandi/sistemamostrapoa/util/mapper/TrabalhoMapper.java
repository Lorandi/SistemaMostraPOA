package com.rodrigolorandi.sistemamostrapoa.util.mapper;

import com.rodrigolorandi.sistemamostrapoa.dto.TrabalhoCreateDTO;
import com.rodrigolorandi.sistemamostrapoa.dto.TrabalhoDTO;
import com.rodrigolorandi.sistemamostrapoa.entity.Trabalho;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface TrabalhoMapper {

    @Mapping(target = "id", ignore = true)
    Trabalho buildEntity(TrabalhoCreateDTO requestDTO);

    TrabalhoDTO buildDTO(Trabalho Trabalho);

}

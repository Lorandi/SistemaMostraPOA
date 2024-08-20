package com.rodrigolorandi.sistemamostrapoa.util.mapper;


import com.rodrigolorandi.sistemamostrapoa.dto.ParticipanteTrabalhoCreateDTO;
import com.rodrigolorandi.sistemamostrapoa.dto.ParticipanteTrabalhoDTO;
import com.rodrigolorandi.sistemamostrapoa.entity.ParticipanteTrabalho;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ParticipanteTrabalhoMapper {

    @Mapping(target = "id", ignore = true)
    ParticipanteTrabalho buildEntity(ParticipanteTrabalhoCreateDTO requestDTO);

    ParticipanteTrabalhoDTO buildDTO(ParticipanteTrabalho ParticipanteTrabalho);

}

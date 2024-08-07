package com.rodrigolorandi.sistemamostrapoa.util.mapper;


import com.rodrigolorandi.sistemamostrapoa.dto.DisponibilidadeHorarioDTO;
import com.rodrigolorandi.sistemamostrapoa.entity.DisponibilidadeHorario;
import org.mapstruct.Mapper;

@Mapper
public interface DisponibilidadeHorarioMapper {

    DisponibilidadeHorarioDTO buildDTO(DisponibilidadeHorario disponibilidadeHoario);

}

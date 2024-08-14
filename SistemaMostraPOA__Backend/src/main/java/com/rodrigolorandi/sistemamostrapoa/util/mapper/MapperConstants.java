package com.rodrigolorandi.sistemamostrapoa.util.mapper;

import org.mapstruct.factory.Mappers;

public class MapperConstants {

    private MapperConstants() {
    }

    public static final OuvinteMapper ouvinteMapper = Mappers.getMapper(OuvinteMapper.class);
    public static final AvaliadorMapper avaliadorMapper = Mappers.getMapper(AvaliadorMapper.class);
    public static final DisponibilidadeHorarioMapper disponibilidadeHorarioMapper = Mappers.getMapper(DisponibilidadeHorarioMapper.class);
    public static final TrabalhoMapper trabalhoMapper = Mappers.getMapper(TrabalhoMapper.class);
}
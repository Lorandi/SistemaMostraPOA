package com.rodrigolorandi.sistemamostrapoa.util.mapper;

import org.mapstruct.factory.Mappers;

public class MapperConstants {

    private MapperConstants() {
    }
    public static final OuvinteMapper ouvinteMapper = Mappers.getMapper(OuvinteMapper.class);

}

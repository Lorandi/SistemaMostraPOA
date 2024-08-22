package com.rodrigolorandi.sistemamostrapoa.enums;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.rodrigolorandi.sistemamostrapoa.enums.serializer.EnumSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonSerialize(using = EnumSerializer.class)
public enum TurnoEnum implements EnumDescription {

    MANHA("Manhã"),
    TARDE("Tarde"),
    NOITE("Noite");

    private final String description;
}

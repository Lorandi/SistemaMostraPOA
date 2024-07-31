package com.rodrigolorandi.sistemamostrapoa.enums;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.rodrigolorandi.sistemamostrapoa.enums.serializer.EnumSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonSerialize(using = EnumSerializer.class)
public enum TematicasEnum implements EnumDescription {

    CIENCIAS_EXATAS_E_DA_TERRA("I - Ciências Exatas e da Terra"),
    CIENCIAS_BIOLOGICAS(" II - Ciências Biológicas"),
    ENGENHARIAS("III - Engenharias"),
    CIENCIAS_DA_SAUDE("IV - Ciências da Saúde"),
    CIENCIAS_AGRARIAS("V - Ciências Agrárias"),
    CIENCIAS_SOCIAIS_APLICADAS("VI - Ciências Sociais Aplicadas"),
    CIENCIAS_HUMANAS("VII - Ciências Humanas"),
    LINGUISTICA_LETRAS_E_ARTES("VIII - Linguística, Letras e Artes"),
    MULTIDISCIPLINAR("IX - Multidisciplinar");

    private final String description;
}

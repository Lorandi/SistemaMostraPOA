package com.rodrigolorandi.sistemamostrapoa.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCodeEnum {

    ERROR_GENERIC_EXCEPTION("error.generic.exception"),
    ERROR_DATE_FORMAT("error.date.format"),
    ERRO_OUVINTE_NAO_ENCONTRADO("erro.ouvinte.nao.encontrado"),
    ERRO_AVALIADOR_NAO_ENCONTRADO("erro.avaliador.nao.encontrado"),
    ERRO_DISPONIBILIDADE_DE_HORARIO_NAO_ENCONTRADA("erro.disponibilidade.de.horario.nao.encontrada"),;

    private final String messageKey;
}

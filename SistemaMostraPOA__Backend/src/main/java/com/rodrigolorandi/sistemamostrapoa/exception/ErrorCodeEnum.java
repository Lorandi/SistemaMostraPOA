package com.rodrigolorandi.sistemamostrapoa.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCodeEnum {

    ERROR_GENERIC_EXCEPTION("error.generic.exception"),
    ERROR_DATE_FORMAT("error.date.format"),
    ERRO_OUVINTE_NAO_ENCONTRADO("erro.ouvinte.nao.encontrado"),;

    private final String messageKey;
}

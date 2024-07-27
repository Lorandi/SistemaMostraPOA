package com.rodrigolorandi.sistemamostrapoa.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCodeEnum {

    ERROR_GENERIC_EXCEPTION("error.generic.exception"),
    ERROR_DATE_FORMAT("error.date.format"),
    ERROR_PERSON_NOT_FOUND("error.pessoa.not.found");

    private final String messageKey;
}

package com.rodrigolorandi.sistemamostrapoa.helper;

import com.rodrigolorandi.sistemamostrapoa.exception.ErrorCodeEnum;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.converter.HttpMessageNotReadableException;

import java.util.Locale;

@RequiredArgsConstructor
public class MessageHelper {

    private final MessageSource messageSource;

    private MessageSourceAccessor accessor;

    @PostConstruct
    public void init() {
        accessor = new MessageSourceAccessor(messageSource, Locale.getDefault());
    }

    public String get(ErrorCodeEnum code, Object... args) {
        return accessor.getMessage(code.getMessageKey(), args);
    }

    public String get(String code, Object... args) {
        try{
            return accessor.getMessage(code, args);
        }catch (NoSuchMessageException e){
            return code;
        }
    }
}

package com.rodrigolorandi.sistemamostrapoa.dto;

import lombok.Builder;
import lombok.NonNull;
import lombok.With;

@With
public record OuvinteUpdateDTO(@NonNull Long id,
                               @NonNull String name,
                               @NonNull String email,
                               @NonNull String cpf,
                               String phone
                              ) {
    @Builder
    public OuvinteUpdateDTO {
    }
}

package com.rodrigolorandi.sistemamostrapoa.dto;

import lombok.Builder;
import lombok.NonNull;
import lombok.With;

@With
public record AvaliadorUpdateDTO(@NonNull Long id,
                                 @NonNull String name,
                                 @NonNull String email,
                                 @NonNull String cpf,
                                 String phone,
                                 String institutionalAffiliation,
                                 String lattes
                              ) {
    @Builder
    public AvaliadorUpdateDTO {
    }
}

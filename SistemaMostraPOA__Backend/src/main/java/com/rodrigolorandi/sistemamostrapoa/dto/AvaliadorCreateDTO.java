package com.rodrigolorandi.sistemamostrapoa.dto;

import lombok.Builder;
import lombok.NonNull;
import lombok.With;

@With
public record AvaliadorCreateDTO(@NonNull String name,
                                 @NonNull String email,
                                 @NonNull String cpf,
                                 String phone,
                                 @NonNull
                                 String institutionalAffiliation,
                                 String lattes
                              ) {
    @Builder
    public AvaliadorCreateDTO {
    }
}

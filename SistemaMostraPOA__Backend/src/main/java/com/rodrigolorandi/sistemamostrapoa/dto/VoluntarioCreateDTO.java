package com.rodrigolorandi.sistemamostrapoa.dto;

import lombok.Builder;
import lombok.NonNull;
import lombok.With;

@With
public record VoluntarioCreateDTO(@NonNull String name,
                                  @NonNull String email,
                                  @NonNull String cpf,
                                  String phone,
                                  @NonNull String course
                              ) {
    @Builder
    public VoluntarioCreateDTO {
    }
}

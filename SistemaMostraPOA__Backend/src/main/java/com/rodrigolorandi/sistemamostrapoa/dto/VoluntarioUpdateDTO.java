package com.rodrigolorandi.sistemamostrapoa.dto;

import lombok.Builder;
import lombok.NonNull;
import lombok.With;

@With
public record VoluntarioUpdateDTO(@NonNull Long id,
                                  @NonNull String name,
                                  @NonNull String email,
                                  @NonNull String cpf,
                                  String phone,
                                  @NonNull String course
                              ) {
    @Builder
    public VoluntarioUpdateDTO {
    }
}

package com.rodrigolorandi.sistemamostrapoa.dto;

import lombok.Builder;
import lombok.NonNull;
import lombok.With;

import java.util.List;

@With
public record VoluntarioDisponibilidadeCreateDTO(@NonNull Long voluntarioId,
                                                 @NonNull List<Long> disponibilidadeHorarioId
                                                ) {
    @Builder
    public VoluntarioDisponibilidadeCreateDTO {
    }
}

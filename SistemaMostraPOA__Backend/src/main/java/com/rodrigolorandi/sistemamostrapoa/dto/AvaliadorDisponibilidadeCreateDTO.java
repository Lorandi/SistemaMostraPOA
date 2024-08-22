package com.rodrigolorandi.sistemamostrapoa.dto;

import lombok.Builder;
import lombok.NonNull;
import lombok.With;

import java.util.List;

@With
public record AvaliadorDisponibilidadeCreateDTO(@NonNull Long avaliadorId,
                                                @NonNull List<Long> disponibilidadeHorarioId
                                                ) {
    @Builder
    public AvaliadorDisponibilidadeCreateDTO {
    }
}

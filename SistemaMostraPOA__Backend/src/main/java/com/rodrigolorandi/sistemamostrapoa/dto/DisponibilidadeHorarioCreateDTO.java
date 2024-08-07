package com.rodrigolorandi.sistemamostrapoa.dto;

import lombok.Builder;
import lombok.NonNull;
import lombok.With;

import java.time.LocalDate;

@With
public record DisponibilidadeHorarioCreateDTO(@NonNull LocalDate data,
                                              @NonNull String turno) {
    @Builder
    public DisponibilidadeHorarioCreateDTO {
    }
}
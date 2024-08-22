package com.rodrigolorandi.sistemamostrapoa.dto;

import com.rodrigolorandi.sistemamostrapoa.enums.TurnoEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Builder;
import lombok.NonNull;
import lombok.With;

import java.time.LocalDate;

@With
public record DisponibilidadeHorarioCreateDTO(@NonNull LocalDate data,
                                              @NonNull TurnoEnum turno) {
    @Builder
    public DisponibilidadeHorarioCreateDTO {
    }
}
package com.rodrigolorandi.sistemamostrapoa.dto;

import lombok.Builder;
import lombok.With;

import java.time.LocalDate;

@With
public record DisponibilidadeHorarioDTO(Long id,
                                        LocalDate data,
                                        String diaSemana,
                                        String turno) {
    @Builder
    public DisponibilidadeHorarioDTO {
    }
}

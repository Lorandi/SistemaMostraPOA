package com.rodrigolorandi.sistemamostrapoa.dto;

import com.rodrigolorandi.sistemamostrapoa.enums.TurnoEnum;
import lombok.Builder;
import lombok.With;

import java.time.LocalDate;

@With
public record DisponibilidadeHorarioDTO(Long id,
                                        LocalDate data,
                                        String diaSemana,
                                        TurnoEnum turno) {
    @Builder
    public DisponibilidadeHorarioDTO {
    }
}

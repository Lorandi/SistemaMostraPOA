package com.rodrigolorandi.sistemamostrapoa.dto;

import lombok.Builder;
import lombok.With;

import java.util.List;

@With
public record VoluntarioDisponibilidadeDTO(Long voluntarioId,
                                           List<DisponibilidadeHorarioDTO> disponibilidadeHorarios
                                                ) {
    @Builder
    public VoluntarioDisponibilidadeDTO {
    }
}

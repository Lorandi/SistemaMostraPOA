package com.rodrigolorandi.sistemamostrapoa.dto;

import lombok.Builder;
import lombok.With;

import java.util.List;

@With
public record AvaliadorDisponibilidadeDTO(Long avaliadorId,
                                          List<DisponibilidadeHorarioDTO> disponibilidadeHorarios
                                                ) {
    @Builder
    public AvaliadorDisponibilidadeDTO {
    }
}

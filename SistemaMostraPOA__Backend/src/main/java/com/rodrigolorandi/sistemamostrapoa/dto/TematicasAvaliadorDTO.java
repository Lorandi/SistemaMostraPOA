package com.rodrigolorandi.sistemamostrapoa.dto;

import com.rodrigolorandi.sistemamostrapoa.enums.TematicasEnum;
import lombok.Builder;
import lombok.With;

import java.util.List;

@With
public record TematicasAvaliadorDTO(Long avaliadorId,
                                   List<TematicasEnum> tematicas
) {
    @Builder
    public TematicasAvaliadorDTO {
    }
}

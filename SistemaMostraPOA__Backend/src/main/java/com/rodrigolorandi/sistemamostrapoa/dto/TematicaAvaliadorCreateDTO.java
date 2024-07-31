package com.rodrigolorandi.sistemamostrapoa.dto;

import com.rodrigolorandi.sistemamostrapoa.enums.TematicasEnum;
import lombok.Builder;
import lombok.NonNull;
import lombok.With;

import java.util.List;

@With
public record TematicaAvaliadorCreateDTO(@NonNull Long avaliadorId,
                                         @NonNull List<TematicasEnum> tematica
) {
    @Builder
    public TematicaAvaliadorCreateDTO {
    }
}

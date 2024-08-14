package com.rodrigolorandi.sistemamostrapoa.dto;

import com.rodrigolorandi.sistemamostrapoa.enums.ApresentacaoEnum;
import com.rodrigolorandi.sistemamostrapoa.enums.TematicasEnum;
import lombok.Builder;
import lombok.NonNull;
import lombok.With;

@With
public record TrabalhoUpdateDTO(@NonNull Long id,
                                @NonNull String titulo,
                                @NonNull ApresentacaoEnum apresentacao,
                                @NonNull TematicasEnum tematica,
                                String observacao,
                                @NonNull String linkResumo,
                                @NonNull Boolean aceite
                              ) {
    @Builder
    public TrabalhoUpdateDTO {
    }
}
package com.rodrigolorandi.sistemamostrapoa.dto;

import com.rodrigolorandi.sistemamostrapoa.enums.ApresentacaoEnum;
import com.rodrigolorandi.sistemamostrapoa.enums.TematicasEnum;
import lombok.With;

@With
public record TrabalhoDTO(Long id,
                          String titulo,
                          ApresentacaoEnum apresentacao,
                          TematicasEnum tematica,
                          String observacao,
                          String linkResumo,
                          Boolean aceite
) {
}
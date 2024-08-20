package com.rodrigolorandi.sistemamostrapoa.dto;

import com.rodrigolorandi.sistemamostrapoa.enums.TipoParticipanteTrabalhoEnum;
import lombok.Builder;
import lombok.NonNull;
import lombok.With;

@With
public record ParticipanteTrabalhoCreateDTO(@NonNull Long trabalhoId,
                                            @NonNull String name,
                                            @NonNull String email,
                                            @NonNull String cpf,
                                            String phone,
                                            @NonNull TipoParticipanteTrabalhoEnum tipoParticipante
                              ) {
    @Builder
    public ParticipanteTrabalhoCreateDTO {
    }
}

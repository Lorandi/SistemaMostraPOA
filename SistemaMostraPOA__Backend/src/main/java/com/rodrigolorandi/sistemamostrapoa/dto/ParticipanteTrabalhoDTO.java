package com.rodrigolorandi.sistemamostrapoa.dto;

import com.rodrigolorandi.sistemamostrapoa.enums.TipoParticipanteTrabalhoEnum;
import lombok.With;

@With
public record ParticipanteTrabalhoDTO(Long id,
                                      Long trabalhoId,
                                      String name,
                                      String email,
                                      String cpf,
                                      String phone,
                                      TipoParticipanteTrabalhoEnum tipoParticipante
                              ) {}

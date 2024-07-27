package com.rodrigolorandi.sistemamostrapoa.dto;

import lombok.With;

@With
public record OuvinteDTO(Long id,
                              String name,
                              String email,
                              String cpf,
                              String phone
                              ) {}

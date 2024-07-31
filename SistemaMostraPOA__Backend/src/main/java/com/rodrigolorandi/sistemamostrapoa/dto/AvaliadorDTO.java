package com.rodrigolorandi.sistemamostrapoa.dto;

import lombok.With;

@With
public record AvaliadorDTO(Long id,
                           String name,
                           String email,
                           String cpf,
                           String phone,
                           String institutionalAffiliation,
                           String lattes
) {
}

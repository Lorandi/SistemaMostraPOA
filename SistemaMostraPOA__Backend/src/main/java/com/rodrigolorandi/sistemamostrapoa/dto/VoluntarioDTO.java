package com.rodrigolorandi.sistemamostrapoa.dto;

import lombok.With;

@With
public record VoluntarioDTO(Long id,
                            String name,
                            String email,
                            String cpf,
                            String phone,
                            String course
) {
}

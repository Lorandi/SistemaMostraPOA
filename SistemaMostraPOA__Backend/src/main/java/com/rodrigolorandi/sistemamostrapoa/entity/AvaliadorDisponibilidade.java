package com.rodrigolorandi.sistemamostrapoa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@With
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "avaliador_disponibilidade")
public class AvaliadorDisponibilidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long avaliadorId;
    private Long disponibilidadeHorarioId;
}

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
@Table(name = "voluntario_disponibilidade")
public class VoluntarioDisponibilidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long voluntarioId;
    private Long disponibilidadeHorarioId;
}

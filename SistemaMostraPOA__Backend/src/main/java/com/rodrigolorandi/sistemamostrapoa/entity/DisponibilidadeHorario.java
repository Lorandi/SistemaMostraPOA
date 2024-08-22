package com.rodrigolorandi.sistemamostrapoa.entity;

import com.rodrigolorandi.sistemamostrapoa.enums.TurnoEnum;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@Builder
@With
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "disponibilidade_horario")
public class DisponibilidadeHorario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data;
    private String diaSemana;
    @Enumerated(EnumType.STRING)
    private TurnoEnum turno;
}

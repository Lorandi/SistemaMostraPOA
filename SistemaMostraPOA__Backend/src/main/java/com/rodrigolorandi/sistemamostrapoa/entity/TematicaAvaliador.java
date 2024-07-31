package com.rodrigolorandi.sistemamostrapoa.entity;

import com.rodrigolorandi.sistemamostrapoa.enums.TematicasEnum;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@With
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "tematica_avaliador")
public class TematicaAvaliador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long avaliadorId;
    @Enumerated(EnumType.STRING)
    private TematicasEnum tematica;
}

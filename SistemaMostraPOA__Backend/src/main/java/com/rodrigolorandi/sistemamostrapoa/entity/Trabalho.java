package com.rodrigolorandi.sistemamostrapoa.entity;

import com.rodrigolorandi.sistemamostrapoa.enums.ApresentacaoEnum;
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
@Table(name = "trabalho")
public class Trabalho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @Enumerated(EnumType.STRING)
    private ApresentacaoEnum apresentacao;
    @Enumerated(EnumType.STRING)
    private TematicasEnum tematica;
    private String observacao;
    private String linkResumo;
    private Boolean aceite;
}

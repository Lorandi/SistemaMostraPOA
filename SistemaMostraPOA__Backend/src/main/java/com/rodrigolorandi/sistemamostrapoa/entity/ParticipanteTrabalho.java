package com.rodrigolorandi.sistemamostrapoa.entity;


import com.rodrigolorandi.sistemamostrapoa.enums.TipoParticipanteTrabalhoEnum;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Builder
@With
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Table(name = "participante_trabalho")
public class ParticipanteTrabalho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long trabalhoId;
    private String name;
    private String email;
    private String cpf;
    private String phone;
    @Enumerated(EnumType.STRING)
    private TipoParticipanteTrabalhoEnum tipoParticipante;
}

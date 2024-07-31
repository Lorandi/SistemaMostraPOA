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
@Table(name = "ouvinte")
public class Ouvinte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String cpf;
    private String phone;
    private String accessibility;
}

package com.rodrigolorandi.sistemamostrapoa.repository;

import com.rodrigolorandi.sistemamostrapoa.entity.DisponibilidadeHorario;
import com.rodrigolorandi.sistemamostrapoa.enums.TurnoEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface DisponibilidadeHorarioRepository extends JpaRepository<DisponibilidadeHorario, Long> {
    Optional<DisponibilidadeHorario> findByDataAndTurno(LocalDate data, TurnoEnum turno);
}

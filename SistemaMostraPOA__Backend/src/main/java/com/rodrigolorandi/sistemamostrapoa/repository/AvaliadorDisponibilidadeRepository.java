package com.rodrigolorandi.sistemamostrapoa.repository;

import com.rodrigolorandi.sistemamostrapoa.entity.AvaliadorDisponibilidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvaliadorDisponibilidadeRepository extends JpaRepository<AvaliadorDisponibilidade, Long> {
    List<AvaliadorDisponibilidade> findByAvaliadorId(Long avaliadorId);

    void deleteAllByAvaliadorId(Long avaliadorId);
}

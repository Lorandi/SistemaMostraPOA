package com.rodrigolorandi.sistemamostrapoa.repository;

import com.rodrigolorandi.sistemamostrapoa.entity.VoluntarioDisponibilidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoluntarioDisponibilidadeRepository extends JpaRepository<VoluntarioDisponibilidade, Long> {
    List<VoluntarioDisponibilidade> findByVoluntarioId(Long voluntarioId);

    void deleteAllByVoluntarioId(Long voluntarioId);
}

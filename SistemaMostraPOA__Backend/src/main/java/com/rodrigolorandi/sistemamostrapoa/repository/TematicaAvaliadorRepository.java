package com.rodrigolorandi.sistemamostrapoa.repository;

import com.rodrigolorandi.sistemamostrapoa.entity.TematicaAvaliador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TematicaAvaliadorRepository extends JpaRepository<TematicaAvaliador, Long> {

    void deleteAllByAvaliadorId(Long avaliadorId);

    List<TematicaAvaliador> findAllByAvaliadorId(Long avaliadorId);
}

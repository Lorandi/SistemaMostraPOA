package com.rodrigolorandi.sistemamostrapoa.repository;

import com.rodrigolorandi.sistemamostrapoa.entity.ParticipanteTrabalho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipanteTrabalhoRepository extends JpaRepository<ParticipanteTrabalho, Long>,
        JpaSpecificationExecutor<ParticipanteTrabalho> {
}

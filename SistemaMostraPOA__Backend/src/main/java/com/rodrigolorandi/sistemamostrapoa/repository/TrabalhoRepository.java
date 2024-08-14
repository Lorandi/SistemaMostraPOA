package com.rodrigolorandi.sistemamostrapoa.repository;

import com.rodrigolorandi.sistemamostrapoa.entity.Trabalho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TrabalhoRepository extends JpaRepository<Trabalho, Long>, JpaSpecificationExecutor<Trabalho> {
}

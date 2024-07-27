package com.rodrigolorandi.sistemamostrapoa.repository;

import com.rodrigolorandi.sistemamostrapoa.entity.Ouvinte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface OuvinteRepository extends JpaRepository<Ouvinte, Long>, JpaSpecificationExecutor<Ouvinte> {
}

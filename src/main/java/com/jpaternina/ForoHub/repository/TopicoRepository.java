package com.jpaternina.ForoHub.repository;

import com.jpaternina.ForoHub.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Repositorio
public interface TopicoRepository extends JpaRepository<Topico, Long> {
}

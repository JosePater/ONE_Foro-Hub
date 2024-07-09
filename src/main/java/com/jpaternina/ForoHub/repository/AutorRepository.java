package com.jpaternina.ForoHub.repository;

import com.jpaternina.ForoHub.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Repositorio
public interface AutorRepository extends JpaRepository<Autor, Long> {

}


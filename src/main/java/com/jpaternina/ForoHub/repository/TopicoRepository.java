package com.jpaternina.ForoHub.repository;

import com.jpaternina.ForoHub.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository // Repositorio
public interface TopicoRepository extends JpaRepository<Topico, Long> {

    // Buscar tópicos por título y mensaje
    @Query(value = "SELECT * FROM Topicos t WHERE t.titulo = :titulo AND t.mensaje = :mensaje", nativeQuery = true)
    Optional<Topico> findByTituloAndMensaje(@Param("titulo") String titulo ,@Param("mensaje") String mensaje);
}

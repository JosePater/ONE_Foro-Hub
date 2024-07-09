package com.jpaternina.ForoHub.service;

import com.jpaternina.ForoHub.model.Autor;
import com.jpaternina.ForoHub.repository.AutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Servicio
@RequiredArgsConstructor // Crea el constructor
public class AutorService {

    // Inyección del repositorio
    private final AutorRepository autorRepo;

    // Obtener todos los autores registrados en la db
    public List<Autor> getAutores() {
        return autorRepo.findAll();
    }
}

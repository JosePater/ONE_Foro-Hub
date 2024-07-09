package com.jpaternina.ForoHub.service;

import com.jpaternina.ForoHub.model.Autor;
import com.jpaternina.ForoHub.model.Topico;
import com.jpaternina.ForoHub.repository.TopicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Servicios
@RequiredArgsConstructor // Crea el constructor
public class TopicoService {

    // Inyección del repositorio
    private final TopicoRepository topicoReposi;

    // Obtener todos los tópicos registrados en la db
    public List<Topico> getAllTopicos() {
        return topicoReposi.findAll();
    }


}

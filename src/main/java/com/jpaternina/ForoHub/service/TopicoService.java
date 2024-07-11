package com.jpaternina.ForoHub.service;

import com.jpaternina.ForoHub.model.Autor;
import com.jpaternina.ForoHub.model.Topico;
import com.jpaternina.ForoHub.repository.AutorRepository;
import com.jpaternina.ForoHub.repository.TopicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service // Servicios
@RequiredArgsConstructor // Crea el constructor
public class TopicoService {

    // Inyección del repositorio
    private final TopicoRepository topicoReposi;
    private final AutorRepository autorReposi;

    // Obtener horario colombiano
    public Date getDate() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("America/Bogota"));
        return Date.from(zonedDateTime.toInstant());
    }

    // Obtener todos los tópicos registrados en la db
    public List<Topico> getAllTopicos() {
        return topicoReposi.findAll();
    }

    // Agregar nuevo tópico
    public void addTopico(Topico newTopico) {
        Optional<Autor> autorEncontrado = autorReposi.findById(newTopico.getAutorId());

        // Si el autor está registrado en la db
        if (autorEncontrado.isPresent()) {
            newTopico.setFechaCreacion(getDate());
            System.out.println("TopicoService: " + newTopico);
            topicoReposi.save(newTopico);

        } else {
            System.out.println("Autor no registrado en la base de datos");
        }
    }

    //Obtener tópico por Id
    public Optional<Topico> getTopicoById(Long id) {
        return topicoReposi.findById(id);
    }

    // Actualizar tópico
    public void updateTopico(Topico newTopico, Long id) {
        Optional<Topico> topico = topicoReposi.findById(id);
        // Si el tópico existe
        if (topico.isPresent()) {
            addTopico(newTopico); // Editar tópico
        } else {
            System.out.println("Tópico no existe");
        }
    }

    // Eliminar tópico
    public void deleteTopico(Long id) {
        Optional<Topico> topico = topicoReposi.findById(id);
        // Si exite el tópico
        if (topico.isPresent()) {
            topicoReposi.deleteById(id);
            System.out.println("Tópico #"+id+" eliminado");
        } else {
            System.out.println("Tópico no existe!");
        }
    }

}

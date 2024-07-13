package com.jpaternina.ForoHub.service;

import com.jpaternina.ForoHub.model.Autor;
import com.jpaternina.ForoHub.model.Topico;
import com.jpaternina.ForoHub.repository.AutorRepository;
import com.jpaternina.ForoHub.repository.TopicoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Optional<List<Topico>>> getAllTopicos() {
        Optional<List<Topico>> response = Optional.of(topicoReposi.findAll());
        if (response.get().isEmpty()) {
            System.out.println("No hay ningún tópico creado!");
            return ResponseEntity.noContent().build(); // Sin tópicos (204)
        }
        return ResponseEntity.ok(response); // OK (200)
    }

    // Agregar nuevo tópico o editar
    public ResponseEntity<Topico> addTopico(Topico newTopico) {
        Optional<Autor> autorEncontrado = autorReposi.findById(newTopico.getAutorId());

        // Si el autor está registrado en la db
        if (autorEncontrado.isPresent()) {
            newTopico.setFechaCreacion(getDate()); // Set fecha actual

            // Verificación si existe un tópico (db) que tenga el mismo título y mensaje que el que se va a guardar
            Optional<Topico> result = topicoReposi.findByTituloAndMensaje(newTopico.getTitulo(), newTopico.getMensaje());

            if (result.isPresent()) {
                // Si se desea editar un tópico
                if (newTopico.getId() == result.get().getId()) {
                    topicoReposi.save(newTopico); // Guardar tópico
                    System.out.println("Tópico #"+ newTopico.getId()+" editado!!!");
                    return ResponseEntity.ok(newTopico); // OK (200)
                } else {
                    System.out.println("Tópico ya existe (título y mensaje)");
                    return ResponseEntity.status(HttpStatus.CONFLICT).build(); // Conflicto (409)
                }
            } else {
                System.out.println("Nuevo tópico guardado: " + newTopico);
                topicoReposi.save(newTopico); // Guardar tópico
                return ResponseEntity.ok(newTopico); // OK (200)
            }

        } else {
            System.out.println("Autor no registrado en la base de datos");
            return ResponseEntity.notFound().build(); // NO encontrado (404)
        }
    }

    //Obtener tópico por Id
    public ResponseEntity getTopicoById(Long id) {
        Optional<Topico> response = topicoReposi.findById(id);
        if (response.isPresent()) {
            return ResponseEntity.ok(response); // OK (200)
        }
        System.out.println("Tópico no existe!");
        return ResponseEntity.notFound().build(); // Tópico no encontradod (404)
    }

    // Actualizar tópico
    public ResponseEntity<Topico> updateTopico(Topico newTopico, Long id) {
        Optional<Topico> topico = topicoReposi.findById(id);
        // Si el tópico existe
        if (topico.isPresent()) {
            return addTopico(newTopico); // Editar tópico
        } else {
            System.out.println("Tópico no existe");
            return ResponseEntity.notFound().build(); // Tópico no encontrado (404)
        }
    }

    // Eliminar tópico
    public ResponseEntity deleteTopico(Long id) {
        Optional<Topico> topico = topicoReposi.findById(id);
        // Si exite el tópico
        if (topico.isPresent()) {
            topicoReposi.deleteById(id);
            System.out.println("Tópico #"+id+" eliminado");
            return ResponseEntity.noContent().build(); // Éxito sin retornar nada (204)
        } else {
            System.out.println("Tópico no existe!");
            return ResponseEntity.notFound().build(); // Tópico No encontrado (404)
        }
    }

}

package com.jpaternina.ForoHub.controller.topico;

import com.jpaternina.ForoHub.model.Topico;
import com.jpaternina.ForoHub.service.TopicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller // Controlador
@RestController
@RequiredArgsConstructor
@RequestMapping("/topicos")
public class TopicoController {

    // Inyección del servicio
    private final TopicoService topicoServi;

    // Obtener todos los tópicos
    @GetMapping()
    private ResponseEntity<Optional<List<Topico>>> getAllTopicos() {
        return topicoServi.getAllTopicos();
    }

    // Agregar nuevo tópico
    @PostMapping()
    private ResponseEntity addTopico(@RequestBody Topico newTopico) {
        return topicoServi.addTopico(newTopico);
    }

    // Obtener tópico por id
    @GetMapping("/{id}")
    private ResponseEntity getTopicoById(@PathVariable Long id) {
        return topicoServi.getTopicoById(id);
    }

    // Editar tópico
    @PutMapping("/{id}")
    private ResponseEntity updateTopic(@RequestBody Topico updatedTopico, @PathVariable Long id) {
        updatedTopico.setId(id);
         return topicoServi.updateTopico(updatedTopico, id);
    }

    // Eliminar tópico
    @DeleteMapping("/{id}")
    private ResponseEntity deleteTopico(@PathVariable Long id) {
        return topicoServi.deleteTopico(id);
    }
}

package com.jpaternina.ForoHub.controller.topico;

import com.jpaternina.ForoHub.model.Topico;
import com.jpaternina.ForoHub.service.TopicoService;
import lombok.RequiredArgsConstructor;
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
    private List<Topico> getAllTopicos() {
        return topicoServi.getAllTopicos();
    }

    // Agregar nuevo tópico
    @PostMapping()
    private void addTopico(@RequestBody Topico newTopico) {
        topicoServi.addTopico(newTopico);
    }

    // Obtener tópico por id
    @GetMapping("/{id}")
    private Optional<Topico> getTopicoById(@PathVariable Long id) {
        return topicoServi.getTopicoById(id);
    }

    // Editar tópico
    @PutMapping("/{id}")
    private void updateTopic(@RequestBody Topico updatedTopico, @PathVariable Long id) {
        updatedTopico.setId(id);
        topicoServi.updateTopico(updatedTopico, id);
    }

    // Eliminar tópico
    @DeleteMapping("/{id}")
    private void deleteTopico(@PathVariable Long id) {
        topicoServi.deleteTopico(id);
    }
}

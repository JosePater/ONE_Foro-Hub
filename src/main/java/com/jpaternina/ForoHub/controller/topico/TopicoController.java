package com.jpaternina.ForoHub.controller.topico;

import com.jpaternina.ForoHub.model.Topico;
import com.jpaternina.ForoHub.service.TopicoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller // Controlador
@RestController
@RequestMapping
@RequiredArgsConstructor
public class TopicoController {

    // Inyección del servicio
    private final TopicoService topicoServi;

    // Obtener todos los tópicos
    @GetMapping("/topicos")
    private List<Topico> getAllTopicos() {
        return topicoServi.getAllTopicos();
    }
}

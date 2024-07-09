package com.jpaternina.ForoHub.controller.autor;

import com.jpaternina.ForoHub.model.Autor;
import com.jpaternina.ForoHub.service.AutorService;
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
public class AutorController {

    // Inyección del servicio
    private final AutorService autorServi;

    // Página de inicio
    @GetMapping
    private String inicio() {
        return "Bienvenido a la página de inicio!";
    }

    // Obtener todos los autores
    @GetMapping("/autores")
    private List<Autor> getAllAutores() {
        return autorServi.getAutores();
    }

}

package com.jpaternina.ForoHub.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity               // Entidad
@Data                // Lombok
@AllArgsConstructor  // Genera el constructor con todos los parámetros
@NoArgsConstructor   // Genera el constructor sin parámetros
public class Autor {
    @Id
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

}
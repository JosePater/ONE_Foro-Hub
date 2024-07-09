package com.jpaternina.ForoHub.controller.autor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
/*    @OneToMany(fetch = FetchType.LAZY, mappedBy = "autor", cascade = CascadeType.ALL)
    List<Topic> topics;*/
}
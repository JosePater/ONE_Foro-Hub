package com.jpaternina.ForoHub.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity // Entidad
@Data                    // Lombok
@AllArgsConstructor      // Genera el constructor con todos los parámetros
@NoArgsConstructor       // Genera el constructor sin parámetros
@Table(name = "Topicos") // Renombrar tabla
public class Topico {

    @Id // Llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank // No permite texto vacío ("")
    @Column(nullable = false)
    private String titulo;

    @NotBlank // No permite texto vacío ("")
    @Column(nullable = false)
    private String mensaje;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @Column(name = "autor_id", nullable = false)
    private Long autorId;
}

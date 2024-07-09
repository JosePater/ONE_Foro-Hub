package com.jpaternina.ForoHub.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
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

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String mensaje;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    // Llave foránea
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "autor_id", nullable = false)
    @JsonBackReference // Se serializa para evitar una recursión infinita
    private Autor autor;
}

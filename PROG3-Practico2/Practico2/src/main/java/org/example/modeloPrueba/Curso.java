package org.example.modeloPrueba;

import jakarta.persistence.*;

@Entity
@Table(name = "cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    public Curso() {}
    public Curso(String nombre) { this.nombre = nombre; }
}

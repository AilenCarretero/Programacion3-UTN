package org.example.modeloPrueba;

import jakarta.persistence.*;

@Entity
@Table(name = "materias")
public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    public Materia() {}
    public Materia(String nombre) { this.nombre = nombre; }
}

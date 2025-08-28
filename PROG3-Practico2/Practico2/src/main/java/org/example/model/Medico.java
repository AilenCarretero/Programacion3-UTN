package org.example.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

@Entity
@Table(name = "medico")
@PrimaryKeyJoinColumn(name = "idMedico")
public class Medico extends Persona {
    private int matricula;
    private long celular;

    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL)
    private List<Turno> turnos = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "medico_especialidad",
            joinColumns = @JoinColumn(name = "medico_id"),
            inverseJoinColumns = @JoinColumn(name = "especialidad_id")
    )
    private List<Especialidad> especialidades = new ArrayList<>();
}

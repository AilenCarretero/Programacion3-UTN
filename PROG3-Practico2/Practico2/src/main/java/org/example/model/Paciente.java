package org.example.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

@Entity
@Table(name = "paciente")
@PrimaryKeyJoinColumn(name = "idPaciente")
public class Paciente extends Persona {
    private int nroSocio;

    @OneToOne(mappedBy = "paciente", cascade = CascadeType.ALL)
    private HistoriaClinica historiaClinica;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private List<Turno> turnos = new ArrayList<>();
}

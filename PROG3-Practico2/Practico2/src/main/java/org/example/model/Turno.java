package org.example.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter

@Entity
@Table(name = "turno")
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTurno;

    private Date fecha;
    private int hora;
    private int minutos;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
}

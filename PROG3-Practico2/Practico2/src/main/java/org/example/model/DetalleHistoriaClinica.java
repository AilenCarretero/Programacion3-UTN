package org.example.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter

@Entity
@Table(name = "detalle_historia_clinica")
public class DetalleHistoriaClinica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetalleHC;

    private Date fechaAtencion;
    private String sintomas;
    private String diagnostico;
    private String observaciones;

    @ManyToOne
    @JoinColumn(name = "historia_clinica_id")
    private HistoriaClinica historiaClinica;
}

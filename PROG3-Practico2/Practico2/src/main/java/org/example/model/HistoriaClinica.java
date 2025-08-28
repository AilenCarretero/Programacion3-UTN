package org.example.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter

@Entity
@Table(name = "historia_clinica")
public class HistoriaClinica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHistoriaClinica;

    private int numero;
    private Date fechaAlta;

    @OneToOne
    private Paciente paciente;

    @OneToMany(mappedBy = "historiaClinica", cascade = CascadeType.ALL)
    private List<DetalleHistoriaClinica> detalleHistoriaClinicas = new ArrayList<>();
}

package org.example.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter

@Entity
@Table(name = "empleado")
@PrimaryKeyJoinColumn(name = "idEmpleado")
public class Empleado extends Persona {
    private int nroLegajo;
    private double sueldo;
}

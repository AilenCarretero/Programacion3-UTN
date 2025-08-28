package PartB;

import java.util.ArrayList;
import java.util.List;

public class Empleado {
    private String nombre;
    private long cuit;
    private String domicilio;
    private String email;

    private RegimenHorario regimenHorario;
    private List<Asistencia> asistencias = new ArrayList<>();
    private List<Tardanza> tardanzas = new ArrayList<>();

    public List<Asistencia> getAsistencias() {
        return asistencias;
    }

    public RegimenHorario getRegimenHorario() {
        return regimenHorario;
    }
}

package PartC;

import java.util.ArrayList;
import java.util.List;

public class Persona {
    private char nombre;
    private char tipoDocumento;
    private long nroDocumento;
    private int telefono;
    private char email;
    private char celular;

    private Sector sector;
    private List<Actividad> actividades = new ArrayList<>();

    // PUNTO 1: Retornar el total de puntos asignados de las actividades de la persona
    public double totalPuntosAsignados() {
        double total = 0;
        for (Actividad actividad : actividades) {
            if (actividad != null && actividad.getTipoActividad() != null) {
                total += actividad.getTipoActividad().getPuntos();
            }
        }
        return total;
    }

    // PUNTO 2: Retornar el total de puntos asignados a una actividad realizada por una persona
    public double totalPuntosAsignados(int codigo) {
        double total = 0;
        for (Actividad actividad : actividades) {
            if (actividad != null && actividad.getTipoActividad() != null
                && actividad.getTipoActividad().getCodigo() == codigo) {
                total += actividad.getTipoActividad().getPuntos();
            }
        }
        return total;
    }

    // PUNTO 3: Retornar el total de puntos asignados a una actividad realizada por una persona en un periodo determinado
    public double totalPuntosAsignados(int codigo, int anio) {
        double total = 0;
        for (Actividad actividad : actividades) {
            if (actividad != null && actividad.getTipoActividad() != null
                && actividad.getTipoActividad().getCodigo() == codigo
                && actividad.getFechaInicio().getYear() + 1900 == anio) {
                total += actividad.getTipoActividad().getPuntos();
            }
        }
        return total;
    }

}

package PartC;

import java.util.ArrayList;
import java.util.List;

public class TipoActividad {
    private int codigo;
    private char denominacion;
    private double puntos;

    private List<Actividad> actividades = new ArrayList<>();

    public double getPuntos() {
        return puntos;
    }

    public int getCodigo() {
        return codigo;
    }
}

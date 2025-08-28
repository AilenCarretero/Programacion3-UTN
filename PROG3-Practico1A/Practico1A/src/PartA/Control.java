package PartA;

import java.util.ArrayList;
import java.util.List;

public class Control {
    private int id;
    private String denominacion;
    private Boolean esObligatorio;

    private EstadoControl estadoControl;
    private List<Expediente> expedientes = new ArrayList<>();

    public Control(EstadoControl estadoControl, int id, String denominacion, Boolean esObligatorio) {
        this.estadoControl = estadoControl;
        this.id = id;
        this.denominacion = denominacion;
        this.esObligatorio = esObligatorio;
    }

    public boolean getEsObligatorio() {
        return esObligatorio;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public EstadoControl getEstadoControl() {
        return estadoControl;
    }
}

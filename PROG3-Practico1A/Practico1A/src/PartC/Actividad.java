package PartC;

import java.util.Date;

public class Actividad {
    private Date fechaInicio;
    private Date fechaFin;
    private String nombre;
    private String descripcion;

    private TipoActividad tipoActividad;
    private Persona persona;

    public TipoActividad getTipoActividad() {
        return tipoActividad;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }
}

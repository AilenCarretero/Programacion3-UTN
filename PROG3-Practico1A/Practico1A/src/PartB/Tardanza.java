package PartB;

import java.util.Date;
import java.util.List;

public class Tardanza {
    private long id;
    private String tipo;
    private Date fecha;
    private int hora;
    private int minuto;

    private Empleado empleado;

    public void setId(long id) {
        this.id = id;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}

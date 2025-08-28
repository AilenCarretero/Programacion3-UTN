package PartA;

import java.util.ArrayList;
import java.util.List;

public class EstadoControl {
    private long id;
    private Boolean aprobado;

    private List<Control> controles = new ArrayList<>();

    public EstadoControl(long id, Boolean aprobado, List<Control> controles) {
        this.id = id;
        this.aprobado = aprobado;
        this.controles = controles;
    }

    public EstadoControl(long id, boolean aprobado) {
        this.id = id;
        this.aprobado = aprobado;
    }
}

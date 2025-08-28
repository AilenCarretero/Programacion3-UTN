package PartB;

import java.util.ArrayList;
import java.util.List;

public class Articulo {
    private int codigo;
    private String denominacion;
    private double precio;
    private String unidadMedida;

    private List<DetalleFactura> detallesFactura = new ArrayList<>();
}

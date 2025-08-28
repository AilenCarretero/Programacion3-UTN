package PartB;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Factura {
    private String letra;
    private int numero;
    private double recargo;
    private String tipoPago;
    private double totalItems;
    private double totalFinal;
    private Date fecha;

    private Cliente cliente;
    private List<DetalleFactura> detallesFactura = new ArrayList<>();
}

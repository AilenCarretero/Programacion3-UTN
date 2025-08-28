package PartD;

import java.util.ArrayList;
import java.util.List;

public class Vivienda {
    private long id;
    private String calle;
    private int numeroCalle;
    private Double superficieTerreno;

    private Barrio barrio;
    private List<Habitacion> habitaciones = new ArrayList<>();

    // PUNTO 2: Retornar el total de metros cuadrados de la vivienda teniendo en cuenta todas las habitaciones. Y validar que el valor obtenido no sea mayor que la superficie del terreno.
    public double getMetrosCuadradosCubiertos() {
        double totalMetrosCuadrados = 0.0;
        for (Habitacion habitacion : habitaciones) {
            totalMetrosCuadrados += habitacion.getMetrosCuadrados();
        }
        if (totalMetrosCuadrados > superficieTerreno) {
            throw new IllegalArgumentException("La superficie cubierta no puede ser mayor a la superficie del terreno");
        }
        return totalMetrosCuadrados;
    }

    public Double getSuperficieTerreno() {
        return superficieTerreno;
    }
}

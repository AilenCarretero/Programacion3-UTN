package PartD;

import java.util.ArrayList;
import java.util.List;

public class Barrio {
    private long id;
    private String nombre;
    private String empresaConstructora;

    private List<Vivienda> viviendas = new ArrayList<>();

    // PUNTO 1: Retornar el total de metros de terreno del barrio teniendo en cuenta todas las viviendas.
    public double getSuperficieTotalTerreno() {
        double totalSuperficie = 0.0;
        for (Vivienda vivienda : viviendas) {
            totalSuperficie += vivienda.getSuperficieTerreno();
        }
        return totalSuperficie;
    }

    // PUNTO 3: Retornar el total de metros cuadrados cubiertos del barrio teniendo en cuenta todas las viviendas.
    public double getSuperficieTotalCubierta() {
        double totalSuperficieCubierta = 0.0;
        for (Vivienda vivienda : viviendas) {
            totalSuperficieCubierta += vivienda.getMetrosCuadradosCubiertos();
        }
        return totalSuperficieCubierta;
    }
}

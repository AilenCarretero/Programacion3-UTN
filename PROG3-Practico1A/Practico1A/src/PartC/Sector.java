package PartC;

import java.util.ArrayList;
import java.util.List;

public class Sector {
    private int numero;
    private String denominacion;
    private String tipo;

    private Sector sector;
    private List<Sector> subsectores = new ArrayList<>();
    private List<Persona> personas = new ArrayList<>();

    // PUNTO 4: Retornar la totalidad de subsectores de un sector
    public List<Sector> obtenerTotalSubsectores() {
        List<Sector> totalSubsectores = new ArrayList<>(subsectores);
        for (Sector subsector : subsectores) {
            totalSubsectores.addAll(subsector.obtenerTotalSubsectores());
        }
        return totalSubsectores;
    }
}

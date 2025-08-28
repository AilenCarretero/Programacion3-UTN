package PartA;

import java.util.ArrayList;
import java.util.List;

public class Expediente {
    private int id;
    private String letra;
    private int numero;
    private String descripcion;
    private String tipo;
    private String ambito;

    private Expediente expediente;
    List<Expediente> subexpedientes = new ArrayList<>();
    List<Control> controles = new ArrayList<>();

    public Expediente(int id, String letra, int numero, String descripcion, String tipo, String ambito) {
        this.id = id;
        this.letra = letra;
        this.numero = numero;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.ambito = ambito;
    }

    // PUNTO 1: Retorno de la carátula del expediente
    public String getCaratulaExpediente() {
        return "Expediente " + numero + " - " + letra + " - " + descripcion;
    }

    // PUNTO 2: Retorno de los controles obligatorios
    public String getControlesObligatorios() {
        StringBuilder sb = new StringBuilder();
        for (Control control : controles) {
            if (control.getEsObligatorio()) {
                sb.append(control.getDenominacion()).append("\n");
            }
        }
        return sb.toString();
    }

    // PUNTO 3: Verificación del estado de los controles obligatorios
    public boolean getEstadoControles() {
        for (Control control : controles) {
            if (control.getEsObligatorio() && control.getEstadoControl() == null) {
                return false;
            }
        }
        return true;
    }

    // PUNTO 4: Retorno de lista de subexpedientes
    public List<Expediente> listaExpedientes() {
        List<Expediente> lista = new ArrayList<>();
        expedientesRecursivo(this, lista);
        return lista;
    }

    private void expedientesRecursivo(Expediente expediente, List<Expediente> lista) {
        if (expediente != null) {
            lista.add(expediente);
            for (Expediente e : expediente.subexpedientes) {
                expedientesRecursivo(e, lista);
            }
        }
    }
}

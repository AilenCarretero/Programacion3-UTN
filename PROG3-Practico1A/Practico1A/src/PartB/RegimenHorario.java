package PartB;

public class RegimenHorario {
    private long id;
    private int horaIngreso;
    private int minutoIngreso;
    private int horaEgreso;
    private int minutoEgreso;

    private Empleado empleado;

    public int getHora() {
        return horaIngreso;

    }

    public int getMinuto() {
        return minutoIngreso;
    }
}

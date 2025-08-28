package PartB;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Asistencia {
    private long id;
    private String tipo;
    private Date fecha;
    private int hora;
    private int minuto;

    private Empleado empleado;

    // PUNTO 2: Retornar la lista de asistencias de un empleado en un mes y año determinados
    public List<Asistencia> getAsistenciaXMesXAnio(int mes, int anio) {
        List<Asistencia> asistenciasDelMes = new ArrayList<>();
        for (Asistencia asistencia : empleado.getAsistencias()) {
            if (asistencia.fecha.getMonth() == mes && asistencia.fecha.getYear() == anio) {
                asistenciasDelMes.add(asistencia);
            }
        }
        return asistenciasDelMes;
    }

    // PUNTO 3: Retornar la lista de tardanzas de un empleado en un mes y año determinados
    public List <Tardanza> getDiasConTardanza(int mes, int anio) {
        List<Tardanza> tardanzasDelMes = new ArrayList<>();
        List<Asistencia> asistenciasDelMes = getAsistenciaXMesXAnio(mes, anio);

        for (Asistencia asistencia : asistenciasDelMes) {
            if (asistencia.hora > empleado.getRegimenHorario().getHora() ||
                (asistencia.hora == empleado.getRegimenHorario().getHora() && asistencia.minuto > empleado.getRegimenHorario().getMinuto() + 15)) {

                Tardanza tardanza = new Tardanza();
                tardanza.setId(asistencia.id);
                tardanza.setTipo(asistencia.tipo);
                tardanza.setFecha(asistencia.fecha);
                tardanza.setHora(asistencia.hora);
                tardanza.setMinuto(asistencia.minuto);
                tardanza.setEmpleado(empleado);

                tardanzasDelMes.add(tardanza);
            }
        }
        return tardanzasDelMes;
    }
}

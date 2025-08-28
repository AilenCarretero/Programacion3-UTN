package PartA;

public class Main {
    public static void main(String[] args) {
        EstadoControl estado1 = new EstadoControl(10, true);
        EstadoControl estado2 = new EstadoControl(20, false);
        EstadoControl estado3 = new EstadoControl(30, true);

        Control control1 = new Control(estado1, 101, "Control Técnico", true);
        Control control2 = new Control(estado2, 102, "Control Técnico", true);
        Control control3 = new Control(estado3, 103, "Control Optativo", false);

        Expediente expediente1 = new Expediente(1, "A", 1001, "Licencia Comercial", "Licencia", "Municipal");
        Expediente expediente2 = new Expediente(2, "B", 1002, "Habilitación Sanitaria", "Habilitación", "Provincial");
        Expediente expediente3 = new Expediente(3,"C", 1003, "Poda de Árboles", "Mantenimiento", "Provincial");

        expediente1.controles.add(control1);
        expediente2.controles.add(control2);
        expediente3.controles.add(control3);

        expediente1.subexpedientes.add(expediente2);

        System.out.println("Carátula expediente 1: " + expediente1.getCaratulaExpediente());
        System.out.println("Controles obligatorios expediente 1: " + expediente1.getControlesObligatorios());
        System.out.println("Estado controles expediente 1: " + expediente1.getEstadoControles());

        System.out.println("\nLista recursiva de expedientes desde expediente 1:");
        for (Expediente e : expediente1.listaExpedientes()) {
            System.out.println(" - " + e.getCaratulaExpediente());
        }

        System.out.println("Carátula expediente 2: " + expediente2.getCaratulaExpediente());
        System.out.println("Controles obligatorios expediente 2: " + expediente2.getControlesObligatorios());
        System.out.println("Estado controles expediente 2: " + expediente2.getEstadoControles());

        System.out.println("\nLista recursiva de expedientes desde expediente 2:");
        for (Expediente e : expediente2.listaExpedientes()) {
            System.out.println(" - " + e.getCaratulaExpediente());
        }
    }
}

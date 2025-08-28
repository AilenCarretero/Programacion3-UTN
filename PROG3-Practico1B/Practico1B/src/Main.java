import PartA.Factura;
import PartA.CalculoFactura;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Factura factura = new Factura();

        // DATOS DE LA FACTURA
        System.out.print("Ingrese la fecha de la factura (dd/mm/yyyy): ");
        factura.setFecha(sc.nextLine());

        System.out.print("Ingrese el número de factura: ");
        factura.setNroFactura(Long.parseLong(sc.nextLine()));

        System.out.print("Ingrese la razón social del cliente: ");
        factura.setRazonSocial(sc.nextLine());

        System.out.print("Ingrese el CUIT del cliente: ");
        factura.setCuitCliente(Long.parseLong(sc.nextLine()));

        // Tipo de pago validado
        while (true) {
            System.out.print("Ingrese el tipo de pago (C, TC, TD): ");
            String tipoPago = sc.nextLine().toUpperCase();
            if (tipoPago.equals("C") || tipoPago.equals("TC") || tipoPago.equals("TD")) {
                factura.setTipoPago(tipoPago);
                break;
            }
            System.out.println("Tipo de pago inválido.");
        }

        // CANTIDAD DE ARTÍCULOS
        int cantidadArticulos;
        do {
            System.out.print("Ingrese la cantidad de artículos a facturar: ");
            cantidadArticulos = Integer.parseInt(sc.nextLine());
            if (cantidadArticulos <= 0) {
                System.out.println("Debe ser mayor a cero.");
            }
        } while (cantidadArticulos <= 0);

        // Matriz de ítems
        String[][] itemsFactura = new String[cantidadArticulos][5];
        factura.setItemsFactura(itemsFactura);

        // CARGA DE ARTÍCULOS
        double totalItems = 0;
        System.out.println("\n--- Artículos a Facturar ---");

        for (int i = 0; i < cantidadArticulos; i++) {
            String[] articuloEncontrado = null;

            // Buscar artículo
            while (articuloEncontrado == null) {
                System.out.print("Ingrese el código del artículo " + (i + 1) + ": ");
                String codigo = sc.nextLine();
                articuloEncontrado = CalculoFactura.buscarArticulo(codigo);
                if (articuloEncontrado == null) {
                    System.out.println("Código incorrecto. Intente nuevamente.");
                }
            }

            // Cantidad según unidad o kilo
            double cantidad;
            while (true) {
                System.out.print("Ingrese la cantidad a facturar (" +
                        (articuloEncontrado[3].equals("U") ? "entero" : "decimal") + "): ");
                String entrada = sc.nextLine();
                try {
                    if (articuloEncontrado[3].equals("U")) {
                        cantidad = Integer.parseInt(entrada);
                    } else {
                        cantidad = Double.parseDouble(entrada);
                    }
                    if (cantidad > 0) break;
                    System.out.println("La cantidad debe ser mayor a cero.");
                } catch (NumberFormatException e) {
                    System.out.println("Formato inválido. Intente nuevamente.");
                }
            }

            // Calcular subtotal
            double precio = Double.parseDouble(articuloEncontrado[2]);
            double subtotal = precio * cantidad;
            totalItems += subtotal;

            // Guardar en itemsFactura
            itemsFactura[i][0] = articuloEncontrado[0]; // Código
            itemsFactura[i][1] = articuloEncontrado[1]; // Denominación
            itemsFactura[i][2] = String.valueOf(precio); // Precio unitario
            itemsFactura[i][3] = String.valueOf(cantidad); // Cantidad
            itemsFactura[i][4] = String.valueOf(subtotal); // Subtotal
        }

        factura.setMontoTotalItems(totalItems);

        // Calcular recargo según tipo de pago
        double recargo = 0;
        switch (factura.getTipoPago()) {
            case "TC": // Tarjeta crédito
                recargo = totalItems * 0.10;
                break;
            case "TD": // Tarjeta débito
                recargo = totalItems * 0.05;
                break;
            case "C": // Contado
                recargo = 0;
                break;
        }
        factura.setRecargo(recargo);

        // Calcular monto final
        double montoFinal = totalItems + recargo;
        factura.setMontoFinal(montoFinal);

        // Mostrar ticket
        System.out.println("\n===== TICKET A PAGAR =====");
        System.out.println("Cliente: " + factura.getRazonSocial());
        System.out.println("Fecha: " + factura.getFecha());
        System.out.println("Número: " + factura.getNroFactura());
        System.out.println("Tipo Pago: " + factura.getTipoPago());
        System.out.println("\nCódigo\tDenominación\tPrecio\tCantidad\tSubtotal");

        for (String[] item : factura.getItemsFactura()) {
            System.out.printf("%s\t%-15s\t%s\t%s\t\t%s%n",
                    item[0], item[1], item[2], item[3], item[4]);
        }

        System.out.println("\nTotal Ítems: " + factura.getMontoTotalItems());
        System.out.println("Recargo: " + factura.getRecargo());
        System.out.println("Total Final: " + factura.getMontoFinal());
    }
}


package managers;

import funciones.FuncionApp;
import org.example.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainConsultasJPQL {

    public static void main(String[] args) {
        //REPOSITORIO-> https://github.com/gerardomagni/jpqlquerys.git

        //buscarFacturas();
        //buscarFacturasActivas();
        //buscarFacturasXNroComprobante();
        //buscarFacturasXRangoFechas();
        //buscarFacturaXPtoVentaXNroComprobante();
        //buscarFacturasXCliente();
        //buscarFacturasXCuitCliente();
        //buscarFacturasXArticulo();
        //mostrarMaximoNroFactura();
        //buscarClientesXIds();
        //buscarClientesXRazonSocialParcial();

        // Trabajo Práctico n°3
        listarTodosLosClientes();
        listarFacturasUltimoMes();
        obtenerClienteConMasFacturas();
        listarArticulosMasVendidos();
        listarFacturasUltimosTresMesesCliente(7l);
        calcularMontoTotalFacturadoCliente(7l);
        listarArticulosDeFactura(1l);
        obtenerArticuloMasCaroDeFactura(1l);
        contarCantidadTotalFactura();
        listarFacturasConTotalMayorA(50000.0);
         listarFacturasConArticuloPorNombre("Laptop");
        listarArticulosPorCodigoParcial("A00");
        listarArticulosConPrecioMayorAlPromedio();
        buscarClientesConMas10Facturas();


    }


    public static void buscarFacturas() {
        FacturaManager mFactura = new FacturaManager(true);
        try {
            List<Factura> facturas = mFactura.getFacturas();
            mostrarFacturas(facturas);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            mFactura.cerrarEntityManager();
        }
    }

    public static void buscarFacturasActivas() {
        FacturaManager mFactura = new FacturaManager(true);
        try {
            List<Factura> facturas = mFactura.getFacturasActivas();
            mostrarFacturas(facturas);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            mFactura.cerrarEntityManager();
        }
    }

    public static void buscarFacturasXNroComprobante() {
        FacturaManager mFactura = new FacturaManager(true);
        try {
            List<Factura> facturas = mFactura.getFacturasXNroComprobante(796910l);
            mostrarFacturas(facturas);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            mFactura.cerrarEntityManager();
        }
    }

    public static void buscarFacturasXRangoFechas() {
        FacturaManager mFactura = new FacturaManager(true);
        try {
            LocalDate fechaActual = LocalDate.now();
            LocalDate fechaInicio = FuncionApp.restarSeisMeses(fechaActual);
            List<Factura> facturas = mFactura.buscarFacturasXRangoFechas(fechaInicio, fechaActual);
            mostrarFacturas(facturas);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            mFactura.cerrarEntityManager();
        }
    }

    public static void buscarFacturaXPtoVentaXNroComprobante() {
        FacturaManager mFactura = new FacturaManager(true);
        try {
            Factura factura = mFactura.getFacturaXPtoVentaXNroComprobante(2024, 796910l);
            mostrarFactura(factura);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            mFactura.cerrarEntityManager();
        }
    }

    public static void buscarFacturasXCliente() {
        FacturaManager mFactura = new FacturaManager(true);
        try {
            List<Factura> facturas = mFactura.getFacturasXCliente(7l);
            mostrarFacturas(facturas);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            mFactura.cerrarEntityManager();
        }
    }

    public static void buscarFacturasXCuitCliente() {
        FacturaManager mFactura = new FacturaManager(true);
        try {
            List<Factura> facturas = mFactura.getFacturasXCuitCliente("27236068981");
            mostrarFacturas(facturas);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            mFactura.cerrarEntityManager();
        }
    }

    public static void buscarFacturasXArticulo() {
        FacturaManager mFactura = new FacturaManager(true);
        try {
            List<Factura> facturas = mFactura.getFacturasXArticulo(6l);
            mostrarFacturas(facturas);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            mFactura.cerrarEntityManager();
        }
    }

    public static void mostrarMaximoNroFactura() {
        FacturaManager mFactura = new FacturaManager(true);
        try {
            Long nroCompMax = mFactura.getMaxNroComprobanteFactura();
            System.out.println("N° " + nroCompMax);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            mFactura.cerrarEntityManager();
        }
    }

    public static void buscarClientesXIds() {
        ClienteManager mCliente = new ClienteManager(true);
        try {
            List<Long> idsClientes = new ArrayList<>();
            idsClientes.add(1l);
            idsClientes.add(2l);
            List<Cliente> clientes = mCliente.getClientesXIds(idsClientes);
            for (Cliente cli : clientes) {
                System.out.println("Id: " + cli.getId());
                System.out.println("CUIT: " + cli.getCuit());
                System.out.println("Razon Social: " + cli.getRazonSocial());
                System.out.println("-----------------");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            mCliente.cerrarEntityManager();
        }
    }

    public static void buscarClientesXRazonSocialParcial() {
        ClienteManager mCliente = new ClienteManager(true);
        try {
            List<Long> idsClientes = new ArrayList<>();
            idsClientes.add(1l);
            idsClientes.add(2l);
            List<Cliente> clientes = mCliente.getClientesXRazonSocialParcialmente("Lui");
            for (Cliente cli : clientes) {
                System.out.println("Id: " + cli.getId());
                System.out.println("CUIT: " + cli.getCuit());
                System.out.println("Razon Social: " + cli.getRazonSocial());
                System.out.println("-----------------");
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            mCliente.cerrarEntityManager();
        }
    }

    public static void mostrarFactura(Factura factura) {
        List<Factura> facturas = new ArrayList<>();
        facturas.add(factura);
        mostrarFacturas(facturas);
    }

    public static void mostrarFacturas(List<Factura> facturas) {
        for (Factura fact : facturas) {
            System.out.println("N° Comp: " + fact.getStrProVentaNroComprobante());
            System.out.println("Fecha: " + FuncionApp.formatLocalDateToString(fact.getFechaComprobante()));
            System.out.println("CUIT Cliente: " + FuncionApp.formatCuitConGuiones(fact.getCliente().getCuit()));
            System.out.println("Cliente: " + fact.getCliente().getRazonSocial() + " (" + fact.getCliente().getId() + ")");
            System.out.println("------Articulos------");
            for (FacturaDetalle detalle : fact.getDetallesFactura()) {
                System.out.println(detalle.getArticulo().getDenominacion() + ", " + detalle.getCantidad() + " unidades, $" + FuncionApp.getFormatMilDecimal(detalle.getSubTotal(), 2));
            }
            System.out.println("Total: $" + FuncionApp.getFormatMilDecimal(fact.getTotal(), 2));
            System.out.println("*************************");
        }
    }

    // Punto 1: Listar todos los clientes.
    public static void listarTodosLosClientes() {
        ClienteManager mCliente = new ClienteManager(true);
        try {
            List<Cliente> clientes = mCliente.getClientesXRazonSocialParcialmente("");
            for (Cliente cli : clientes) {
                System.out.println("Id: " + cli.getId());
                System.out.println("CUIT: " + cli.getCuit());
                System.out.println("Razon Social: " + cli.getRazonSocial());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            mCliente.cerrarEntityManager();
        }
    }

    // Punto 2: Listar todas las facturas generadas en el último mes.
    public static void listarFacturasUltimoMes() {
        FacturaManager mFactura = new FacturaManager(true);
        try {
            LocalDate fechaActual = LocalDate.now();
            List<Factura> facturas = mFactura.getFacturasUltimoMes(fechaActual);
            mostrarFacturas(facturas);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            mFactura.cerrarEntityManager();
        }
    }

    // Punto 3: Obtener el cliente que ha generado más facturas.
    public static void obtenerClienteConMasFacturas() {
        ClienteManager mCliente = new ClienteManager(true);
        try {
            Cliente cliente = mCliente.getClienteConMasFacturas();
            System.out.println("Id: " + cliente.getId());
            System.out.println("CUIT: " + cliente.getCuit());
            System.out.println("Razon Social: " + cliente.getRazonSocial());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            mCliente.cerrarEntityManager();
        }
    }

    // Punto 4: Listar los artículos más vendidos.
    public static void listarArticulosMasVendidos() {
        ClienteManager mCliente = new ClienteManager(true);
        try {
            List<Object[]> articulosMasVendidos = mCliente.getArticulosMasVendidos();
            for (Object[] row : articulosMasVendidos) {
                Articulo articulo = (Articulo) row[0];
                Long totalVendido = (Long) row[1];
                System.out.println("Artículo: " + articulo.getDenominacion() + " | Total Vendido: " + totalVendido);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            mCliente.cerrarEntityManager();
        }
    }

    // Punto 5: Consultar las facturas emitidas en los 3 últimos meses de un cliente específico.
    public static void listarFacturasUltimosTresMesesCliente(Long idCliente) {
        FacturaManager mFactura = new FacturaManager(true);
        try {
            LocalDate fechaActual = LocalDate.now();
            LocalDate fechaInicio = FuncionApp.restarMeses(fechaActual,3);
            List<Factura> facturas = mFactura.buscarFacturasXRangoFechas(fechaInicio, fechaActual);
            mostrarFacturas(facturas);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            mFactura.cerrarEntityManager();
        }
    }

    // Punto 6: Calcular el monto total facturado por un cliente.
    public static void calcularMontoTotalFacturadoCliente(Long idCliente) {
        FacturaManager mFactura = new FacturaManager(true);
        try {
            Double totalFacturado = mFactura.getMontoTotalFacturadoPorCliente(idCliente);
            System.out.println("Total facturado por el cliente con ID " + idCliente + ": $" + FuncionApp.getFormatMilDecimal(totalFacturado, 2));
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            mFactura.cerrarEntityManager();
        }
    }

    // Punto 7: Listar los Artículos vendidos en una factura.
    public static void listarArticulosDeFactura(Long idFactura) {
        FacturaManager mFactura = new FacturaManager(true);
        try {
            List<FacturaDetalle> detalles = mFactura.getArticulosDeFactura(idFactura);
            for (FacturaDetalle detalle : detalles) {
                System.out.println("Artículo: " + detalle.getArticulo().getDenominacion() + ", Cantidad: " + detalle.getCantidad() + ", Subtotal: $" + FuncionApp.getFormatMilDecimal(detalle.getSubTotal(), 2));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            mFactura.cerrarEntityManager();
        }
    }

    // Punto 8: Obtener el Artículo más caro vendido en una factura.
    public static void obtenerArticuloMasCaroDeFactura(Long idFactura) {
        FacturaManager mFactura = new FacturaManager(true);
        try {
            Articulo articuloMasCaro = (Articulo) mFactura.getArticuloMasCaroDeFactura(idFactura);
            System.out.println("Artículo más caro en la factura con ID " + idFactura + ": " + articuloMasCaro.getDenominacion() + " - Precio: $" + FuncionApp.getFormatMilDecimal(articuloMasCaro.getPrecioVenta(), 2));
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            mFactura.cerrarEntityManager();
        }
    }

    // Punto 9: Contar la cantidad total de facturas generadas en el sistema.
    public static void contarCantidadTotalFactura() {
        FacturaManager mFactura = new FacturaManager(true);
        try {
            Long totalFacturas = mFactura.getCantidadTotalFacturas();
            System.out.println("Cantidad total de facturas generadas: " + totalFacturas);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            mFactura.cerrarEntityManager();
        }
    }

    // Punto 10: Listar las facturas cuyo total es mayor a un valor determinado.
    public static void listarFacturasConTotalMayorA(Double valor) {
        FacturaManager mFactura = new FacturaManager(true);
        try {
            List<Factura> facturas = mFactura.getFacturasConTotalMayorA(valor);
            mostrarFacturas(facturas);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            mFactura.cerrarEntityManager();
        }
    }

    // Punto 11: Consultar las facturas que contienen un Artículo específico, filtrando por el nombre del artículo.
    public static void listarFacturasConArticuloPorNombre(String nombreArticulo) {
        FacturaManager mFactura = new FacturaManager(true);
        try {
            List<Factura> facturas = mFactura.getFacturasConArticuloPorNombre(nombreArticulo);
            mostrarFacturas(facturas);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            mFactura.cerrarEntityManager();
        }
    }

    // Punto 12: Listar los Artículos filtrando por código parcial.
    public static void listarArticulosPorCodigoParcial(String codigoParcial) {
        ClienteManager mCliente = new ClienteManager(true);
        try {
            List<Articulo> articulos = mCliente.getArticulosPorCodigoParcial(codigoParcial);
            for (Articulo art : articulos) {
                System.out.println("Id: " + art.getId());
                System.out.println("Código: " + art.getCodigo());
                System.out.println("Denominación: " + art.getDenominacion());
                System.out.println("Precio Venta: $" + FuncionApp.getFormatMilDecimal(art.getPrecioVenta(), 2));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            mCliente.cerrarEntityManager();
        }
    }

    // Punto 13: Listar todos los Artículos cuyo precio sea mayor que el promedio de los precios de todos los Artículos.
    public static void listarArticulosConPrecioMayorAlPromedio() {
        ClienteManager mCliente = new ClienteManager(true);
        try {
            List<Articulo> articulos = mCliente.getArticulosConPrecioMayorAlPromedio();
            for (Articulo art : articulos) {
                System.out.println("Id: " + art.getId());
                System.out.println("Código: " + art.getCodigo());
                System.out.println("Denominación: " + art.getDenominacion());
                System.out.println("Precio Venta: $" + FuncionApp.getFormatMilDecimal(art.getPrecioVenta(), 2));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            mCliente.cerrarEntityManager();
        }
    }

    // Punto 14: Explique y ejemplifique la cláusula EXISTS aplicando la misma en el modelo aplicado en el presente trabajo práctico.
    // Devuelve todos los clientes que tengan más de 10 facturas.
    public static void buscarClientesConMas10Facturas(){
        ClienteManager mCliente = new ClienteManager(true);
        try {
            List<Cliente> clientes = mCliente.getClientesConMasDe10Facturas();
            for(Cliente cli : clientes){
                System.out.println("Id: " + cli.getId());
                System.out.println("CUIT: " + cli.getCuit());
                System.out.println("Razon Social: " + cli.getRazonSocial());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            mCliente.cerrarEntityManager();
        }
    }
}

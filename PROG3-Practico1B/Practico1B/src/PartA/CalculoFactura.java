package PartA;

public class CalculoFactura {
    public static String [][] articulos = {
            //Codigo, denominacion, precio, unidad o kilogramo
            {"100", "Azucar", "20", "U"},
            {"101", "Leche", "30", "U"},
            {"102", "Aceite", "50", "U"},
            {"103", "Sal", "45", "U"},
            {"104", "Fideos", "15", "U"},
            {"105", "Arroz", "28", "U"},
            {"106", "Galletas", "26", "U"},
            {"107", "Carne Molida", "220", "Kg"},
            {"108", "Shampoo", "42", "U"},
            {"109", "Queso Mantecoso", "178", "Kg"},
            {"110", "Jamon Cocido", "320", "Kg"},
            {"111", "Naranjas", "80", "Kg"}
    };

    // Metodo para buscar un artículo por su código.
    public static String[] buscarArticulo(String codigo) {
        for (String[] articulo : articulos) {
            if (articulo[0].equals(codigo)) {
                return articulo;
            }
        }
        return null;
    }
}

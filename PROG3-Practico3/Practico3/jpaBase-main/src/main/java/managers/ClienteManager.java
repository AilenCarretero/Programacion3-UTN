package managers;

import funciones.FuncionApp;
import org.example.Articulo;
import org.example.Cliente;
import org.example.Factura;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClienteManager {
    EntityManagerFactory emf = null;
    EntityManager em = null;

    public ClienteManager(boolean anularShowSQL) {
        Map<String, Object> properties = new HashMap<>();
        if(anularShowSQL){
            // Desactivar el show_sql (si está activado en el persistence.xml o configuración por defecto)
            properties.put("hibernate.show_sql", "false");
        }else{
            properties.put("hibernate.show_sql", "true");
        }
        emf = Persistence.createEntityManagerFactory("example-unit", properties);
        em = emf.createEntityManager();

    }

    public List<Cliente> getClientesXIds(List<Long> idsClientes){
        String jpql = "FROM Cliente WHERE id IN (:idsClientes) ORDER BY razonSocial ASC";
        Query query = em.createQuery(jpql);
        query.setParameter("idsClientes", idsClientes);
        List<Cliente> clientes = query.getResultList();
        return clientes;
    }

    public List<Cliente> getClientesXRazonSocialParcialmente(String razonSocial){
        StringBuilder jpql = new StringBuilder("SELECT DISTINCT(cliente) FROM Cliente cliente WHERE 1=1 ");
        if(!FuncionApp.isEmpty(razonSocial))
            jpql.append(this.parseSearchField("cliente.razonSocial", razonSocial));
        jpql.append(" ORDER BY cliente.razonSocial ASC");
        Query query = em.createQuery(jpql.toString());
        List<Cliente> clientes = query.getResultList();
        return clientes;
    }

    public Cliente getClienteConMasFacturas() {
        String jpql = "SELECT f.cliente FROM Factura f GROUP BY f.cliente ORDER BY COUNT(f) DESC";
        Query query = em.createQuery(jpql);
        query.setMaxResults(1);
        return (Cliente) query.getSingleResult();
    }

    public List<Object[]> getArticulosMasVendidos() {
        String jpql = "SELECT d.articulo, SUM(d.cantidad) as total FROM FacturaDetalle d GROUP BY d.articulo ORDER BY total DESC";
        Query query = em.createQuery(jpql);
        return query.getResultList();
    }

    public List<Articulo> getArticulosPorCodigoParcial(String codigoParcial) {
        String jpql = "FROM Articulo a WHERE a.codigo LIKE :codigo";
        Query query = em.createQuery(jpql);
        query.setParameter("codigo", "%" + codigoParcial + "%");
        return query.getResultList();
    }

    public List<Articulo> getArticulosConPrecioMayorAlPromedio() {
        String jpql = "FROM Articulo a WHERE a.precioVenta > (SELECT AVG(a2.precioVenta) FROM Articulo a2)";
        Query query = em.createQuery(jpql);
        return query.getResultList();
    }

    public List<Cliente> getClientesConMasDe10Facturas() {
        String jpql = "SELECT c FROM Cliente c JOIN c.facturas f GROUP BY c HAVING COUNT(f) > 10";
        Query query = em.createQuery(jpql);
        return query.getResultList();
    }


    public void cerrarEntityManager(){
        em.close();
        emf.close();
    }

    public String parseSearchField(String field, String value) {

        String[] fields = new String[1];
        fields[0] = field;

        return this.parseSearchField(fields, value);
    }

    public String parseSearchField(String field[], String value) {
        if(value != null) {
            String[] values = value.split(" ");
            StringBuffer result = new StringBuffer();

            for(int i = 0; i < values.length; i++) {

                StringBuffer resultFields = new StringBuffer();

                if(!values[i].trim().equals("")){
                    result.append(" AND ");

                    for (int j = 0; j < field.length ; j++){

                        if (j!=0)
                            resultFields.append(" OR ");

                        resultFields.append(" (LOWER(" + field[j].trim() + ") LIKE '" + values[i].trim().toLowerCase() + "%' OR LOWER(" + field[j].trim() + ") LIKE '%" + values[i].trim().toLowerCase() + "%')");
                    }
                    result.append("(" + resultFields.toString() + ")");
                }
            }
            return result.toString();
        }
        return "";
    }
}

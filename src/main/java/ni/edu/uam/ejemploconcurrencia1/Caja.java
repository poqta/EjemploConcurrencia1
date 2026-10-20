package ni.edu.uam.ejemploconcurrencia1;

public class Caja {

    private int cantidadVentas = 0;
    private int totalRecaudado = 0;

    public void registrarVenta(String vendedor, int monto){
        cantidadVentas++;
        totalRecaudado += monto;
        System.out.println(vendedor + " registró una venta de C$: " + monto + " | Ventas acumuladas: " + cantidadVentas + " | Total recaudado: " + totalRecaudado);
    }

    public int getCantidadVentas() {
        return cantidadVentas;
    }

    public int getTotalRecaudado() {
        return totalRecaudado;
    }
}

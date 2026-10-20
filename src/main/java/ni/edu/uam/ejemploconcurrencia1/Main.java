package ni.edu.uam.ejemploconcurrencia1;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Caja caja = new Caja();

        /**
         * Runnable representa la tarea que ejecutara cada vendedor
         */

        Runnable vendedor1 = () -> procesarVentas("Vendedor 1", caja);
        Runnable vendedor2 = () -> procesarVentas("Vendedor 2", caja);
        Runnable vendedor3 = () -> procesarVentas("Vendedor 3", caja);

        // Crear los tres hilos para llevar a cabo las operaciones
        Thread hilo1 = new Thread(vendedor1);
        Thread hilo2 = new Thread(vendedor2);
        Thread hilo3 = new Thread(vendedor3);

        System.out.println("---- Inicio del proceso de ventas ----");

        /**
         * hilo.start() inicia cada Thread
         * Los tres vendedores comenzaran a procesar sus ventas de manera concurrente
         */

        hilo1.start();     // Vendedor 1
        hilo2.start();    // Vendedor 2
        hilo3.start();    // Vendedor 3


        /**
         * join() permite que el hilo main espere a que los hilos de los vendedores terminen
         */

        hilo1.join();
        hilo2.join();
        hilo3.join();

        System.out.println("---- Resultados finales ----");
        System.out.println("Cantidad total de ventas: " + caja.getCantidadVentas());
        System.out.println("Total recaudado: C$: " + caja.getTotalRecaudado());
    }

    private static void procesarVentas(String vendedor, Caja caja) {
        for (int i = 0; i <= 200; i++) {
            try {
                /**
                 * Simular que procesamos una venta que tarda aproximadamente 500 milisegundos
                 */
                Thread.sleep(500);
                caja.registrarVenta(vendedor, 100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(vendedor + " fue interrumpido");
                return;
            }
        }
    }
}

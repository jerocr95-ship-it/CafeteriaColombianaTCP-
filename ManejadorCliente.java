import java.io.*;
import java.net.Socket;

public class ManejadorCliente implements Runnable {

    private final Socket cliente;

    public ManejadorCliente(Socket cliente) {
        this.cliente = cliente;
    }

    @Override
    public void run() {
        try (
            Socket conexion = cliente;
            BufferedReader entrada = new BufferedReader(
                new InputStreamReader(conexion.getInputStream())
            );
            PrintWriter salida = new PrintWriter(
                conexion.getOutputStream(), true
            )
        ) {
            salida.println("Bienvenido a Cafeteria Colombiana");
            salida.println("Menu: Tinto, Capuchino, Latte");
            salida.println("Escribe tu pedido:");

            String pedido = entrada.readLine();

            if (pedido != null) {
                System.out.println(
                    Thread.currentThread().getName()
                    + " recibio: " + pedido
                );

                salida.println(
                    "Pedido recibido: " + pedido
                );
            }

        } catch (IOException e) {
            System.out.println(
                "Error con cliente: " + e.getMessage()
            );
        }
    }
}
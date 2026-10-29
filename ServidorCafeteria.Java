import java.io.*;
import java.net.*;

public class ServidorCafeteria {

    public static void main(String[] args) {

        int puerto = 5000;

        try (ServerSocket servidor = new ServerSocket(puerto)) {

            System.out.println("==================================");
            System.out.println("   CAFETERIA COLOMBIANA");
            System.out.println("   SERVIDOR INICIADO");
            System.out.println("==================================");
            System.out.println("Esperando clientes...");

            while (true) {

                Socket cliente = servidor.accept();

                System.out.println("Nuevo cliente conectado");

                Thread hilo = new Thread(
                new ManejadorCliente(cliente)
                );

                hilo.start();
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void atenderCliente(Socket cliente) {

        try (
            Socket conexion = cliente;

            BufferedReader entrada = new BufferedReader(
                new InputStreamReader(conexion.getInputStream())
            );

            PrintWriter salida = new PrintWriter(
                conexion.getOutputStream(), true
            )
        ) {

            salida.println("Bienvenido a la Cafeteria Colombiana");
            salida.println("Menu: Americano, Capuchino, Espresso");

            String pedido;

            while ((pedido = entrada.readLine()) != null) {

                if (pedido.equalsIgnoreCase("salir")) {
                    salida.println("Gracias por su compra");
                    break;
                }

                System.out.println(
                    Thread.currentThread().getName()
                    + " - Pedido recibido: " + pedido
                );

                salida.println("Pedido confirmado: " + pedido);
            }

        } catch (IOException e) {
            System.out.println("Error con cliente: " + e.getMessage());
        }

        System.out.println("Cliente desconectado");
    }
}
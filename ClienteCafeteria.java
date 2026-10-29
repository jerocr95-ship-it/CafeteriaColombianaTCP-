
    

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClienteCafeteria {

    public static void main(String[] args) {

        try (
            Socket socket = new Socket("localhost", 5000);
            BufferedReader entrada = new BufferedReader(
                new InputStreamReader(socket.getInputStream())
            );
            PrintWriter salida = new PrintWriter(
                socket.getOutputStream(), true
            );
            Scanner teclado = new Scanner(System.in)
        ) {
            System.out.println(entrada.readLine());
            System.out.println(entrada.readLine());
            System.out.println(entrada.readLine());

            System.out.print("Tu pedido: ");
            String pedido = teclado.nextLine();

            salida.println(pedido);

            System.out.println(entrada.readLine());
            System.out.println("Gracias por tu compra.");

        } catch (IOException e) {
            System.out.println(
                "No se pudo conectar: " + e.getMessage()
            );
        }
    }
}
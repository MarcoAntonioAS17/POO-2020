package mx.uv.fiee.iinf.poo.demos.serversocketv2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * En esta versión del servidor se permite una conexión uno a uno
 * recibiendo mensajes del cliente y dando la capacidad al usuario de
 * responderlos.
 *
 * Los puntos principales son, el uso de un ciclo para controlar el flujo
 * de la aplicación, terminando hasta que se lee de la consola la palabra "stop".
 *
 * Para enviar y recibir mensajes es necesario utilizar ambos flujos proporcionados
 * por el socket, entrada mediante InputStream y salida mediante OutputStream.
 *
 * La entrada del usuario es manejado mediante el flujo de entrada de la consola
 * referenciado por método "in", de la clase System.
 *
 */
public class Server {
    public static int PORT = 9888;

    static Runnable nuevo_cliente(Socket sock){

        return () -> {
            try {
                Socket socket = new Socket();
                socket=sock;
                System.out.println("Añadiendo conexión");
                System.out.println("Conexión con: " + socket.toString() + " Aceptada");

                DataInputStream din = null;
                din = new DataInputStream(socket.getInputStream());

                DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
                InputStreamReader in = new InputStreamReader(System.in, StandardCharsets.UTF_8);

                BufferedReader buff = new BufferedReader(in);

                String line1 = "", line2 = "";

                while (!line1.equals("stop")) {

                    line1 = din.readUTF();
                    System.out.println("Cliente " + socket.toString() + " dice: " + line1);

                    System.out.print("Respuesta al cliente: ");

                    line2 = buff.readLine();


                    dos.writeUTF(line2);
                    dos.flush();

                }

                din.close();
                dos.close();
                System.out.println("Cerrando conexión: "+socket.toString()+"... Hasta pronto.");
            } catch (IOException e) {
                e.printStackTrace();
            }

        };

    }

    public static void main(String[] args) {


        try {
            boolean bandera = true;
            ServerSocket server = new ServerSocket (PORT);

            ExecutorService service = Executors.newCachedThreadPool();

            System.out.println("Esperando conexiones");

            while(true){
                Socket socket = server.accept();
                service.submit(nuevo_cliente(socket));
            }

        } catch (IOException ex) {
            ex.printStackTrace ();
        }
        
    }


    
}
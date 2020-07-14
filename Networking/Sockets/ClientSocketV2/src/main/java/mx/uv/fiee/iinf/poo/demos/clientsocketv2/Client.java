package mx.uv.fiee.iinf.poo.demos.clientsocketv2;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * En esta versión del cliente se permite una conexión uno a uno
 * recibiendo mensajes del servidor y dando la capacidad al usuario de
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
public class Client {
    public static String ADDRESS = "localhost";
    public static int PORT = 9888;
    
    public static void main(String [] args) {
        try {

            Socket socket = new Socket (ADDRESS, PORT);


            DataInputStream din = new DataInputStream (socket.getInputStream ());
            DataOutputStream dos = new DataOutputStream (socket.getOutputStream ());


            InputStreamReader in = new InputStreamReader (System.in, StandardCharsets.UTF_8);

            BufferedReader buff = new BufferedReader (in);

            String line1 = "", line2 = "";


            while (!line1.equals ("stop")) {
                System.out.print ("Message: ");


                line1 = buff.readLine ();


                dos.writeUTF (line1);
                dos.flush ();


                line2 = din.readUTF ();
                System.out.println ("Server says: " + line2);
                
            }

            din.close ();
            dos.close ();
            socket.close ();
            
        } catch (IOException ex) {
            ex.printStackTrace ();
        }
        
    }   
}
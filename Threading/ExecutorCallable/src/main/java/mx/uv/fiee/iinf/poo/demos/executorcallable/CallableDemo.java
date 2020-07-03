package mx.uv.fiee.iinf.poo.demos.executorcallable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Implementa la ejecución de tareas basadas en un objeto tipo Callable,
 * que nos devolverán un valor al finalizar su ejecución.
 *
 * La lógica del ejemplo es crear dos tareas, la primera nos devolverá un String y
 * la segunda un Double.
 *
 * Para obtener el resultado nos valemos de un objeto de tipo Future.
 */
public class CallableDemo {

    public static void main (String [] args) {
        // Creamos a la primer tarea, que nos devolverá un String
        Callable<String> callOne = new Callable<String> () {
            @Override
            public String call() throws Exception {
                // Simulamos una tarea lenta, de 2 segundos
                Thread.sleep (2000);
                return "PKAT"; // y devolvemos un String
            }
        };
        
        // Creamos a la segunda tarea, que nos devolverá un Double (con cara de triple)
        Callable<Double> callTwo = () -> {
            // simulamos una tarea lenta, de 2 segundos
            Thread.sleep (2000);
            return Math.PI; // y devolvemos un valor double
        };
        

        // Creamos un executor, basado en un SingleThreadExecutor, cuyo ThreadPool es de 1 hilo
        ExecutorService executor = Executors.newSingleThreadExecutor ();

        // Asignamos las 2 tareas basadas en un objeto Callable.
        // La sobrecarga del método submit que recibe un Callable, devuelve un objeto
        // tipo Future que contendrá el resultado o la excepción de la ejecución de la tarea
        Future<String> strFuture = executor.submit (callOne);
        Future<Double> dblFuture = executor.submit (callTwo);

        System.out.println ("Main thread...getting results...");

        // Para obtener los resultados, se utiliza al objeto Future devuelto por la
        // asignación de la tarea al planificador.
        // Como tal ejecución puede devolver una excepción, el intento de obtener
        // el resultado debe estar contenido en una setencia try-catch
        try {
            System.out.println ("First result set");
            // Esperamos por la finalización de la tarea, si es que no ha terminado ya,
            // y obtemos el resultado. El tipo de dato devuelto será acorde al parámetro del objeto Callable
            String foo = strFuture.get (); // que fue utilizado para contener la tarea
            System.out.println ("Result task 1: " + foo);
            
            System.out.println ("Second result set");
            // El método get es bloqueante, de modo que el flujo del hilo principal,
            // desde donde procesamos la tareas, no continuará hasta que exista un resultado
            // o en su caso, una excepción.
            //
            // Así que obtemos el resultado de la segunda tarea.
            Double bar = dblFuture.get ();
            System.out.println ("Result task 2: " + bar);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace ();
        }

        System.out.println ("Shutting down executor service");
        executor.shutdown (); // finalizamos el servicio
    }
    
}

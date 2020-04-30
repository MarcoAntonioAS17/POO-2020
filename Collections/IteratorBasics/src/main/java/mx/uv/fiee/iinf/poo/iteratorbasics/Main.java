package mx.uv.fiee.iinf.poo.iteratorbasics;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Clase cliente
 */
public class Main {
    public static void main (String [] args) {
        // creamos al objeto que almacenará los objetos Film
        MyMarvelCollection collection = new MyMarvelCollection ();

        // agreamos algunos objetos Film al almacenamiento
        collection.add (new Film ("Ironman", 2008));
        collection.add (new Film ("Captain America", 2010));
        collection.add (new Film ("The Avengers", 2012));

        /**
         * mediante esta forma recorremos los elementos almacenados
         * en nuestra colección de objetos Film mediante un ciclo tradicional.
         * Para ello, fue necesario agregar dos métodos a la clase MarvelCollection,
         * uno para recuperar el tamaño del almacenamiento interno y otro para
         * recuperar al objeto Film en sí.
         *
         * Esto que es funcional para recuperar objeto específicos, presenta un problema
         * al momento de modificar la colección dentro del ciclo mismo, ya que los
         * límites, inferior y superior, son fijos y no se actualizan una vez modificada
         * la estructura a recorrer, pudiendo incluso provocar errores del tipo
         * IndexOutOfRangeException
         */
         /*for (int i= 0; i < collection.size (); i++) {
            Film f = collection.get (i);
            System.out.println (f);
            collection.remove (f);
         }*/

        /**
         * Al implementar la interfaz Iterable tenemos la capacidad
         * de recuperar al objeto iterador, por medio del cuál podemos
         * recuperra los elementos almacenados
         */
        System.out.println ("Iterator Objet...");
        Iterator<Film> iterator = collection.iterator ();
        while (iterator.hasNext ()) {
            System.out.println (iterator.next ());
        }

        /**
         * Un beneficio adicional de implementar la intefaz Iterable es que
         * tenemos la capacidad de utilizar estructuras especializadas en recorrer
         * colecciones
         */
        System.out.println ("\nForEach Loop...");
        for (Film f: collection) {
            System.out.println (f);
        }
    }
}



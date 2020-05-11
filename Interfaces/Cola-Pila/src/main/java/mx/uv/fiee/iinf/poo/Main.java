package mx.uv.fiee.iinf.poo;

import java.util.Iterator;

public class Main {

    public static void main (String [] args) {
        //creando objetos
        Circle circle1 = new Circle (10, 10, 20);
        Circle circle2 = new Circle (5, 5, 30);
        Circle circle3 = new Circle (15, 15, 10);

        Circle recoletor;

        System.out.println("Prueba de la pila");
        MiPila<Circle> Pila = new MiPila<>();

        System.out.println("\nSe insertan 3 circulos a la pila en el siguiente orden\n");
        System.out.println(circle1+"\n"+circle2+"\n"+circle3+"\n");

        Pila.push(circle1);
        Pila.push(circle2);
        Pila.push(circle3);

        System.out.println("\nSe saca un elemento de la pila");
        recoletor = Pila.pop();
        System.out.println("Elemento sacado: "+recoletor);

        System.out.println("\nSe saca otro elemento de la pila");
        recoletor = Pila.pop();
        System.out.println("Elemento sacado: "+recoletor);

        System.out.println("\nSe saca otro elemento de la pila");
        recoletor = Pila.pop();
        System.out.println("\nSe saca un elemento de la pila");
        recoletor = Pila.pop();
        System.out.println("Elemento sacado: "+recoletor);

        System.out.println("\n\nPrueba de la estructura Cola\n");

        MiCola<Circle> cola = new MiCola<>();
        System.out.println("\nSe insertan 3 circulos a la cola en el siguiente orden\n");
        System.out.println(circle1+"\n"+circle2+"\n"+circle3+"\n");

        cola.add(circle1);
        cola.offer(circle2);
        cola.add(circle3);

        System.out.println("\nSe saca un elemento de la cola");
        recoletor = cola.remove();
        System.out.println("Elemento sacado: "+recoletor);

        System.out.println("\nElemento al inicio de la cola");
        recoletor = cola.peek();
        System.out.println("Elemento: "+recoletor);

        System.out.println("\nSe saca otro elemento de la cola");
        recoletor = cola.remove();
        System.out.println("Elemento sacado: "+recoletor);

        System.out.println("\nSe saca otro elemento de la cola");
        recoletor = cola.remove();
        System.out.println("\nAhora la cola se encuentra vacia");
        System.out.println("\nSe saca otro elemento de la cola y esta nula");
        recoletor = cola.remove();
        System.out.println("Elemento sacado: "+recoletor);

    }

}






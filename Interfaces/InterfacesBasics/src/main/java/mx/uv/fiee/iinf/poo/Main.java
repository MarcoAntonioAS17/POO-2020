package mx.uv.fiee.iinf.poo;

import java.util.Iterator;

public class Main {

    public static void main (String [] args) {
        //creando objetos
        Circle circle1 = new Circle (10, 10, 20);
        Circle circle2 = new Circle (5, 5, 30);
        Rectangle rec1 = new Rectangle (5, 5, 15, 15);
        Rectangle rec2 = new Rectangle (10, 10, 20, 20);

        // almacenando los objetos en el contenedor
        ShapesCollection shapesCol = new ShapesCollection();
        shapesCol.add (circle1);
        shapesCol.add (circle2);
        shapesCol.add (rec1);
        shapesCol.add (rec2);

        System.out.println("\nSe impreme ArrayList por primera vez\n");
        // recorriendo el almacenamiento
        for (Shape s: shapesCol) {
            System.out.println (s);
        }

        System.out.println("\nSe elimina Circulo 2 y Rectangulo1 del ArrayList\n");
        shapesCol.remove (circle2);
        shapesCol.remove (rec1);

        System.out.println("\nSe impreme ArrayList por segunda vez\n");
        Iterator<Shape> myIterator = shapesCol.iterator ();
        while (myIterator.hasNext ()) {
            System.out.println (myIterator.next ());
        }
    }

}






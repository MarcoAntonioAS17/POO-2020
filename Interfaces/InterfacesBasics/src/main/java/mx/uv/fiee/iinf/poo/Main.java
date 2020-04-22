package mx.uv.fiee.iinf.poo;

public class Main {

    public static void main (String [] args) {
        Circle original = new Circle (5, 5, 10);
        original.paint ();

        try {
            Circle copia = (Circle) original.clone();

            original.calculateArea ();
            copia.calculateArea ();
        } catch (CloneNotSupportedException ex) {
            ex.printStackTrace ();
        }

    }

}






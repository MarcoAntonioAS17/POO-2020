package mx.uv.fiee.iinf.poo;

import java.util.ArrayList;
import java.util.Iterator;

public class ShapesCollection implements Iterable<Shape> {

    private ArrayList<Shape> shapes;

    public  ShapesCollection(){
        shapes = new ArrayList<>();
    }

    public boolean add (Shape Nuevo){
        return shapes.add(Nuevo);
    }

    public boolean remove (Shape shape){
        return shapes.remove(shape);
    }

    public void remove (int index){
        shapes.remove(index);
    }

    public int size(){
        return shapes.size();
    }

    public Shape get (int index) {
        return shapes.get (index);
    }

    @Override
    public Iterator<Shape> iterator () {

        return new Iterator<Shape> () {
            private int position = -1;

            @Override
            public boolean hasNext () {
                return position < shapes.size () - 1;
            }

            @Override
            public Shape next () {
                position++;
                return shapes.get (position);
            }
        };
    }

}

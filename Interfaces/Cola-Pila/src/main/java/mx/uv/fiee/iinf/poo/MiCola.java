package mx.uv.fiee.iinf.poo;

import java.util.ArrayDeque;
import java.util.LinkedList;

public class MiCola<E> {
    private ArrayDeque<E> LaCola;

    public MiCola(){
        LaCola = new ArrayDeque<>();
    }

    public boolean add(E nuevo){
        return LaCola.add(nuevo);
    }

    public boolean offer(E nuevo){
        return LaCola.offer(nuevo);
    }

    public E peek(){
        return LaCola.peek();
    }

    public E remove(){
        if(LaCola.isEmpty())
            return null;
        return LaCola.removeFirst();
    }


}

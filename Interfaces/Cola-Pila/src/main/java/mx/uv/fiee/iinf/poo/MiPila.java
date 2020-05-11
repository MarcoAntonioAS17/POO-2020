package mx.uv.fiee.iinf.poo;

import java.util.LinkedList;

public class MiPila<E> {
    private LinkedList<E> LaPila;

    public MiPila(){
        LaPila = new LinkedList<>();
    }

    public void push(E nuevo){
        LaPila.addFirst(nuevo);
    }

    public E pop(){
        if (LaPila.size()>0)
            return LaPila.removeFirst();
        else
            return null;
    }


}

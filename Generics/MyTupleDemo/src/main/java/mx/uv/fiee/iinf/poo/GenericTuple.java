package mx.uv.fiee.iinf.poo;

public class GenericTuple<K, V> {
    private K key;
    private V val;

    public GenericTuple (K uno, V dos) {
        this.key = uno;
        this.val = dos;
    }

    public K getKey () {
        return key;
    }

    public V getValue () {
        return val;
    }

    @Override
    public String toString () {
        return String.format ("(%s, %s)", key.toString (), val.toString ());
    }
}

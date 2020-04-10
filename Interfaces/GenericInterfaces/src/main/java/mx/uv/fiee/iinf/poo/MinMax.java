package mx.uv.fiee.iinf.poo;

public class MinMax<T extends Comparable<T>> implements IMinMax<T> {
    private T [] values;

    public MinMax (T [] values) {
        this.values = values;
    }

    public T min () {
        T foo = values [0];

        for (int i = 0; i < values.length; i++) {
            if (foo.compareTo (values [i]) > 0) {
                foo = values [i];
            }
        }

        return foo;
    }

    public T max  () {
        T foo = values [0];

        for (int i = 0; i < values.length; i++) {
            if (foo.compareTo (values [i]) < 0) {
                foo = values [i];
            }
        }

        return foo;
    }
}
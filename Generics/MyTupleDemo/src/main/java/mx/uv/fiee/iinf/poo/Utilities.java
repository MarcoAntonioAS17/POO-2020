package mx.uv.fiee.iinf.poo;

public class Utilities {

    public static <T extends GenericTuple> boolean compara (T one, T two) {
        //if (one instanceof GenericTuple && two instanceof GenericTuple) {
            return one.getValue ().equals (two.getValue ()) &&
                    one.getKey ().equals ( two.getKey ());
        //}

        //return false;
    }

}

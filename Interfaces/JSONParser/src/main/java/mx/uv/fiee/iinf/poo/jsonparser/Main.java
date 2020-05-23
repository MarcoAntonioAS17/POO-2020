package mx.uv.fiee.iinf.poo.jsonparser;

import java.io.File;

/**
 * Clase cliente
 */
public class Main {
    public static void main (String [] args) {
        String sCarpAct = System.getProperty("user.dir");
        File file = new File (sCarpAct+"\\src\\colors.json");
        Colors colors = new Colors();
        colors.parse (file);

        System.out.println("Lista ordenada descendentemente");
        for (String s: colors.getElements ()) {
            System.out.println (s);
        }
    }
}

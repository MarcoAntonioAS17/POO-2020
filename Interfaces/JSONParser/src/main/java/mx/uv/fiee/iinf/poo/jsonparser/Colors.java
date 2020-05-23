package mx.uv.fiee.iinf.poo.jsonparser;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.*;
import java.util.*;

/**
 * Esta clase debe implementar la interfaz JSONParser e implementar
 * al método parse
 *
 */
public class Colors implements  JSONParser{

    List<String> colores = new ArrayList<>();

    @Override
    public void parse(File source) {
        try {
            FileReader in = new FileReader (source);
            BufferedReader reader = new BufferedReader (in);

            JsonArray json = new JsonParser().parse (reader).getAsJsonObject().getAsJsonArray ("colors");
            for (JsonElement element: json) {
                colores.add(element.toString().replace("\"",""));
            }

            reader.close ();
            in.close ();
        } catch (IOException ibex) {
            ibex.printStackTrace ();
            System.exit (1);
        }
    }

    public List<String> getElements(){

        Collections.sort(colores);
        Collections.reverse(colores);

        return colores;
    }


}

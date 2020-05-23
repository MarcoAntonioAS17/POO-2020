package mx.uv.fiee.iinf.poo.jsonparser;

import java.io.File;

/**
 * Interfaz que define el método para realizar el parseo (analisis)
 * de un archivo en formato json
 *
 */
public interface JSONParser {
    void parse (File source);
}

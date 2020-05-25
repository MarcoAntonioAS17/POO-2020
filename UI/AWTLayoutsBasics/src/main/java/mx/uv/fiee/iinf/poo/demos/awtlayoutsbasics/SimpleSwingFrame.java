package mx.uv.fiee.iinf.poo.demos.awtlayoutsbasics;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JButton;

/**
 * Clase que extiende a la clase swing JFrame
 *
 * El API Swing es homogénea en todas las plataformas,
 * por lo que el look and feel será el mismo en todas ellas
 *
 * JFrame representa básicamente a una ventana en la API Swing
 */
public class SimpleSwingFrame extends JFrame {
    
    public SimpleSwingFrame () {
        // establece un layout tipo rejilla como default
        setLayout (new GridLayout (3, 3));
        
        setTitle ("Ventana Swing");
        setSize (800, 600);
        
        // creamos un arreglo de objeto JButton
        // y los agregaomos al Frame
        for (int i = 0; i < 9; i++) {
            JButton button = new JButton ("Button " + (i + 1));
            add (button); // el control es agregado al layout no al JFrame
        }       

        // definimos que al cierre de la ventana, la aplicación termine
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setVisible (true); // mostramos la ventana
        
    }
}
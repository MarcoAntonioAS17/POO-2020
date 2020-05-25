package mx.uv.fiee.iinf.poo.demos.awtlayoutsbasics;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Clase que extiende a la clase AWT Frame
 *
 * La principal diferencia con respecto a swing es que AWT
 * delega la creación y el dibujado de la ventana y los controles al SO,
 * por lo que el comportamiento puede no ser el mismo en las
 * diferentes plataformas, aunque AWT hace lo posible porque así sea.
 *
 * Frame
 */
public class SimpleAWTFrame extends Frame {
    
    public SimpleAWTFrame () {
        // establecemos el tamaño inicial de la ventana
        setSize (800, 600);
        setTitle ("Ventana AWT"); // y se define el título

        // creamos un objeto layout de tipo FlowLayout
        FlowLayout f = new FlowLayout ();
        f.setAlignment (FlowLayout.LEADING); //defiendo el órden como ascendente
        
        setLayout (f); // asignamos a dicha layout como predeterminado al Frame

        // creamos un objeto Button, defiendo su etiqueta, tamaño
        Button b = new Button ("Press me!");
        b.setSize (300, 300);
        add (b); // y añadiéndolo al Frame, al layout realmente

        // se establece un manejador para el evento clic
        b.addActionListener ((ev) -> {
            // al presionar el botón, crea un objeto SimpleSwingFrame
            SimpleSwingFrame s = new SimpleSwingFrame ();
        });

        // creamos un segundo objeto Button
        Button b1 = new Button ("Don't press me!");
        b1.setBounds(300, 300, 100, 100);
        add (b1); // añadiéndolo al Frame
        
        // cremos un campo de texto y mediante sus métodos
        // definimos
        TextField t = new TextField ();
        t.setColumns (30); // longitud máxima permitida
        t.setSize (400, 0); // y su tamaño inicial, a altura del control depende realmente
        // de la fuente utilizada
        
        add (t); // añadimos al campo de texto al Frame
        
        setVisible (true); // se muestra la ventana

        // establece al objeto manejador de ventana
        this.addWindowListener (new WindowListener () {
            @Override
            public void windowOpened (WindowEvent we) {}

            @Override
            public void windowClosing (WindowEvent we) {
                dispose ();
            }

            @Override
            public void windowClosed (WindowEvent we) {}

            @Override
            public void windowIconified (WindowEvent we) {}

            @Override
            public void windowDeiconified (WindowEvent we) {}

            @Override
            public void windowActivated (WindowEvent we) {}

            @Override
            public void windowDeactivated (WindowEvent we) {}
            
        });
    }
    
}


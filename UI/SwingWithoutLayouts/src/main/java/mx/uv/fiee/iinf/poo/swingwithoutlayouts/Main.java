package mx.uv.fiee.iinf.poo.swingwithoutlayouts;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Esta clase demuestra la creación de una ventana,
 * y añadiendo algunos controles en su panel contenedor.
 *
 * Como puede apreciarse la posición de cada control es
 * establecida de forma absoluta, de modo que al momento
 * de redimensionar la ventana, los controles no se adaptan
 * a este cambio de dimensiones, manteniéndose fijos.
 */
public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame ("Login"); //creamos al objeto JFrame
        frame.setSize (350, 200); //con tamaño inicial
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); // al cerrar la ventana se cierra la aplicación
        
        JPanel panel = new JPanel (); //creamos un contenedor del tipo panel
        frame.add (panel); // y lo añadimos a la ventana
        
        setComponents (panel);
        
        frame.setVisible (true); // muestra la vantana
    }

    /**
     * Establece controles al contenedor recibido como parámetro
     *
     * @param panel contenedor donde se colocarán los controles
     */
    public static void setComponents (JPanel panel) {
        panel.setLayout (null); // eliminamos cualquier layout que pudiera existir

        // se crean los controles y se añaden al contenedor
        // usando posición absoluta para cada uno de ellos
        //
        JLabel userLabel = new JLabel ("User");
        userLabel.setBounds (10, 20, 80, 25);
        panel.add (userLabel);
        
        JTextField userText = new JTextField (20);
        userText.setBounds (100, 20, 165, 25);
        panel.add (userText);
        
        JLabel passwordLabel = new JLabel ("Password");
        passwordLabel.setBounds (10, 50, 80, 50);
        panel.add (passwordLabel);
        
        JTextField passwordText = new JTextField (20);
        passwordText.setBounds (100, 50, 165, 25);
        panel.add (passwordText);
        
        JButton loginButton = new JButton ("Login");
        loginButton.setBounds (10, 90, 80, 25);
        panel.add (loginButton);
        
    }
}
package mx.uv.fiee.iinf.poo.mytextfield;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase cliente del componente personalizado.
 */
public class Main {

    public static void main (String [] args) {
        JFrame frame = new JFrame ("Ventana con lista desplegable"); // Crea una ventana mediante la clase JFrame.
        frame.setSize (640, 480); // Definimos el tamaño inicial.
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); // se establece el comportamiento predeterminado al cerrar la ventana.

        // Establecemos el layout predeterminado al tipo FlowLayout, de manera que la alineación de los componentes sea lineal,
        // alineados alienados al centro de la ventana y con un margen de 10 pixeles
        frame.setLayout (new FlowLayout(FlowLayout.CENTER, 10, 10));

        JLabel lblEstados = new JLabel ("Estados"); // creamos una etiqueta para los estados

        // lista de estados de la república mexicana que sirve como origen de datos
        String [] lstEstados = new String [] {
                "----Estados----",
                "Baja California",
                "Baja California Sur",
                "Campeche",
                "Ciudad de México",
                "Coahuila",
                "Colima",
                "Chiapas",
                "Chihuahua",
                "Durango",
                "Guanajuato",
                "Guerrero",
                "Hidalgo",
                "Jalisco",
                "México",
                "Michoacán",
                "Morelos",
                "Nayarit",
                "Nuevo León",
                "Oaxaca",
                "Puebla",
                "Queretaro",
                "San Luis Potosí",
                "Sinaloa",
                "Sinaloa",
                "Sonora",
                "Tabasco",
                "Tamaulipas",
                "Tlaxcala",
                "Veracruz",
                "Yucatán",
                "Zacatecas"
        };

        // Creamos un modelo utilizando a la clase DefaultComboBoxModel y utilizando la lista de estados
        // para inicializarla y como origen de datos
        ComboBoxModel<String> model = new DefaultComboBoxModel<>(lstEstados);

        // Creamos un ComboBox de tipos String, usando al modelo como manejador de los datos
        JComboBox<String> cboEstados = new JComboBox<> (model);

        // Agregamos un manejador para el evento de selección del usuario.
        // El método addActionListener espera un objeto que implemente la interfaz ActionListener
        cboEstados.addActionListener (new ActionListener () {
            /**
             * El método actionPerformed se invoca cuando el usuario selecciona un elemento de los elementos
             * de la lista deplegable.
             *
             * @param e información del elemento que dispara el evento, JComboBox en este caso.
             */
            @Override
            public void actionPerformed (ActionEvent e) {
                // Para obtener al elemento seleccionado utilizamos al modelo.
                // Y se muestra mediante una ventana de dialogo utilizando la clase JOptionPane.
                JOptionPane.showMessageDialog (frame, model.getSelectedItem ());
            }
        });

        // crea un componente usando la clase personalizada
        MyTextField mf = new MyTextField ();
        mf.setColumns (20); // y se define su longitud inicial

        // se agregan los componentes a la ventana (al layout realmente)
        frame.add (lblEstados);
        frame.add (cboEstados);
        frame.add (mf);

        frame.setVisible (true); // mostramos el frame
    }

}

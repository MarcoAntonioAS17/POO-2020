package mx.uv.fiee.iinf.poo.agendatelefonica;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase cliente
 */
public class Main {

    public static void main (String [] args) {
        new Agenda ().setVisible (true);
    }

}

/**
 * Clase que representa nuestra interfaz para la agenda telefónica
 */
class Agenda extends JFrame {
    private JTextField tfName, tfPhone; // campos de datos
    private JButton btnAdd, btnDelete; // acciones

    // JTable nos sirve para almacenar el listado de datos que deseamos mostrar al usuario
    private JTable table;
    private DefaultTableModel model; // JTable utiliza un modelo para mantener referencia a los datos

    public Agenda () {
        super ("Agenda Telefónica");

        tfName = new JTextField (); // instanciamos al JTextField nombre
        tfPhone = new JTextField (); // instanciamos al JTextField teléfono

        btnAdd = new JButton ("Add"); // instanciamos al botón ADD
        // manejador del evento clic del botón ADD
        btnAdd.addActionListener (new ActionListener () {
            /**
             * cada vez que el usuario hace clic se ejecuta el método actionPerformed
             *
             * @param e parámetro con información de la fuente del evento
             */
            @Override
            public void actionPerformed (ActionEvent e) {
                // validamos que los campos no estén vacíos
                if (tfPhone.getText ().length () > 0 && tfName.getText ().length () > 0) {
                    // anexamos los valores de los campos al modelo
                    model.addRow (new String [] {tfName.getText (), tfPhone.getText ()});
                }

                // si alguno de los campos está vacío, pasamos el foco a él
                if (tfName.getText ().length () == 0)
                    tfName.grabFocus ();
                else if (tfPhone.getText ().length () == 0)
                    tfPhone.grabFocus ();
            }
        });

        btnDelete = new JButton ("Delete"); // instanaciamos al botón ELIMINAR
        // manejador del evento clic del botón ELIMINAR
        btnDelete.addActionListener (new ActionListener () {
            /**
             * cada vez que el usuario hace clic se ejecuta el método actionPerformed
             *
             * @param e parámetro con información de la fuente del evento
             */
            @Override
            public void actionPerformed (ActionEvent e) {
                if (table.getSelectedRow () > -1) // validamos si existe algún elemento seleccionado
                    model.removeRow (table.getSelectedRow ()); // si existe, se elimina del modelo
            }
        });

        // definimos la estructura del modelo que será utilizado por el JTable
        model = new DefaultTableModel ();
        model.addColumn ("Nombre"); // constará de dos columnas, nombre
        model.addColumn ("Teléfono"); // y teléfono

        // creamos al JTable y definimos algunas características
        table = new JTable (model);
        table.setGridColor (Color.LIGHT_GRAY);
        table.setShowHorizontalLines (true);
        table.setShowVerticalLines (true);

        // como contenedor para los campos de datos usamos un JPanel
        // con un layout tipo GridLayout de 2 x 2
        JPanel pnlFields = new JPanel ();
        pnlFields.setLayout (new GridLayout(2, 2));

        // agreamos los controles al panel de campos de datos
        pnlFields.add (new JLabel ("Nombre: ")); // la etiqueta no requiere más que instanciación con el texto correspodiente
        pnlFields.add (tfName);
        pnlFields.add (new JLabel ("Teléfono: "));
        pnlFields.add (tfPhone);

        // para organizar al panel de campos + el botón de acción ADD, utilizamos un BoxLayout
        // con alineación vertical
        JPanel pnlTOP = new JPanel ();
        BoxLayout boxLayout = new BoxLayout (pnlTOP, BoxLayout.Y_AXIS);
        pnlTOP.setLayout (boxLayout);
        pnlTOP.add (pnlFields);
        pnlTOP.add (btnAdd);

        // al botón ELIMINAR lo colocamos en un contenedor JPanel, con el objetivo de agegar más controles
        // en esa sección posteriormente
        JPanel pnlBOTTOM = new JPanel ();
        pnlBOTTOM.add (btnDelete);

        // establecemos las dimensiones iniciales
        setSize (new Dimension(300, 400));
        setLayout (new BorderLayout ()); // y definimos al BorderLayout como layout principal

        // colocamos cada uno de los páneles y controles que corresponden a las secciones,
        // arriba, centro, abajo
        // pnlTOP -> pnlFields + botón ADD
        // table -> JTable para el listado
        // pnlBOTTOM -> botón ELIMINAR
        add (BorderLayout.NORTH, pnlTOP);
        add (BorderLayout.CENTER, table);
        add (BorderLayout.SOUTH, pnlBOTTOM);

        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); // establece el comportamiento de cierre
    }

}
package principal;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Inicio {
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Mi Agenda Telefónica");
		frame.setSize(300, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setLayout(new BorderLayout());
		
		JPanel labels = new JPanel();
		labels.setLayout(new GridLayout(3,2));
		
		JLabel text1 = new JLabel("Nombre:");
		JTextField TxtNombre = new JTextField();
		
		JLabel text2 = new JLabel("Teléfono:");
		JTextField TxtTelefono = new JTextField();
		
		JButton agregar = new JButton("Agregar");
		
		labels.add(text1);
		labels.add(TxtNombre);
		labels.add(text2);
		labels.add(TxtTelefono);
		labels.add(agregar);
		
		JButton borrar = new JButton("Eliminar");
		
		DefaultTableModel modelo = new DefaultTableModel();

		JTable Jtable = new JTable(modelo);
		
		frame.add(BorderLayout.SOUTH,borrar);
		frame.add(BorderLayout.CENTER,Jtable);
		frame.add(BorderLayout.NORTH,labels);
		
		frame.setVisible(true);
		
		modelo.addColumn("Nombre");
		modelo.addColumn("Telefono");
		
		
		
		agregar.addActionListener(e -> {
			String nombre = TxtNombre.getText();
			String telefono = TxtTelefono.getText();
			if(nombre.equals("") || telefono.equals("")) {
				JOptionPane.showMessageDialog(frame,"Faltan campos por acompletar");
				return;
			}
			String[] Contact = { nombre, telefono };
			modelo.addRow(Contact);
			TxtNombre.setText("");
			TxtTelefono.setText("");
		});

		borrar.addActionListener(e ->{
			int[] rows = Jtable.getSelectedRows();
			if(rows.length==0) {
				JOptionPane.showMessageDialog(frame,"Selecciona los contactos a eliminar");
			}
			for(int i=0;i<rows.length;i++){
				modelo.removeRow(rows[i]-i);
			}
		});
		
	}
}

package principal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Principal {
	
	public static void main(String[] args) {
		
		Pattern pattern = Pattern.compile ("\\(\\d{3}\\)\\s{0,1}\\d{7}");
		
		JFrame frame = new JFrame("Mi Agenda Telefónica");
		frame.setSize(300, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setLayout(new BorderLayout());
		
		JPanel labels = new JPanel();
		labels.setLayout(new GridLayout(3,2));
		
		JLabel text1 = new JLabel("Nombre:");
		JTextField TxtNombre = new JTextField();
		TxtNombre.setColumns(13);
		
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
			
			Matcher matcher = pattern.matcher (TxtTelefono.getText());

	        if (matcher.find ()) {
	            TxtTelefono.setBackground(new Color(255,255,255));
	            String[] Contact = { nombre, telefono };
				modelo.addRow(Contact);
				TxtNombre.setText("");
				TxtTelefono.setText("");
	        }else {
	        	TxtTelefono.setBackground(new Color(255,0,0));
	        	JOptionPane.showMessageDialog(frame,"Formato de numero no valido");
	        }
	        
			
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
		
		TxtNombre.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				if(TxtNombre.getText().length()>=13) {
					e.consume();
					JOptionPane.showMessageDialog(frame,"Solo se permiten 13 caracteres");
					return;
				}
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
		});
		
		TxtTelefono.addKeyListener( new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
				if(TxtTelefono.getText().length()>=13) {
					e.consume();
					JOptionPane.showMessageDialog(frame,"Solo se permiten 13 caracteres");
					return;
				}
				if( (!((e.getKeyChar( ) >= '0' && e.getKeyChar( ) <='9') 
						|| e.getKeyChar( ) == '(' || e.getKeyChar( ) == ')' || e.getKeyChar( ) == ' '))
						||(e.getKeyChar( ) == '(' 
						&& TxtTelefono.getText().contains( "(" )) 
						||(e.getKeyChar( ) == ')' 
						&& TxtTelefono.getText().contains( ")" ))
						||(e.getKeyChar( ) == ' '
						&& TxtTelefono.getText().contains( " " ))
						) 
					{
						e.consume ();                
					}
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				Matcher matcher = pattern.matcher (TxtTelefono.getText());

		        if (matcher.find ()) {
		            System.out.println (matcher.group ());
		            TxtTelefono.setBackground(new Color(255,255,255));
		        }else {
		        	TxtTelefono.setBackground(new Color(255,0,0));
		        }
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
		});
		
	}
}

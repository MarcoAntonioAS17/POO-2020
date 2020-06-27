package principal;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Ventana extends JFrame {
    

	private static final long serialVersionUID = 1L;

	public Ventana() {
		setTitle ("Lector URL"); 
	    setSize (800, 600); 
	    setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); // operación predeterminada al cierre de la ventana

	    setLayout(new BorderLayout());
	    
	    

	    setVisible (true);
	   

	}
	
}
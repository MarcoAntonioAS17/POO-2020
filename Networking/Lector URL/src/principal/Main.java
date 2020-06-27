package principal;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.io.InputStream;

@SuppressWarnings("serial")
public class Main extends JFrame{
	
	
	JPanel  PInferior;
	ImagePanel PSuper;
	public Main() throws IOException {
		setTitle("Lector URL");
		setSize(700, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new GridLayout(2,1));
		
		CargarImagen();
		CargarTexto();
		
		setVisible(true);
	}
	
	public void CargarTexto() throws IOException {
		PInferior = new JPanel();
		JTextArea texto = new JTextArea();
		texto.setFont(new Font("Verdana",Font.BOLD , 12));
		texto.setLineWrap(true);
		
		JScrollPane scroll = new JScrollPane(texto);
		
		 URL loremURL = new URL ("https://tinyurl.com/yxoaw447");
		 URLConnection urlConn = loremURL.openConnection ();
		 HttpURLConnection httpUrlConn = (HttpURLConnection) urlConn;
		 httpUrlConn.connect ();
		 
		 if (httpUrlConn.getResponseCode () == HttpURLConnection.HTTP_OK) {
			 InputStream in = httpUrlConn.getInputStream ();
			 InputStreamReader inputStreamReader = new InputStreamReader (in, "utf-8");
			 BufferedReader buffReader = new BufferedReader (inputStreamReader); 

            
			 String line;
			StringBuilder builder = new StringBuilder ();
			while ((line = buffReader.readLine ()) != null) {
			    builder.append (line); 
			    builder.append ("\n");
			}
			
			in.close (); 
			texto.setText (builder.toString ());
		 }
		
		add(scroll);
	}
	
	public void CargarImagen() throws IOException {
		
		URL url = new URL("https://www.uv.mx/cuo/files/2013/01/Imagenes_norte.png");
		
		
		BufferedImage c = ImageIO.read(url);
		ImageIcon imageico = new ImageIcon(c);
		
		PSuper = new ImagePanel(imageico.getImage());
		
		add(PSuper);
	}
	
	public static void main(String[] args) {
		
		try {
			@SuppressWarnings("unused")
			Main m = new Main ();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

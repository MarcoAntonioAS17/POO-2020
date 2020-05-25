package mx.uv.fiee.iinf.poo.swingwithlayouts;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Se muestra la creación de diferentes ventanas cada
 * utilizando un layout distinto.
 *
 * Pueden observar como al usarse layouts, los controles son agregados al layout
 * que se encarga de organizarlos, dependiendo de su estructura.
 *
 * Al usar un layout, la ventana puede ser redimensionada y los controles
 * el layout se adaptará a la nueva dimensión.
 */
public class Main {

    public static void main (String [] args) {
        JFrame frame = new JFrame ("Flow Layout");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.setSize (800, 200);
        
        frame.setLayout (new FlowLayout (FlowLayout.CENTER, 20, 20));
        
        JButton btnBorder = new JButton ("BorderLayout");
        btnBorder.setPreferredSize (new Dimension (200, 80));
        btnBorder.addActionListener (e -> { new Border (); });
        
        JButton btnGrid = new JButton ("GridLayout");
        btnGrid.addActionListener (e -> { new Grid (); });
        
        JButton btnGridBag = new JButton ("GridBagLayout");
        btnGridBag.addActionListener (e -> { new GridBag (); });
        
        JButton btnBox = new JButton ("BoxLayout");
        btnBox.addActionListener (e -> { new Box (); });
        
        JButton btnChat = new JButton ("Chat Window");
        btnChat.addActionListener (e -> { new Chat (); });
        
        frame.add (btnBorder);
        frame.add (btnGrid);
        frame.add (btnGridBag);
        frame.add (btnBox);
        frame.add (btnChat);
        
        frame.pack ();
        
        frame.setVisible (true);
    }
}

/**
 * Muestra el funcionamiento del layout tipo Border,
 * que "enpaca" los controles mediante posiciones norte,
 * sur, este, oeste y centro.
 */
class Border extends JFrame {
    
    public Border () {
        setTitle ("Border Layout");
        setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
        setSize (400, 300);
        setLayout (new BorderLayout ()); // establece un nuevo objeto BorderLayout, como layout
        //predeterminado
        
        JButton btnNorth = new JButton ("Button 1 (NORTH)");
        JButton btnEast = new JButton ("Button 2 (EAST)");
        JButton btnCenter = new JButton ("Button 3 (CENTER)");
        JButton btnWest = new JButton ("Button 4 (WEST)");
        JButton btnSouth = new JButton ("Button 1 (SOUTH)");

        // al momento de añadir el control al JFrame, se debe indicar la posición cardinal donde ubicarlo
        add (BorderLayout.NORTH, btnNorth);
        add (BorderLayout.EAST, btnEast);
        add (BorderLayout.CENTER, btnCenter);
        add (BorderLayout.WEST, btnWest);
        add (BorderLayout.SOUTH, btnSouth);
        
        setVisible (true);
    }
}

/**
 * Muestra el funcionamiento del layout tipo rejilla.
 * Este control define su estructura mediante filas y columnas
 * organinzado cada control dentro de una ubicación (fila, columna) específica.
 * Pero podemos pensar en su organización en forma de lineal.
  */
class Grid extends JFrame {
    
    public Grid () {
        setTitle ("Grid Layout");
        setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
        setSize (400, 300);
        setLayout (new GridLayout (3, 2)); //define al layout predeterminado
        //del tipo GridLayout de 3 fila y dos columnas
        
        JButton btnOne = new JButton ("One");
        JButton btnTwo = new JButton ("Two");
        JButton btnThree = new JButton ("Three");
        JButton btnFour = new JButton ("Four");
        JButton btnFive = new JButton ("Five");

        // al añadir los controles, estos se organizan linealmente
        add (btnOne); //uno después de otro
        add (btnTwo);
        add (btnThree);
        add (btnFour);
        add (btnFive);
       
        setVisible (true);
    }
}

/**
 * GridBag layout, se comporta de forma similar al GridLayout
 * con la diferencia que que la rejilla es dinámica y creada a demanda
 * mediante restricciones.
 *
 * Las restricciones son asignadas mediante un objeto GridBagConstraint
 */
class GridBag extends JFrame {
    
    public GridBag () {
        setTitle ("GridBag Layout");
        setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
        setSize (400, 300);
        setLayout (new GridBagLayout ());
        
        GridBagConstraints cons = new GridBagConstraints ();
        
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 0;
        add (new JButton ("One"), cons);
        
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 1;
        cons.gridy = 0;
        add (new JButton ("Two"), cons);
        
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipady = 50;
        cons.gridx = 0;
        cons.gridy = 1;
        add (new JButton ("Three"), cons);
        
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.ipadx = 30;
        cons.gridx = 1;
        cons.gridy = 1;
        add (new JButton ("Four"), cons);
        
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.gridx = 0;
        cons.gridy = 2;
        cons.gridwidth = 2;
        add (new JButton ("Five"), cons);        
        
        setVisible (true);
    }
}

/**
 *
 */
class Box extends JFrame {
    
    public Box () {
        setTitle ("Box Layout");
        setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
        setSize (400, 150);
        
        // Botones con tamaño predeterminado
        JButton btnOne = new JButton ("One *");
        btnOne.setPreferredSize(new Dimension (100, 50));
        JButton btnTwo = new JButton ("Two ***");
        JButton btnThree = new JButton ("Three *");
        btnThree.setPreferredSize (new Dimension (100, 50));
        JButton btnFour = new JButton ("Four ***");
        JButton btnFive = new JButton ("Five *");
        btnFive.setPreferredSize(new Dimension (100, 50));
        JButton btnSix = new JButton ("Six ***");
        
        // contenedores, centrol, izquierdo y derecho
        JPanel pnlLeft = new JPanel ();
        JPanel pnlCenter = new JPanel ();
        JPanel pnlRight = new JPanel ();

        // asignamos un título a cada contenedor (panel)
        pnlLeft.setBorder (BorderFactory.createTitledBorder ("LEFT"));
        pnlCenter.setBorder (BorderFactory.createTitledBorder ("CENTER"));
        pnlRight.setBorder (BorderFactory.createTitledBorder ("RIGHT"));
        
        // asigna un boxlayout a cada panel utilizando alineamiento vertical
        BoxLayout boxLayoutLeft = new BoxLayout (pnlLeft, BoxLayout.Y_AXIS);
        BoxLayout boxLayoutCenter = new BoxLayout (pnlCenter, BoxLayout.Y_AXIS);
        BoxLayout boxLayoutRight = new BoxLayout (pnlRight, BoxLayout.Y_AXIS);
        
        //asignmos cada boxlayout al panel correspondiente
        pnlLeft.setLayout (boxLayoutLeft);
        pnlCenter.setLayout (boxLayoutCenter);
        pnlRight.setLayout (boxLayoutRight);
        
        //agrega dos botones al panel izquierdo, alineándolos a la izquierda del contenedor
        btnOne.setAlignmentX (Component.LEFT_ALIGNMENT);
        btnTwo.setAlignmentX (Component.LEFT_ALIGNMENT);
        pnlLeft.add (btnOne);
        pnlLeft.add (btnTwo);
        
        //agrega dos botones al panel central, alineándolos al centro del contenedor
        btnThree.setAlignmentX (Component.CENTER_ALIGNMENT);
        btnFour.setAlignmentX (Component.CENTER_ALIGNMENT);
        pnlCenter.add (btnThree);
        pnlCenter.add (btnFour);
        
        //agrega dos botones al panel derecho, alineándolos a la derecha del contenedor
        btnFive.setAlignmentX (Component.RIGHT_ALIGNMENT);
        btnSix.setAlignmentX (Component.RIGHT_ALIGNMENT);
        pnlRight.add (btnFive);
        pnlRight.add (btnSix);
        
        //para colocar los 3 paneles utilizamos otro contenedor, flowlayout en este caso
        setLayout (new FlowLayout ());
        add (pnlLeft);
        add (pnlCenter);
        add (pnlRight);
        
        setVisible (true);
    }
    
}

/**
 * Muestra como crear una interfaz más compleja, tipo chat, con cuadros de texto
 * menus, botones, etc.
 */
class Chat extends JFrame {
    
    public Chat () {
        setTitle ("Chat Window");
        setDefaultCloseOperation (JFrame.DISPOSE_ON_CLOSE);
        setSize (450, 400);
        
        JMenuBar menuBar = new JMenuBar ();
        
        //Menu section
        JMenu mnuFile = new JMenu ("File");
        JMenuItem itemOpen = new JMenuItem ("Open");
        JMenuItem itemSave = new JMenuItem ("Save as");
        mnuFile.add (itemOpen);
        mnuFile.add (itemSave);
        
        JMenu mnuHelp = new JMenu ("Help");
        
        menuBar.add (mnuFile);
        menuBar.add (mnuHelp);
        
        //center textarea
        JTextArea chat = new JTextArea ();
        
        //bottom section
        JPanel panel = new JPanel ();
        panel.setLayout (new FlowLayout ());
        
        JLabel lblSend = new JLabel ("Text");
        JTextField tfSend = new JTextField (20);
        JButton btnSend = new JButton ("Send");
        JButton btnReset = new JButton ("Reset");
        
        panel.add (lblSend);
        panel.add (tfSend);
        panel.add (btnSend);
        panel.add (btnReset);
        
        setLayout (new BorderLayout ());
        
        add (BorderLayout.NORTH, menuBar);
        add (BorderLayout.CENTER, chat);
        add (BorderLayout.SOUTH, panel);
       
        setVisible (true);
    }
    
}
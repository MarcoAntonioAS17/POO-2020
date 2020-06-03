package mx.uv.fiee.iinf.poo.mytextfield;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

/**
 * Clase que extiende a JTextField para añadir la funcionalidad de filtrado de texto.
 *
 * Cada vez que se pulsa un tecla dentro del componente, se realiza la verificación
 * sobre el caracter que está siendo ingresado, si no se trata de alguna número o un punto decimal
 * no se permite su entrada.
 *
 */
public class MyTextField extends JTextField {
    
    public MyTextField () {
        /**
         * El método addKeyListener agrega un manejador para el evento de tecleo dentro del JTextField
         *
         * Espera recibir un objeto que implemente a la interfaz KeyListener.
         * Aquí hacemos uso de un objeto anónimo.
         *
         * El objeto que se encargará de manejar al evento de tecleo define 3 métodos.
         */
        this.addKeyListener (new KeyListener () {
            /**
             * El evento keyTyped es generado cuando se produce el evento completo de teclear, esto es,
             * oprimir y librear una tecla.
             *
             * Cuando tal evento se produce este método es invocado con información de la tecla presionada.
             *
             * @param e objeto KeyEvent con información específica de la tecla, entre ella, su representación unicode.
             */
            @Override
            public void keyTyped(KeyEvent e) {
                // como solo permiten números y punto decimal, la validación es la siguiente.
                //
                // primero se verifica si el carácter NO pertenece al intervalo del 0 al 9 o si el caracter NO es un punto decimal
                // después, valida el caso en que el carácter SI es un punto decimal, para entonces verificar
                // si en el cuadro de texto ya existe alguno
                //
                if ((!((e.getKeyChar() >= '0' && e.getKeyChar() <= '9') || e.getKeyChar() == '.')) ||
                        (e.getKeyChar() == '.' && MyTextField.this.getText().contains("."))) {

                    // si cualquiera de las condiciones es verdadera, se invoca al método consume
                    e.consume (); // que le indica al sistema que la tecla fue procesada y puede olvidarse de ella

                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    /**
     * Sobre escribimos al método paint del componente para modificar el dibujado del mismo
     *
     * Simplemente utilizamos al sistema de gráficos para agregar una figura geométrica al final del componente
     *
     * @param g parámetro proporcionado por el sistema con la referencia al sistema gráfico de la plataforma
     *          mediante el cúal podemos realizar operaciones de dibujado en las ventanas y componentes.
     */
    @Override
    public void paint (Graphics g) {
        super.paint (g); // se recomienda llamar de inmediato al método paint de la clase padre para
                        // permitir al componente dibujarse antes de realizar las modificaciones,
                        // si se omite este llamado el control que estams heredando no se mostraría


        g.setColor (Color.red); // establecemos el color de la paleta
        // invocamos al método fillRect para dibujar un rectángulo
        g.fillRect (this.getWidth () - 20, 5,15, 15);
    }
}

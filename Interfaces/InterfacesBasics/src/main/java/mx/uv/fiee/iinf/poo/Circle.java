package mx.uv.fiee.iinf.poo;

/**
 * Representa un objeto circulo que implementa las interfaces Draw y Shape
 * por lo tanto, está oblidada a implementar los métodos que estas definen
 *
 * La interfaz clonable no define un método propio, en su lagar utiliza la
 * función definida en la clase base (Object) para realizar la copia.
 * Dicha operación es realizada mediante código nativo a la plataforma,
 * con el objetivo de realizala lo más rápido posible, pero principalmente
 * debido a que debe acceder directamente a la memoria para copiar byte a byte
 * al objeto en cuestión.
 *
 */
class Circle implements Draw, Shape, Cloneable {
    int x, y;
    int radio;

    public Circle (int x, int y, int radio) {
        this.x = x;
        this.y = y;
        this.radio = radio;
    }

    /***
     * Sobreescribe los métodos definidos en la interfaz Draw
     */
    @Override
    public void paint () {
        System.out.println ("Círculo dibujado con centro en (" + this.x + ", " + this.y + ") y radio de " + this.radio);
    }

    @Override
    public void fill () {
        System.out.println ("Círculo coloreado!");
    }
    /****/

    /**
     * Sobreescribe al método definido en la interfaz Shape
     */
    @Override
    public void calculateArea () {
        double area = Math.PI * Math.sqrt (radio);
        System.out.println ("El área del círculo es " + area);
    }

    /**
     * invoca a la función clone de la clase base, delegando la operación de copia
     * @return Un objeto con el mismo estado (valores de los campos) del objeto copiado.
     * @throws CloneNotSupportedException si la clase donde se invoca no implementa la interfaz Clonable
     */
    @Override
    protected Object clone () throws CloneNotSupportedException {
        return super.clone ();
    }
}
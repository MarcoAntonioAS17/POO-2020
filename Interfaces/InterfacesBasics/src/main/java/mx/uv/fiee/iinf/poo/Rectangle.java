package mx.uv.fiee.iinf.poo;

/**
 * Representa un objeto rectangulo que implementa las interfaces Draw y Shape
 * por lo tanto, está oblidada a implementar los métodos que estas definen.
 *
 * La interfaz clonable no define un método propio, en su lagar utiliza la
 * función definida en la clase base (Object) para realizar la copia.
 * Dicha operación es realizada mediante código nativo a la plataforma,
 * con el objetivo de realizala lo más rápido posible, pero principalmente
 * debido a que debe acceder directamente a la memoria para copiar byte a byte
 * al objeto en cuestión.
 * 
 */
class Rectangle implements Draw, Shape, Cloneable {
    int x1, y1, x2, y2;

    public Rectangle (int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    /***
     * Sobreescribe los métodos definidos en la interfaz Draw
     */
    @Override
    public void paint () {
        String m = String.format ("Dibujando el rectangulo desde el punto (%d, %d) al punto (%d, %d)", x1, y1, x2, y2);
        System.out.println (m);
    }

    @Override
    public void fill () {
        System.out.println ("Rectángulo coloreado!");
    }
    /******/

    /**
     * Sobreescribe al método definido en la interfaz Shape
     */
    @Override
    public void calculateArea () {
        int base = x2 - x1;
        int altura = y2 - y1;
        double area = base * altura;
        System.out.println ("El área del rectángulo es " + area);
    }

    /**
     * invoca a la función clone de la clase base, delegando la operación de copia
     * @return Un objeto con el mismo estado (valores de los campos) del objeto copiado.
     * @throws CloneNotSupportedException si la clase donde se invoca no implementa la interfaz Clonable
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
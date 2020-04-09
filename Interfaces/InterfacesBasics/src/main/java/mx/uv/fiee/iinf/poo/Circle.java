package mx.uv.fiee.iinf.poo;

class Circle implements Draw, Shape {
    int x, y;
    int radio;

    public Circle (int x, int y, int radio) {
        this.x = x;
        this.y = y;
        this.radio = radio;
    }

    @Override
    public void paint() {
        System.out.println ("Circle drawn in (" + this.x + ", " + this.y + ") with radius " + this.radio);
    }

    @Override
    public void fill() {
        System.out.println ("Circle filled");
    }

    @Override
    public void calculateArea() {
        double area = Math.PI * Math.sqrt (radio);
        System.out.println ("Circle area is " + area);
    }
}
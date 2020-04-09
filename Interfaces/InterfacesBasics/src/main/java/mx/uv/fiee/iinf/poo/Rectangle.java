package mx.uv.fiee.iinf.poo;

class Rectangle implements Draw, Shape {
    int x1, y1, x2, y2;

    public Rectangle (int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void paint () {
        String m = String.format ("Painting rectangle from Point 1 (%d, %d) to Point 2 (%d, %d)", x1, y1, x2, y2);
        System.out.println (m);
    }

    @Override
    public void fill () {
        System.out.println ("Rectangle filled!");
    }

    @Override
    public void calculateArea () {
        int sideA = x2 - x1;
        int sideB = y2 - y1;
        double area = sideA * sideB;
        System.out.println ("Rectangle area is " + area);
    }
}
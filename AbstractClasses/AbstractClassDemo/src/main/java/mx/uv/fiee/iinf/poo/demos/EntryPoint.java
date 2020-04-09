package mx.uv.fiee.iinf.poo.demos;


public class EntryPoint {

    public static void main (String [] args) {
        Profesor p = new ProfesorTitular ("Diana", "Montejo", 30);
        System.out.println (p.toString ());

        Profesor p1 = new Profesor () {
            @Override
            public double importeNomina() {
                return 100;
            }
        };

        Profesor p2 = () -> { return 100; };
    }
    
}

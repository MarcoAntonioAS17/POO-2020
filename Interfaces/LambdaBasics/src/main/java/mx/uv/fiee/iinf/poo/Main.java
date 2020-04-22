package mx.uv.fiee.iinf.poo;

interface MyMathLib {
    long pow (int exponent, int base);
}

/*class MyMathClient implements MyMathLib {

    @Override
    public long pow (int exponent, int base) {
        System.out.printf ("Raising %d, %d exponent times - Inside MyMathClient Object\n", base, exponent);
        return 0;
    }

}*/

class Main {

    public static void main (String [] args) {
        /*MyMathClient client1 = new MyMathClient ();
        execute (client1);

        MyMathLib client2 = new MyMathClient ();
        execute (client2);

        MyMathLib client3 = new MyMathLib () {
            @Override
            public long pow(int exponent, int base) {
                System.out.printf ("Raising %d, %d exponent times - Inside Anonymous Object\n", base, exponent);
                return 0;
            }
        };
        execute (client3);*/

        execute ( (exponent, base) -> {
            System.out.printf ("Raising %d, %d exponent times - Inside Lambda expression\n", base, exponent);
            return 0;
        } );

        MyMathLib mm = (exponent, base) -> {
            System.out.printf ("Raising %d, %d exponent times - Inside Lambda Anonymous\n", base, exponent);
            return 0;
        };
        execute (mm);

    }

    static void execute (MyMathLib client) {
        client.pow (2, 10);
    }
}
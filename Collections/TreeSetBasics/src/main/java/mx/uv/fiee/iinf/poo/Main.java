package mx.uv.fiee.iinf.poo;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
//        TreeSet<Employee> employees = new TreeSet<> (/*new MyComparator ()*/);
//
//        employees.add (new Employee("Lea", 3000.0));
//        employees.add(new Employee("Skywalker", 6000.0));
//        employees.add(new Employee("Solo", 2000.0));
//        employees.add(new Employee("Vader", 2400.0));
//
//        for (Employee e: employees) {
//            System.out.println (e);
//        }

        //usando una expresión lambda
        TreeSet<String> treeString = new TreeSet <>((s1, s2) -> {
            return s1.compareTo (s2);
        });

        treeString.add ("Anakin");
        treeString.add ("r2d2");
        treeString.add ("c3po");
        treeString.add ("bb8");

        for (String s: treeString) {
            System.out.println (s);
        }

        for (Iterator<String> i = treeString.iterator (); i.hasNext ();) {
            System.out.println (i.next ());
        }

//        TreeSet<String> t = new TreeSet<> ();
//
//        t.add ("one");
//        t.add ("two");
//        t.add ("three");
//        t.add ("four");
//
//        for (String e : t) {
//            System.out.println( e);
//        }
//
//
//        System.out.printf ("\nReverting order...\n");
//
//        for (Iterator<String> i = t.descendingIterator (); i.hasNext ();) {
//            System.out.println (i.next ());
//        }
    }

}


class MyComparator implements Comparator<Employee> {

    @Override
    public int compare (Employee o1, Employee o2) {
        return o1.getName().compareTo (o2.getName ());
    }

}

/***
 *
 * @author Gonzalo
 */
class Employee /*implements Comparable<Employee>*/ {

    private String name;
    private Double payment;

    public Employee(String name, Double payment) {
        this.name = name;
        this.payment = payment;
    }

    public String getName() {
        return name;
    }

    public Double getPayment() {
        return this.payment;
    }

//    @Override
//    public int compareTo (Employee o) {
//        if (this.payment > o.getPayment ()) {
//            return 1;
//        } else if (o.getPayment () > this.payment) {
//            return -1;
//        }
//
//        return 0;
//    }

    public String toString () {
        return this.name + " has a payment of " + this.payment;
    }
}
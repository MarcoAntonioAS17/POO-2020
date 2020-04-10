package mx.uv.fiee.iinf.poo;

public class Student implements Comparable<Student> {
    private String name;
    private int age;

    public Student (String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo (Student o) {
        int foo = 0;

        if (this.age > o.age) {
            foo = 1;
        }

        if (this.age < o.age) {
            foo = -1;
        }

        return foo;
    }

    @Override
    public String toString () {
        return "Student {" +
                "name='" + name + '\'' +
                ", age=" + age +
                " }";
    }
}
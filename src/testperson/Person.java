package testperson;

/**
 * @Authur: Ê¯½¨À×
 * @Date:2019/1/7
 */

public class Person {
    public Person() {
        func();
    }
    public void func() {
        System.out.println("1");
    }
}

class Person_A extends Person {

    public Person_A() {
        super();
    }

    public Person_A(int a) {
        System.out.println(a);

    }

    public void func() {

        System.out.println("2");
    }

    public static void main(String[] args) {
        Person_A person_a = new Person_A();
        Person_A person_b = new Person_A(3);

    }
}
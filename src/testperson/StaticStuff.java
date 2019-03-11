package testperson;

/**
 * @Authur: Ê¯½¨À×
 * @Date:2019/1/7
 */

public class StaticStuff {
    static int x;

    static {

        System.out.println("X1=" + x);
        x += 5;
    }

    public static void main(String[] args) {
        System.out.println("x2=" + x);

    }

    static {
        System.out.println("x3=" + x);
        x %= 3;
    }
}

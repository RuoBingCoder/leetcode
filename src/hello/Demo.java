package hello;

/**
 * @author : 石建雷
 * @date :2019/1/17
 */

public class Demo {
    public static void main(String[] args) {

        int f = 0;
        int g = 1;
        for (int i = 0; i <= 15; i++) {

            System.out.println(f);

            f = f + g;
            g = f - g;

        }
    }


}

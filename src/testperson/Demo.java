package testperson;

import java.util.Scanner;

/**
 * @author 石建雷
 * @Date:2019/1/7
 */

public class Demo {
    public static void main(String[] args) {
        int i, j, k;
        System.out.println("请输入：");
        Scanner s = new Scanner(System.in);
        int s1 = s.nextInt();
        i = s1 % 10;
        j = ((s1 - i) / 10) % 10;
        k = (((s1 - i) / 10 - j) / 10) % 10;

        if (i * i * i + j * j * j + k * k * k == s1) {

            System.out.println(s1);


        } else {

            System.out.println("请重新输入！");
        }

    }

}

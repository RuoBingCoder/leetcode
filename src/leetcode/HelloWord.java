package leetcode;

/**
 * @author : 石建雷
 * @date :2019/4/30
 */

public class HelloWord {

    public static void main(String[] args) {
        System.out.println("hello word");
        System.out.println("===============================");
        String s = "123";
        String s1 = "123";
        String s2 = new String("123");
        String s3 = new String("123");
        int i = 0;
        int b = i++;
        //此时b=0 i=1
        System.out.println(b);
        b =++i;
//        b=2 i=2
        System.out.println(b);
        b = b + i;
        System.out.println(b);
        System.out.println("===============================");
        System.out.println(s == s2);
        System.out.println("===============================");
        System.out.println(s.equals(s1));
        System.out.println(s2.equals(s3));
        System.out.println(s.replaceFirst("-", ""));
    }
}

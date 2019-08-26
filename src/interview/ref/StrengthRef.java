package interview.ref;

/**
 * @author : 石建雷
 * @date :2019/8/25
 * 强引用不会被回收
 */

public class StrengthRef {

    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = o1;
        o1 = null;
        System.gc();
        System.out.println(o1);
        System.out.println(o2);
    }
}

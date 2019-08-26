package inandoutclass;

/**
 * @author : 石建雷
 * @date :2019/8/4
 * 局部内部类，修饰符没有
 */

public class OuterLocal {

    public void sleep() {
        class Inner {
            public void age() {
                System.out.println("我今年18岁了！");
            }
        }

        Inner inner = new Inner();
        inner.age();
    }

    public static void main(String[] args) {
        OuterLocal local = new OuterLocal();

        local.sleep();
    }
}

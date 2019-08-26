package inandoutclass;

/**
 * @author : 石建雷
 * @date :2019/8/4
 * 成员内部类,内部类的修饰符：可以是public，protected ,private
 */

public class Outer {


    public class Inner {
        public void eat() {
            System.out.println("我正在吃！");
        }
    }

    public static void main(String[] args) {
        Outer.Inner inner=new Outer().new Inner();
        inner.eat();
    }
}


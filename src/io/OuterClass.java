package io;

/**
 * @author : 石建雷
 * @date :2019/8/9
 */

public class OuterClass {

    class Inner {


    }

    public static void foo() {
//        new Inner();
//        Java 中非静态内部类对象的创建要依赖其外部类对象
        new OuterClass().new Inner();
    }

    public void bar() {
        new Inner();
    }

}

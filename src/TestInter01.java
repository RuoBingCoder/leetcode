/**
 * @author : 石建雷
 * @date :2019/8/2
 *
 */
public interface TestInter01 {
    /**
     * 接口中常量名一定要大写，推荐写法
     */
    public static final int NUM = 13;
    /**
     * 接口中可以有默认方法
     */
    default void eat() {
        System.out.println("你吃了吗？");
    }

    /**
     * 接口允许定义静态方法，外部调用的话一定是接口名.方法名，不能通过实现类来调用
     */
    static void dog() {
        System.out.println("I am dog!");
    }
    /**
     * 1.类与类之间是单继承的。直接父类只有一个。
     * 2.类与接口之间是多实现的。一个类可以实现多个接口。
     * 3.接口与接口之间是多继承的。
     * 注意事项：
     * 1？多个父接口当中的抽象方法如果重复，没关系。
     * 2.多个父接口当中的默认方法如果重复，那么子接口必须进行默认方法的覆盖重写，【而且带着default关键字】
     */
}

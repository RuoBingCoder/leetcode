package absdemo;

/**
 * @author : 石建雷
 * @date :2019/8/9
 */

public abstract class AbsMan implements Man {
    @Override
    public void say() {
        System.out.println("我会说话！");
    }

    @Override
    public void sleep() {
        System.out.println("我要睡觉！");
    }
}

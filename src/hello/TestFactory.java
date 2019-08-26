package hello;

/**
 * @author : 石建雷
 * @date :2019/7/26
 * 饿汉式
 */

public class TestFactory {
    private String msg;
    private static TestFactory testFactory = new TestFactory();

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public TestFactory(String msg) {
        this.msg = msg;
    }

    public TestFactory() {
    }

    public static TestFactory getTestFactory(String msg) {
        testFactory.setMsg(msg);
        return testFactory;
    }

    public static void main(String[] args) {
        System.out.println(TestFactory.getTestFactory("haha"));
        System.out.println(TestFactory.getTestFactory("hah"));
    }
}

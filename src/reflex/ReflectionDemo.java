package reflex;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author : 石建雷
 * @date :2019/3/18
 * <p>
 * java反射机制的简单使用
 * 一、JAVA反射的常规使用步骤
 * <p>
 * 反射调用一般分为3个步骤：
 * <p>
 * 得到要调用类的class
 * 得到要调用的类中的方法(Method)
 * 方法调用(invoke)
 */

public class ReflectionDemo {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {


        Test test = new Test("张三", "李四");
        Class aClass = test.getClass();
        Method method = aClass.getDeclaredMethod("test01");
        method.invoke(test);


    }

    static class Test {
        private String name;
        private String address;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }


        public Test(String name, String address) {
            this.name = name;
            this.address = address;
        }


        public Test() {
        }

        public void test01() {

            System.out.println("hello 反射！");
        }

    }
}

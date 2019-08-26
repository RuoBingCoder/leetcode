package reflex;

import java.io.*;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author : 石建雷
 * @date :2019/8/21
 * 反射
 * @SuppressWarnings("all") 压制警告
 */


public class ReflexDemo {



    public static <T> T muit(T val) {

        return val;
    }

    public static int add(int... x) {
        int res = 0;

        for (int i = 0; i < x.length; i++) {
            res += x[i];
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
//        获取class目录下的配置文件
        ClassLoader cls = ReflexDemo.class.getClassLoader();
        InputStream is = cls.getResourceAsStream("reflex/reflex.properties");
        properties.load(is);
        Class clazz;
        String methodName = properties.getProperty("methodName");
        String className = properties.getProperty("className");
//        加载类到内存中
        Class<?> aClass = Class.forName(className);
//        创建对象
        Object o = aClass.newInstance();
//        获取方法
        Method method = aClass.getMethod(methodName);
//调用方法
        method.invoke(o);

        int res = add(1, 2, 3, 5);
        System.out.println(res);
        System.out.println(muit("张三"));


    }
}

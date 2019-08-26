package io.chuanzhiboke;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/**
 * @author : 石建雷
 * @date :2019/8/16
 */

public class PropertiesDemo {

    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
//2.使用Properties集合对象中的方法Load读取保存键值对的文件
        properties.load(new FileReader("F:\\java-code\\workspace\\JAVA_SE\\src\\io\\chuanzhiboke\\b.txt"));

        Set<String> set = properties.stringPropertyNames();
        for (String key : set) {
            String value = properties.getProperty(key);
            System.out.println(key + "=" + value);
        }
    }
}

package io.chuanzhiboke;

import java.io.FileReader;
import java.io.IOException;

/**
 * @author : 石建雷
 * @date :2019/8/16
 */

public class FileReaderDemo {

    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("F:\\java-code\\workspace\\JAVA_SE\\src\\io\\chuanzhiboke\\a.txt");

        char[] chars = new char[1024];
//        一定要有len
        int len = 0;
        while ((len = reader.read(chars)) != -1) {
            System.out.println(new String(chars, 0, len));

        }
        reader.close();

//       扩展知识点
        char[] ch = {'a', 'b', 'c', 'd'};
        String str = new String(ch, 0, 2);
        System.out.println(str);

    }
}

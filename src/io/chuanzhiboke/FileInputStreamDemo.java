package io.chuanzhiboke;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author : 石建雷
 * @date :2019/8/16
 */

public class FileInputStreamDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("F:\\java-code\\workspace\\JAVA_SE\\src\\io\\chuanzhiboke\\a.txt");
        FileOutputStream outputStream = new FileOutputStream("F:\\java-code\\workspace\\JAVA_SE\\src\\io\\chuanzhiboke\\b.txt");
        byte[] bt = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(bt)) != -1) {
            outputStream.write(bt, 0, len);
        }
        outputStream.close();
        inputStream.close();
    }
}

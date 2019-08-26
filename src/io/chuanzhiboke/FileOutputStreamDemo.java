package io.chuanzhiboke;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author : 石建雷
 * @date :2019/8/14
 */

public class FileOutputStreamDemo {
    public static void main(String[] args) throws IOException {

        System.out.println(File.pathSeparator);
//        文件目录 “\”
        System.out.println(File.separator);

        File parent = new File("F:\\java-code\\workspace\\JAVA_SE\\src\\io\\chuanzhiboke\\FileOutputStreamDemo.java");
//        打印
        System.out.println(parent.getName());

        File parent2 = new File("F:\\java-code\\workspace\\JAVA_SE\\src\\io\\chuanzhiboke\\", "a.txt");
//        F:\java-code\workspace\JAVA_SE\src\io\chuanzhiboke\FileOutputStreamDemo.java\a.txt
        System.out.println(parent2.getAbsolutePath());

        File parent3 = new File("F:\\java-code\\workspace\\JAVA_SE\\src\\io\\chuanzhiboke\\FileOutputStreamDemo.java");
        File file = new File(parent3, "a.txt");
        //        F:\java-code\workspace\JAVA_SE\src\io\chuanzhiboke\FileOutputStreamDemo.java\a.txt

        System.out.println(file.getAbsolutePath());
        File parent4 = new File("F:\\java-code\\workspace\\JAVA_SE\\src\\io\\chuanzhiboke\\a.txt");
        System.out.println(parent4.length());


        System.out.println("==============文件追加写======================");
        FileOutputStream outputStream = new java.io.FileOutputStream("F:\\java-code\\workspace\\JAVA_SE\\src\\io\\chuanzhiboke\\a.txt", true);
//      你好
        outputStream.write("你好".getBytes());

        System.out.println("==========换行=============");
        for (int i = 0; i < 10; i++) {
            outputStream.write("我是".getBytes());
            outputStream.write("\r\n".getBytes());

        }
        outputStream.close();


    }
}

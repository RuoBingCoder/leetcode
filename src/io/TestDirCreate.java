package io;

import java.io.File;

/**
 * @author : 石建雷
 * @date :2019/2/20
 * 创建目录
 */

public class TestDirCreate {
    public static void main(String[] args) {
        File dir = new File("F:/java-code/workspce/JAVA_SE/src/io");

        Boolean flag = dir.mkdirs();
        // mkdirs()创建一个不存在的目录 mkdir()创建一个存在目录下的子目录
        System.out.println(flag);

        // 上级目录
        String[] contents = dir.list();
        for (String str :
                contents) {
            System.out.println(str);
            /**
             * dir
             * TestDirCreate.java
             * TestIoOne.java
             */
        }

//        获取下一级目录
        File[] file = dir.listFiles();
        for (File str1 :
                file) {
            System.out.println(str1);
            /**
             *F:\java-code\workspce\JAVA_SE\src\io\dir
             *F:\java-code\workspce\JAVA_SE\src\io\TestDirCreate.java
             *F:\java-code\workspce\JAVA_SE\src\io\TestIoOne.java
             */
        }
    }
}

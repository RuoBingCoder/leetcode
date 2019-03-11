package io;

import java.io.*;

/**
 * @author : 石建雷
 * @date :2019/3/3
 * io字符写入操作
 */

public class IoCharInputStreamTest {
    public static void main(String[] args) throws IOException {
        String path = "F:/java-code/workspace/JAVA_SE/src/file.txt";
        File file = new File(path);
        Reader reader = null;
        try {
            reader = new FileReader(file);
            //读取字符写读入

            char[] chars = new char[1024];
            int temp = -1;
            while ((temp = reader.read(chars)) != -1) {
                String str = new String(chars);
                System.out.println(str);

            }

        } catch (FileNotFoundException e1) {
            e1.printStackTrace();

        } finally {
            if (null != reader) {
                reader.close();
            }
        }
    }
}

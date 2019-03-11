package io;

import java.io.*;

/**
 * @author : 石建雷
 * @date :2019/3/3
 * io字符写入操作
 */

public class IoCharOutputStreamTest {
    public static void main(String[] args) throws IOException {
        String path = "F:/java-code/workspace/JAVA_SE/src/file.txt";
        File file = new File(path);
        Writer writer = null;
        try {
            writer = new FileWriter(file);
            //读取字符写入
            String str = "中国第一大国！";

            writer.write(str);
            writer.flush();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();

        } finally {
            if (null != writer) {
                writer.close();
            }
        }
    }
}

package io;

import java.io.*;

/**
 * @author : 石建雷
 * @date :2019/3/1
 * io流操作
 */

public class IoTest01 {

    public static void main(String[] args) {
        File file = new File("F:/java-code/workspace/JAVA_SE/src/file.txt");
        InputStream stream = null;
        try {
            stream = new FileInputStream(file);
            int temp;
            while ((temp = stream.read()) != -1) {
                System.out.println((char) temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != stream) {
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author : 石建雷
 * @date :2019/3/1
 * io流操作,分段读取
 */

public class IoTest02 {

    public static void main(String[] args) {
        String path = "F:/java-code/workspace/JAVA_SE/src/file.txt";
        File file = new File(path);
        InputStream stream = null;
        try {
            stream = new FileInputStream(file);
            byte[] bytes = new byte[1024];
            int len = -1;
            while ((len = stream.read(bytes)) != -1) {
                String s = new String(bytes, 0, len);
                System.out.println(s);

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

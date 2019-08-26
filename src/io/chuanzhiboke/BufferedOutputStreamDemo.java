package io.chuanzhiboke;

import java.io.*;

/**
 * @author : 石建雷
 * @date :2019/8/16
 */

public class BufferedOutputStreamDemo {

    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("F:\\java-code\\workspace\\JAVA_SE\\src\\io\\chuanzhiboke\\b.txt");
        BufferedOutputStream bof = new BufferedOutputStream(fos);
        bof.write("这是bufferedOutputStream".getBytes());
        bof.flush();
        bof.close();
    }
}

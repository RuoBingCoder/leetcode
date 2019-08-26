package io.chuanzhiboke;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author : 石建雷
 * @date :2019/8/16
 */

public class BufferedWriteDemo {
    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("F:\\java-code\\workspace\\JAVA_SE\\src\\io\\chuanzhiboke\\c.txt"));
        for (int i = 0; i < 10; i++) {
            bufferedWriter.write("buffered Writer");
            //新增换行
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }
}

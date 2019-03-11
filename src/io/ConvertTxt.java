package io;

import java.io.*;
import java.net.URL;

/**
 * @author : 石建雷
 * @date :2019/3/11
 * 字符与字节转化
 * 转换流: InputStreamReader OutputStreamWriter
 * 1、以字符流的形式操作字节流（纯文本的）
 * 2、指定字符集
 */

public class ConvertTxt {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new URL("http://www.baidu.com").openStream()
                        , "UTF-8"));
             BufferedWriter writer = new BufferedWriter(
                     new OutputStreamWriter(
                             new FileOutputStream("baidu.html"), "utf-8"));
//读取


        ) {
            String msg;
            while ((msg = reader.readLine()) != null) {
//                System.out.print(msg);
                writer.write(msg);
                writer.newLine();

            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package io;

import java.io.*;

/**
 * 1.封装拷贝
 * 2.封装释放
 *
 * @author : 石建雷
 * @date :2019/3/3
 */

public class FileUtils {
    public static void main(String[] args) {
        String path = "F:/java-code/workspace/JAVA_SE/src/file.txt";
        String path2 = "F:/java-code/workspace/JAVA_SE/src/ipad.jpg";
        //文件到文件
        try {
            InputStream is = new FileInputStream(path);
            OutputStream os = new FileOutputStream("abc-copy.txt");
            copy(is,os);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //文件到字节数组
        byte[] datas = null;
        try {
            InputStream is = new FileInputStream(path2);
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            copy(is,os);
            datas = os.toByteArray();
            System.out.println(datas.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //字节数组到文件
        try {
            InputStream is = new ByteArrayInputStream(datas);
            OutputStream os = new FileOutputStream("p-copy.jpg");
            copy(is,os);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 对接输入输出流
     *
     * @param is
     * @param os
     */
    public static void copy(InputStream is, OutputStream os) {
        byte[] bytes = new byte[1024];
        int len = -1;
        try {
            while ((len = is.read(bytes)) != -1) {

                os.write(bytes, 0, bytes.length);
            }
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void close(InputStream is, OutputStream os) {

        try {
            if (null != os) {
                os.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            if (null != is) {
                is.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




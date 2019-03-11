package io;

import java.io.*;

/**
 * @author : 石建雷
 * @date :2019/3/1
 * io流操作,输出流操作
 */

public class IoTestOutStream {

    public static void main(String[] args) throws IOException {
        String path = "F:/java-code/workspace/JAVA_SE/src/file.txt";
        File file = new File(path);
        OutputStream stream = null;
        try {
            stream = new FileOutputStream(file, true);
//            如果加了true，则再次添加数据就会在文本吗末尾添加数据，false则是从头开始添加覆盖原来的数据
            String str = "i am is a student!";
            byte[] datas = str.getBytes();
            stream.write(datas, 0, datas.length);
            stream.flush();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();

        } finally {
            if (null != stream) {
                stream.close();
            }
        }
    }
}

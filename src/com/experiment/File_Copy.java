package com.experiment;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/*
 * @author:石建雷
 * @data: 2018.11.7
 *
 */
public class File_Copy {

    public static void main(String[] args) throws Exception {

        FileInputStream inputStream = new FileInputStream("H:/7、网页图/1.jpg");

        FileOutputStream outputStream = new FileOutputStream("H:/7、网页图/output/2.jpg");

        byte[] b = new byte[1024];
        int length = 0;
        while ((length = inputStream.read(b)) != -1) {

            outputStream.write(b);

            outputStream.flush();


        }

        inputStream.close();
        outputStream.close();

    }

}

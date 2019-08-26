package io.chuanzhiboke;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author : 石建雷
 * @date :2019/8/16
 */

public class FileWriterDemo {

    public static void main(String[] args) throws IOException {


        FileWriter writer = new FileWriter("F:\\java-code\\workspace\\JAVA_SE\\src\\io\\chuanzhiboke\\a.txt");
        writer.write("我是 FileWriter");
        /*字符输出流的使用步骤（重点）：
        1.创建FiLelwriter对象，构造方法中绑定要写入数据的目的地2.使用Filewriter中的方法write，把数据写入到内存缓冲区中（字符转换为字节的过程）
        3.使用Filewriter中的方法fLush，把内存缓冲区中的数据，刷新到文件中
        4.释放资源（会先把内存缓冲区中的数据刷新到文件中）
        */
        writer.flush();
        /*flush方法和cLose方法的区别
                -flush：刷新缓冲区，流对象可以继续使用。
        -cLose：先刷新缓冲区，然后通知系统释放资源。流对象不可以再被使用了。*/
        writer.close();



    }
}

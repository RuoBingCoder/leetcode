package socket.tcpsocket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author : 石建雷
 * @date :2019/8/17
 */

public class TcpClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 21223);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello tcp".getBytes());
        socket.close();
    }
}

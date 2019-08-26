package socket.tcpsocket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author : 石建雷
 * @date :2019/8/17
 */

public class TcpServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(21223);
        Socket s = serverSocket.accept();
        InputStream stream = s.getInputStream();
        byte[] bytes = new byte[1024];
        int len = stream.read(bytes);
        System.out.println(new String(bytes, 0, len));

//        释放资源
        s.close();
    }
}

package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author：Weiyu
 * @Version:
 * @Since:
 * @date：2021-12-02_周四 16:32
 **/
public class ServeSocket {
    public static final int PORT=3001;
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=null;
        Socket socket=null;
        System.out.println("********服务器启动成功*********");

        serverSocket= new ServerSocket(PORT);
        while (true) {
            socket = serverSocket.accept();//如果没有客户端程序连接，服务器端运行会阻塞在这一行
            System.out.println("\t\t服务器建立连接，有一个客户端连接成功。。。");
            new ServerWriter(socket).start();
            new ServerReader(socket).start();
        }
    }
}
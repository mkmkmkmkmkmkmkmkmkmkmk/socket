package socket;
import java.io.*;
import java.net.Socket;

/**
 * @Author：Weiyu
 * @Version:
 * @Since:
 * @date：2021-12-02_周四 16:32
 **/
public class ClientSocket {
    public static void main(String[] args) throws IOException {
        System.out.println("@@@@@@@有一个客户端确认连接@@@@@@");
        Socket client =new Socket("127.0.0.1",3001);//三次握手，此处客户端已经和服务器建立连接，服务器端会发送消息回来确认
        new ClientReader(client).start();
        new ClientWriter(client).start();
    }
}
package socket;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author：Weiyu
 * @Version:
 * @Since:
 * @date：2021-12-02_周四 17:59
 **/
public class ClientWriter extends Thread {
    private Socket socket;


    public ClientWriter(Socket socket) {
        super();
        this.socket = socket;
    }

    @Override
    public void run() {
        Scanner sc=new Scanner(System.in);
        BufferedWriter bw= null;
        boolean flag=true;
        try {
            while(flag) {

                //socket中读取输出字节流转为输出字符流，转为字符缓冲流
                bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                System.out.println("@@客户端对服务器说：");
                String str = sc.next();
                //键盘输入写入到字符缓冲流中
                bw.write(str);
                bw.newLine();
                bw.flush();
            }
            bw.close();
        }catch (IOException e) {
                e.printStackTrace();
            }
        }
}


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
 * @date：2021-12-02_周四 18:09
 **/
public class ServerWriter extends  Thread {
    private Socket socket;


    public ServerWriter(Socket socket) {
        super();
        this.socket = socket;
    }

    @Override
    public void run() {
        Scanner sc=new Scanner(System.in);
        //socket输出字节流转为输出字符流，转为字符缓冲流
        BufferedWriter bw= null;
        boolean flag=true;
        try {
            while(flag){
                    bw=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                    System.out.println("**服务器回复客户端内容：");
                    String str=sc.next();
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

package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @Author：Weiyu
 * @Version:
 * @Since:
 * @date：2021-12-02_周四 18:09
 **/
public class ServerReader extends Thread{
    private Socket socket;

    public ServerReader(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        boolean flag=true;
        BufferedReader br=null;
        try {
            while (flag) {
                //服务端从socket中读取的输入字节流转为输入字符流-》字符缓冲流
                br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String str = br.readLine();
                //如果服务端接收到客户端的是BYE就退出
                if(str.equalsIgnoreCase("")) break;
                System.out.println("**服务端收到客户端说:" + str);
            }
            br.close();
        }catch(IOException e){
        e.printStackTrace();
        }
    }
}

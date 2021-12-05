package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @Author：Weiyu
 * @Version:
 * @Since:
 * @date：2021-12-02_周四 17:51
 **/
public class ClientReader extends Thread{
    private Socket socket;

    public ClientReader(Socket socket){
        super();
        this.socket=socket;
    }

    @Override
    public void run() {
        super.run();
        //从socket流中读取纯文本，选择BufferedReader
        BufferedReader br=null;
        String str = null;
        //反复读取
        try {
            boolean flag=true;
            while(flag){
                    //客户端从socket中读取的输入字节流转为输入字符流-》字符缓冲流
                    br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    str = br.readLine();
                     if(str.equalsIgnoreCase("BYE")) break;
                    System.out.println("@@服务器回复客户端："+str);

            }
            br.close();
        }catch (IOException e) {
                e.printStackTrace();
            }
        }
}

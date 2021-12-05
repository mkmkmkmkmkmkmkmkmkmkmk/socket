import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author：Weiyu
 * @Version:
 * @Since:
 * @date：2021-12-02_周四 19:38
 **/
public class ServeSocket {
    public static void main (String args[]) throws IOException
    {
        ServerSocket server=null;
        Socket socket=null;
        InputStream is=null;
        OutputStream os=null;
        DataInputStream in=null;
        PrintStream out=null;
        BufferedReader bw=null;
        try
        {  //在端口5000注册服务
            server=new ServerSocket(5000);
            socket =server.accept();//侦听连接请求，等待连接
            System.out.println("**********************服务器端界面*************************");
            System.out.println("与客户端连接成功！");
            System.out.println("");
            System.out.println("对话内容为：");
            System.out.println("");
            System.out.println("等待客户发送信息.....");
            //获取对应的Socket的输入/输出流
            is=socket.getInputStream();
            os=socket.getOutputStream();
            //建立数据流
            in= new DataInputStream(is);
            bw=new BufferedReader(new InputStreamReader(in,"utf-8"));
            out =new PrintStream(os);//表示向对方输出
            out.println("Welcome!");//表示向对方输出
            String str=bw.readLine();//逐行读取
            do
            {
                System.out.println("客户端说:"+ str);
                str=bw.readLine();
            }while(str.trim().equals("BYE")); //如果是“BYE”就退出
            System.out.println("客户想要离开");
        }
        catch(Exception e)  //捕获程序异常
        {
            System.out.println("Error:"+e);
        }
        finally
        {
            is.close();//关闭输入流
            os.close();//关闭输出流
            in.close();//关闭数据输入流
            socket.close();//关闭socket
        }
    }
}

/**
 * @Author：Weiyu
 * @Version:
 * @Since:
 * @date：2021-12-02_周四 16:38
 **/
import java.net.*;
import java.io.*;
public class ClientSocket {

         public static    void  main (String args[]) throws IOException
        {
            Socket socket=null;
            InputStream is=null;
            OutputStream os=null;
            BufferedReader br=null;

            DataInputStream in=null;
            PrintStream out=null;
            BufferedWriter bw=null;
            String str=null;
            try
            { //向本地服务器申请链接
                //注意端口号要与服务器保持一致：5000
                socket=new Socket("localhost",5000);
                System.out.println("********************客户端界面************************");
                System.out.println("与服务器连接成功！");
                System.out.println("");
                System.out.println("对话内容为：");
                System.out.println("");
                System.out.println("请输入信息：");
                //获取对应的Socket的输入/输出流
                is=socket.getInputStream();
                os=socket.getOutputStream();
                //建立数据流
                in= new DataInputStream(is);
                br=new BufferedReader(new InputStreamReader(in,"utf-8"));
                out=new PrintStream(os);
                str=br.readLine();

                bw=new BufferedWriter(new OutputStreamWriter(out));

                System.out.println("服务器说："+str);
                byte a[]=new byte[100];
                System.in.read(a);
                String b=new String(a,0);
                b=b.trim();//去点输入的第一个字符前的空格
                while(!b.equals("BYE"))
                {
                    out.println("请输入您要发送的信息："+b);//如果输入的不是“BYE”，就向对方输出
                    System.in.read(a);
                    b=new String(a,0);
                    b=b.trim();
                }
                out.println(b);
            }
            catch(Exception e)//捕获程序异常
            {
                System.out.println("Error:"+e);
            }
            finally
            {
                is.close();//关闭输入流
                os.close();//关闭输出流
                socket.close();//关闭socket
            }
        }
    }



package QQ;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * @program: WebScoket
 * @description: 客户端
 * @author: xw
 * @create: 2018-09-09 15:04
 **/
public class SocketClient {
    Socket socket=null;
    InputStreamReader input = null;
    InputStream in = null;
    OutputStream out = null;
    byte[] b = new byte[1024];

    public  void socketStart(){
        try {
            socket = new Socket("192.168.43.153",8898);
            out = socket.getOutputStream();
            while(true){
                input = new InputStreamReader(System.in);
                String name = new BufferedReader(input).readLine();
                out.write(name.getBytes());
                if("bye".equals(name)){
                    break;
                }
                System.out.println("已发送");
                //接受返回数据
                new Thread(){
                    public void run(){
                        try {
                            while(true){
                                in =socket.getInputStream();
                                int n = in.read(b);
                                System.out.println("返回数据："+new String(b,0,n) );
                            }
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }.start();
            }

        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            try {
                //关闭流和连接
                in.close();
                out.close();
                socket.close();
            } catch (Exception e2) {}
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new SocketClient().socketStart();
    }
}

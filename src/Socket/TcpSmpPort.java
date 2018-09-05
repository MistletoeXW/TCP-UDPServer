package Socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * @program: WebScoket
 * @description: TCP单向通信实例
 * @author: xw
 * @create: 2018-09-05 19:04
 **/
public class TcpSmpPort {
    private BufferedReader reader;  //创建BufferedReader对象
    private ServerSocket server;    //创建ServerSocket对象
    private Socket socket;       //创建Socket对象


    private void getClientMessage(){
        try{
            while(true){
                //获得客户端信息
                System.out.println("客户机："+ reader.readLine());
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        try{
            if(reader != null) reader.close();  //关闭流
            if(socket != null) socket.close();   //关闭套接字
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    void getServer(){
        try{
            server = new ServerSocket(8998);   //实例化Socket对象，服务器套接字绑定到8990端口
            System.out.print("服务器套接字已经创建成功！\n");
            while (true){                               //套接字处于连接连接状态
                System.out.print("等待客户机的连接……\n");
                socket = server.accept();    //实例化Socket对象
                //实例化BufferedReader对象
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                getClientMessage();        //调用getClientMessage方法
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        TcpSmpPort tcpSmpPort = new TcpSmpPort();
        tcpSmpPort.getServer();
    }

}

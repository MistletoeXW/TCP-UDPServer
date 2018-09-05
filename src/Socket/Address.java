package Socket;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*
 * @program: WebScoket
 * @description: InetAddres类测试
 * @author: xw
 * @create: 2018-09-05 18:46
 **/
public class Address {

    public static void main(String[] args){
        InetAddress ip;
        try{
            ip = InetAddress.getLocalHost();  //实例化对象
            String localname = ip.getHostName(); //获取本机名
            String locaip = ip.getHostAddress(); //获取本机ip地址
            System.out.print("本机名：" + localname+'\n');
            System.out.print("本机ip地址："+locaip);
        }catch (UnknownHostException e){
            e.printStackTrace();  //在主机不存在网络连接或者连结错误时抛出异常

        }
    }
}

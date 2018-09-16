package Socket;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.Socket;

/*
 * @program: WebScoket
 * @description: 客户端程序，实现将用户在文本框中的信息发送至服务器，
 *               并将文本框输入的信息显示在客户端文本域中
 * @author: xw
 * @create: 2018-09-05 19:29
 **/
public class TCPClient extends JFrame {
    private PrintWriter writer;     //声明PrintWriter类对象
    Socket socket;                  //声明Socket对象
    private JTextArea ta = new JTextArea(); //创建JTextArea对象
    private JTextField tf = new JTextField(); //创建JTextArea对象
    Container cc;                  //声明Container对象
    public TCPClient(String title){
        super(title);              //调用父类的构造方法
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cc = this.getContentPane();
        final JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBorder(new BevelBorder(BevelBorder.RAISED));
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        scrollPane.setViewportView(ta);
        cc.add(tf,"South");    //将文本框放到窗体下面
        tf.addActionListener(new ActionListener() {

            //绑定事件
            @Override
            public void actionPerformed(ActionEvent e) {
                //将文本框写入流
                writer.println(tf.getText());
                //将文本框的信息显示在文本框中
                ta.append(tf.getText() + '\n');
                ta.setSelectionEnd(ta.getText().length());
                tf.setText("");    //将文本框清空
            }
        });

    }

    private void connect(){
        ta.append("尝试连接\n");       //文本域中显示内容
        try{
            socket = new Socket("10.95.76.107",8998);  //实例化Socket对象
            writer = new PrintWriter(socket.getOutputStream(), true);
            ta.append("完成连接\n");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        TCPClient client = new TCPClient("向服务器发送数据");
        client.setSize(250,250);   //设置窗体大小
        client.setVisible(true);                 //将窗体显示
        client.connect();                       //调用连接方法
    }
}

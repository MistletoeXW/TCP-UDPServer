package JavaSocket.Login;

import JavaSocket.Client.ClientUI;
import JavaSocket.Server.Server;
import JavaSocket.Server.ServerUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * @program: WebScoket
 * @description: 用户登录界面实现
 * @author: xw
 * @create: 2018-09-12 23:54
 **/
public class helloLabel extends JFrame {
    private static int count=0;
    private static JButton bt1;//登陆按钮
    private static JButton bt2;//忘记密码按钮
    private static JLabel jl_1;//登录的版面
    private static JFrame jf_1;//登陆的框架
    private static JTextField jtext1;//用户名
    private static JPasswordField jtext2;//密码
    private static JLabel jl_admin;
    private static JLabel jl_password;
    public helloLabel (){//初始化登陆界面
        Font font =new Font("黑体", Font.PLAIN, 20);//设置字体
        jf_1=new JFrame("登陆界面");
        jf_1.setSize(450, 400);
        //给登陆界面添加背景图片
        ImageIcon bgim = new ImageIcon(helloLabel.class.getResource("xuwen.png")) ;//背景图案
        bgim.setImage(bgim.getImage().
                getScaledInstance(bgim.getIconWidth(),
                        bgim.getIconHeight(),
                        Image.SCALE_DEFAULT));
        jl_1=new JLabel();
        jl_1.setIcon(bgim);

        jl_admin=new JLabel("用户名");
        jl_admin.setBounds(20, 50, 60, 50);
        jl_admin.setFont(font);

        jl_password=new JLabel("密码");
        jl_password.setBounds(20, 120, 60, 50);
        jl_password.setFont(font);

        bt1=new JButton("登陆");         //更改成loginButton
        bt1.setBounds(90, 250, 100, 50);
        bt1.setFont(font);

        bt2=new JButton("退出");
        bt2.setBounds(250, 250, 100, 50);
        bt2.setFont(font);

        //加入文本框
        jtext1=new JTextField("root");
        jtext1.setBounds(150, 50, 250, 50);
        jtext1.setFont(font);

        jtext2=new JPasswordField("123456");//密码输入框
        jtext2.setBounds(150, 120, 250, 50);
        jtext2.setFont(font);

        jl_1.add(jtext1);
        jl_1.add(jtext2);

        jl_1.add(jl_admin);
        jl_1.add(jl_password);
        jl_1.add(bt1);
        jl_1.add(bt2);

        jf_1.add(jl_1);
        jf_1.setVisible(true);
        jf_1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf_1.setLocation(300,400);
    }
    public static void main(String[] args) {
        //初始化登陆界面

        helloLabel hl =new helloLabel();
        /**
         * 处理点击事件
         * 1.登陆按钮点击事件，判断账号密码是否正确，若正确，弹出监测信息界面
         * 否则，无响应（暂时无响应）
         * ：后可在登陆界面添加一个logLabel提示用户是否用户密码正确
         * 2.退出按钮，直接退出程序
         */
        //登陆点击事件
        ActionListener bt1_ls=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                String admin=jtext1.getText();
                char[] password=jtext2.getPassword();
                String str=String.valueOf(password); //将char数组转化为string类型

                if(admin.equals("root")&&str.equals("123456"))
                {

                    System.out.println(admin);
                    System.out.println(str);
                    ServerUI ml=new ServerUI();//为跳转的界面
                    hl.jf_1.dispose();//销毁当前界面
                }else if(admin.equals("16121666")&&str.equals("123456")){
                    ClientUI clientUI = new ClientUI();//为跳转的界面
                    hl.jf_1.dispose();//销毁当前界面
                }
                else {
                    count++;
                    System.out.println("error");
                    if(count==3){
                        hl.jf_1.dispose();
                    }
                }
            }
        };
        bt1.addActionListener(bt1_ls);
        //退出事件的处理
        ActionListener bt2_ls=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                System.exit(0);//终止当前程序
            }
        };
        bt2.addActionListener(bt2_ls);
    }

}

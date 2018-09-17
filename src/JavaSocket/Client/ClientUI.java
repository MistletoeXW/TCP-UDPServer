package JavaSocket.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
 * @program: WebScoket
 * @description: 客户端UI
 * @author: xw
 * @create: 2018-09-12 23:39
 **/
public class ClientUI extends JFrame {
    public static void main(String[] args) {
        ClientUI client = new ClientUI();
    }
    public ClientUI() {
        super("客户端");
        btStart = new JButton("启动连接");
        btSend = new JButton("发送信息");
        tfSend = new JTextField(20);
        tfIP = new JTextField(20);
        tfPost = new JTextField(10);
        taShow = new JTextArea();

        btStart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                server = new ClientThread(ClientUI.this);
            }
        });
        btSend.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                server.sendMsg(tfSend.getText());
                tfSend.setText("");
            }
        });
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int a = JOptionPane.showConfirmDialog(null, "确定关闭吗？", "温馨提示",
                        JOptionPane.YES_NO_OPTION);
                if (a == 1) {
                    System.exit(0); // 关闭
                }
            }
        });
        JPanel top = new JPanel(new FlowLayout());
        top.add(tfSend);
        top.add(btSend);
        top.add(btStart);
        this.add(top, BorderLayout.SOUTH);
        final JScrollPane sp = new JScrollPane();
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        sp.setViewportView(this.taShow);
        this.taShow.setEditable(false);
        this.add(sp, BorderLayout.CENTER);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 400);
        this.setLocation(800, 300);
        this.setVisible(true);
    }

    public     JButton btStart;
    public     JButton btSend;
    public     JTextField tfSend;
    public     JTextField tfIP;
    public     JTextField tfPost;

    public     JTextArea taShow;
    public     ClientThread server;
}

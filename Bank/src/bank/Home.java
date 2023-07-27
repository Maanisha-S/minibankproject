package bank;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Home extends JFrame{

    JLabel btn1 = new JLabel("Add Account");
    JLabel btn2 = new JLabel("Balance");
    JLabel btn3 = new JLabel("Deposit");
    JLabel btn4 = new JLabel("Withdraw");
    Image image = Toolkit.getDefaultToolkit().createImage("C:\\Users\\ELCOT\\Documents\\NetBeansProjects\\Bank\\bank.png");
    JLabel bg=new JLabel();
    public void run() {
        setVisible(true);
        setLayout(null);
        setSize(1500, 800);
        setIconImage(image);
        setTitle("Home");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        btn1.setFont(new Font("Serif", Font.BOLD, 40));
        //btn1.setForeground(Color.WHITE);
        btn1.setBackground(Color.BLACK);
        btn1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(btn1);
        btn1.setBounds(150, 530, 240, 60);
        
        btn2.setFont(new Font("Serif", Font.BOLD, 40));
        //btn2.setForeground(Color.WHITE);
        btn2.setBackground(Color.BLACK);
        btn2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(btn2);
        btn2.setBounds(500, 530, 220, 60);
        
        btn3.setFont(new Font("Serif", Font.BOLD, 40));
        //btn3.setForeground(Color.WHITE);
        btn3.setBackground(Color.BLACK);
        btn3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(btn3);
        btn3.setBounds(800, 530, 220, 60);
        
        btn4.setFont(new Font("Serif", Font.BOLD, 40));
        //btn4.setForeground(Color.WHITE);
        btn4.setBackground(Color.BLACK);
        btn4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(btn4);
        btn4.setBounds(1100, 530, 220, 60);
        
        bg.setIcon(new ImageIcon("C:\\Users\\ELCOT\\Documents\\NetBeansProjects\\Bank\\bank30.jpg"));
        add(bg);
        bg.setBounds(-300, -20, 1900, 700);
        
        btn1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               Account a=new Account();
               a.run();
               setVisible(false);
            }
        });
        btn2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               Balance a=new Balance();
               a.run();
               setVisible(false);
            }
        });
        btn3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               Deposit d=new Deposit();
               d.run();
               setVisible(false);
            }
        });
        btn4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               Withdraw a=new Withdraw();
               a.run();
               setVisible(false);
            }
        });
        
    
    }
}

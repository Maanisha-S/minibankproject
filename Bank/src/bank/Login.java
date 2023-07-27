package bank;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.scene.layout.Border;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame {

    public void run() {
        initComponents();

    }

    private void initComponents() {
        JPanel p = new JPanel();
        JLabel label1 = new JLabel("User name");
        JLabel label2 = new JLabel("Password");
        JLabel tit = new JLabel("Login");
        JTextField txtf1 = new JTextField();
        JPasswordField txtf2 = new JPasswordField();
        JButton btn1 = new JButton("Login");
        JButton btn2 = new JButton("Cancel");
        JLabel img = new JLabel();
        JLabel img1 = new JLabel();
        Image image = Toolkit.getDefaultToolkit().createImage("C:\\Users\\ELCOT\\Documents\\NetBeansProjects\\Bank\\bank.png");
        javax.swing.border.Border bl = BorderFactory.createLineBorder(Color.BLACK);
        setVisible(true);
        setLayout(null);
        setSize(1500, 800);
        setIconImage(image);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        setTitle("Login");
        p.setLayout(null);
        p.setVisible(true);

        p.setBorder(bl);
        p.setBackground(Color.BLACK);
        add(p);
        //p.setBounds(300, 130, 700, 450);
        p.setBounds(0,0,1500,800);

        tit.setFont(new Font("Serif", Font.BOLD, 40));
        tit.setForeground(Color.BLUE);
        p.add(tit);
        tit.setBounds(630, -100, 400, 500);

        label1.setFont(new Font("Serif", Font.BOLD, 30));
        label1.setForeground(Color.orange);
        p.add(label1);
        label1.setBounds(420, 100, 300, 400);

        txtf1.setFont(new Font("Serif", Font.BOLD, 20));
        p.add(txtf1);
        txtf1.setBounds(700, 290, 200, 30);

        label2.setFont(new Font("Serif", Font.BOLD, 30));
        label2.setForeground(Color.orange);
        p.add(label2);
        label2.setBounds(420, 200, 300, 400);

        txtf2.setFont(new Font("Serif", Font.BOLD, 20));
        p.add(txtf2);
        txtf2.setBounds(700, 390, 200, 30);

        btn1.setFont(new Font("Serif", Font.BOLD, 20));
        btn1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        p.add(btn1);
        btn1.setBounds(780, 500, 100, 40);

        btn2.setFont(new Font("Serif", Font.BOLD, 20));
        btn2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        p.add(btn2);
        btn2.setBounds(930, 500, 100, 40);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String qry;
                Connection con;
                PreparedStatement ps;
                ResultSet rs;
                Statement st;
                String url, uname, pwd;
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");  //Itha file la load pannum 
                    url = "jdbc:mysql://localhost:3306/bank";
                    uname = "sample1";
                    pwd = "137731";
                    con = DriverManager.getConnection(url, uname, pwd);
                    ps = con.prepareStatement("SELECT * FROM admin WHERE id=? and password=?;");
                    ps.setString(1, txtf1.getText());
                    ps.setString(2, txtf2.getText());
                    rs = ps.executeQuery();
                    if(rs.next()){
                        // JOptionPane.showMessageDialog(null, "login successfully");
                        Home h=new Home();
                        h.run();
                        setVisible(false);
                   }
                    else{
                             JOptionPane.showMessageDialog(null, "Username and password do not matched","Information", JOptionPane.INFORMATION_MESSAGE);
                             txtf1.setText("");
                             txtf2.setText("");
                             txtf1.requestFocus();
                    }

                } catch (Exception ex) {
                    System.out.println("Error:" + ex);
                }
            }
        });

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        //img.setIcon(new ImageIcon("C:\\Users\\ELCOT\\Documents\\NetBeansProjects\\Bank\\bank4.jpg"));
        
        img.setIcon(new ImageIcon("C:\\Users\\ELCOT\\Documents\\NetBeansProjects\\Bank\\bank4.jpg"));
        p.add(img);
        img.setBounds(10, -20, 1500, 800);
        
        
       
    }

}

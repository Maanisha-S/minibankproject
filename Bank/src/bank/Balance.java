package bank;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Balance extends JFrame {

    JLabel label1 = new JLabel("Enter the Account Number");
    JTextField accno = new JTextField();
    JLabel btn1 = new JLabel("Find");
    JLabel label2 = new JLabel("Customer ID");
    JLabel label3 = new JLabel("First Name");
    JLabel label4 = new JLabel("Last Name");
    JLabel label6 = new JLabel("Customer ID");
    JLabel label7 = new JLabel("First Name");
    JLabel label8 = new JLabel("Last Name");
    JLabel label5 = new JLabel("Balance");
    JLabel bal = new JLabel("Balance");
    //JLabel label9=new JLabel("OK");
    JLabel label10 = new JLabel("Clear");
    JLabel img = new JLabel();
    JLabel arr = new JLabel("←");
    String qry;
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Statement st;
    Image image = Toolkit.getDefaultToolkit().createImage("C:\\Users\\ELCOT\\Documents\\NetBeansProjects\\Bank\\bank.png");

    public void run() {
        setVisible(true);
        setLayout(null);
        setBounds(0, 0, 1500, 800);
        setTitle("Balance");
        setIconImage(image);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label1.setFont(new Font("Tahoma", Font.BOLD, 30));
        label1.setForeground(Color.WHITE);
        add(label1);
        label1.setBounds(100, 50, 400, 60);

        accno.setFont(new Font("Monospaced", Font.BOLD, 20));
        add(accno);
        accno.setBounds(40, 150, 500, 40);

        btn1.setFont(new Font("Serif", Font.BOLD, 30));
        btn1.setForeground(Color.GRAY);
        btn1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(btn1);
        btn1.setBounds(400, 230, 300, 40);

        label2.setFont(new Font("Tahoma", Font.BOLD, 20));
        label2.setForeground(Color.WHITE);
        add(label2);
        label2.setBounds(80, 350, 400, 40);
        label3.setFont(new Font("Tahoma", Font.BOLD, 20));
        label3.setForeground(Color.WHITE);
        add(label3);
        label3.setBounds(80, 430, 400, 40);
        label4.setFont(new Font("Tahoma", Font.BOLD, 20));
        label4.setForeground(Color.WHITE);
        add(label4);
        label4.setBounds(80, 510, 400, 40);

        label6.setFont(new Font("Tahoma", Font.BOLD, 15));
        label6.setForeground(Color.WHITE);
        add(label6);
        label6.setBounds(250, 350, 400, 40);
        label7.setFont(new Font("Tahoma", Font.BOLD, 15));
        label7.setForeground(Color.WHITE);
        add(label7);
        label7.setBounds(250, 430, 400, 40);
        label8.setFont(new Font("Tahoma", Font.BOLD, 15));
        label8.setForeground(Color.WHITE);
        add(label8);
        label8.setBounds(250, 510, 400, 40);

        label5.setFont(new Font("Tahoma", Font.BOLD, 20));
        label5.setForeground(Color.WHITE);
        add(label5);
        label5.setBounds(1000, 210, 400, 40);

        bal.setFont(new Font("Tahoma", Font.BOLD, 40));
        bal.setForeground(Color.BLUE);
        add(bal);
        bal.setBounds(1100, 280, 400, 60);

//        label9.setFont(new Font("Serif",Font.BOLD,30));
//        label9.setCursor(new Cursor(Cursor.HAND_CURSOR));
//        label9.setForeground(Color.GRAY);
//        add(label9);
//        label9.setBounds(1100,400,400,40);
        label10.setFont(new Font("Serif", Font.BOLD, 30));
        label10.setForeground(Color.GRAY);
        label10.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(label10);
        label10.setBounds(1200, 400, 400, 40);
        arr.setFont(new Font("Monospaced", Font.BOLD, 50));
        arr.setCursor(new Cursor(Cursor.HAND_CURSOR));
        arr.setForeground(Color.WHITE);
        add(arr);
        arr.setBounds(0, -20, 200, 100);
        arr.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Home a = new Home();
                a.run();
                setVisible(false);
            }
        });

        btn1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String url, uname, pwd;
                String ano = accno.getText();
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");  //Itha file la load pannum 
                    url = "jdbc:mysql://localhost:3306/bank";
                    uname = "sample1";
                    pwd = "137731";
                    con = DriverManager.getConnection(url, uname, pwd);
                    ps = con.prepareStatement("select balance from account where accountnum=?;");
                    ps.setString(1, ano);
                    rs = ps.executeQuery();
                    if (rs.next() == true) {
//                        String id = rs.getString(1);
//                        String firstname = rs.getString(2);
//                        String laststname = rs.getString(3);
                        String balance = rs.getString(1);
//                        label6.setText(id.trim());
//                        label7.setText(firstname.trim());
//                        label8.setText(laststname.trim());
                        bal.setText(balance.trim());
                    }
                    else{
                         JOptionPane.showMessageDialog(null,"Account No no found");
                         accno.setText("");
                
                    }

                } catch (Exception ex) {
                    System.out.println(ex);
                }
                detail();
            }
        });
        label10.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                bal.setText("");
                accno.setText("");
                label6.setText("");
                label7.setText("");
                label8.setText("");
            }
        });
        img.setIcon(new ImageIcon("C:\\Users\\ELCOT\\Documents\\NetBeansProjects\\Bank\\bank32.jpg"));
        add(img);
        img.setBounds(-200, 0, 1900, 800);
    }
    public void detail(){
        String url, uname, pwd;
                String ano = accno.getText();
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");  //Itha file la load pannum 
                    url = "jdbc:mysql://localhost:3306/bank";
                    uname = "sample1";
                    pwd = "137731";
                    con = DriverManager.getConnection(url, uname, pwd);
                    ps = con.prepareStatement("select id,firstname,lastname from customer where accountnum=?;");
                    ps.setString(1, ano);
                    rs = ps.executeQuery();
                    if (rs.next() == true) {
                        String id = rs.getString(1);
                        String firstname = rs.getString(2);
                        String laststname = rs.getString(3);
                        //String balance = rs.getString(1);
                        label6.setText(id.trim());
                        label7.setText(firstname.trim());
                        label8.setText(laststname.trim());
                       // bal.setText(balance.trim());
                    }
                    else{
                         //JOptionPane.showMessageDialog(null,"Account No no found");
                         accno.setText("");
                
                    }

                } catch (Exception ex) {
                    System.out.println(ex);
                }
    }
}

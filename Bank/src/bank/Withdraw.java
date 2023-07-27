
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Withdraw extends JFrame {
    JLabel label1 = new JLabel("Enter the Account Number");
    JLabel img=new JLabel();
    JLabel arr = new JLabel("←");
    JLabel date = new JLabel("Date : ");
    JLabel dt = new JLabel("Date");
    JTextField accno = new JTextField();
    JTextField first = new JTextField();
    JTextField last = new JTextField();
    JLabel label3 = new JLabel("First Name");
    JLabel label4 = new JLabel("Last Name");
    JLabel rp = new JLabel("Rs : ");
    JLabel label11 = new JLabel("OK");
    //JLabel label12 = new JLabel("Clear");
    JTextField wdraw = new JTextField();
    String qry;
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Statement st;
    Image image = Toolkit.getDefaultToolkit().createImage("C:\\Users\\ELCOT\\Documents\\NetBeansProjects\\Bank\\bank.png");
    public void run(){
        setVisible(true);
        setLayout(null);
        setBounds(0, 0, 1500, 800);
        setTitle("Deposit");
        setIconImage(image);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        arr.setFont(new Font("Monospaced", Font.BOLD, 50));
        arr.setCursor(new Cursor(Cursor.HAND_CURSOR));
        arr.setForeground(Color.WHITE);
        add(arr);
        arr.setBounds(0, -20, 200, 100);
         arr.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               Home a=new Home();
               a.run();
               setVisible(false);
            }
        });
         date.setFont(new Font("Serif", Font.BOLD, 30));
        date.setForeground(Color.WHITE);
        add(date);
        date.setBounds(1100, 10, 400, 40);
        dt.setFont(new Font("Tahoma", Font.BOLD, 20));
        dt.setForeground(Color.WHITE);
        add(dt);
        dt.setBounds(1200, 15, 400, 40);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        String date = dtf.format(now);
        dt.setText(date);
        label1.setFont(new Font("Tahoma", Font.BOLD, 30));
        //label1.setForeground(Color.WHITE);
        add(label1);
        label1.setBounds(450, 120, 400, 60);

        accno.setFont(new Font("Monospaced", Font.BOLD, 20));
        add(accno);
        accno.setBounds(500, 200, 300, 35);

        label3.setFont(new Font("Tahoma", Font.BOLD, 30));
        //label3.setForeground(Color.WHITE);
        add(label3);
        label3.setBounds(200, 350, 400, 50);
        label4.setFont(new Font("Tahoma", Font.BOLD, 30));
        //label4.setForeground(Color.WHITE);
        add(label4);
        label4.setBounds(200, 430, 400, 50);

        first.setFont(new Font("Monospaced", Font.BOLD, 20));
        add(first);
        first.setBounds(450, 360, 200, 35);
        last.setFont(new Font("Monospaced", Font.BOLD, 20));
        add(last);
        last.setBounds(450, 440, 200, 35);
        
        rp.setFont(new Font("Tahoma", Font.BOLD, 40));
        //label3.setForeground(Color.WHITE);
        add(rp);
        rp.setBounds(800, 400, 400, 60);
        wdraw.setFont(new Font("Monospaced", Font.BOLD, 40));
        add(wdraw);
        wdraw.setBounds(900, 400, 200, 50);
        
         label11.setFont(new Font("Serif", Font.BOLD, 30));
        label11.setCursor(new Cursor(Cursor.HAND_CURSOR));
        label11.setForeground(Color.BLACK);
        add(label11);
        label11.setBounds(1000, 550, 400, 40);
        /*label12.setFont(new Font("Serif", Font.BOLD, 30));
        label12.setForeground(Color.BLACK);
        label12.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(label12);
        label12.setBounds(700, 550, 400, 40);*/
        
        label11.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String url, uname, pwd;
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");  //Itha file la load pannum 
                    url = "jdbc:mysql://localhost:3306/bank";
                    uname = "sample1";
                    pwd = "137731";
                    con = DriverManager.getConnection(url, uname, pwd);
                    String i = wdraw.getText();
                    String d = accno.getText();
                    int k = Integer.parseInt(i);
                    qry = "Update account set balance= balance-? Where accountnum=?; ";
                    ps = con.prepareStatement(qry);
                    ps.setString(1, i);
                    ps.setString(2, d);

                    int m = ps.executeUpdate();
                    if (m == 1) {
                        JOptionPane.showMessageDialog(null, "Withdraw Successfully");
                    } else {
                        JOptionPane.showMessageDialog(null, "Withdraw Failed");
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                }
                withdraw();
                wdraw.setText("");
                accno.setText("");
                first.setText("");
                last.setText("");
            }
        });
        
        
       img.setIcon(new ImageIcon("C:\\Users\\ELCOT\\Documents\\NetBeansProjects\\Bank\\bank33.jpg"));
        add(img);
        img.setBounds(-200, 0, 1900, 800);
        /*label12.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                wdraw.setText("");
                accno.setText("");
                first.setText("");
                last.setText("");
            }
        });*/
    }
    public void withdraw() {
        String url, uname, pwd;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  //Itha file la load pannum 
            url = "jdbc:mysql://localhost:3306/bank";
            uname = "sample1";
            pwd = "137731";
            con = DriverManager.getConnection(url, uname, pwd);
            ps=con.prepareStatement("insert into withdraw(date,accountnum,withdraw) Values (?,?,?)");
            ps.setString(1,dt.getText());
            ps.setString(2,accno.getText());
            ps.setString(3,wdraw.getText());
            ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}

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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Deposit extends JFrame {

    JLabel label1 = new JLabel("Enter the Account Number");
    JLabel date = new JLabel("Date : ");
    JLabel dt = new JLabel("Date");
    JTextField accno = new JTextField();
    JTextField first = new JTextField();
    JTextField last = new JTextField();
    JLabel label3 = new JLabel("First Name");
    JLabel label4 = new JLabel("Last Name");
    JLabel label9 = new JLabel("OK");
    JLabel label10 = new JLabel("Clear");
    JLabel dep = new JLabel("Deposit");
    JLabel arr = new JLabel("←");
    JTextField deposite = new JTextField();
    JLabel img = new JLabel();
    Image image = Toolkit.getDefaultToolkit().createImage("C:\\Users\\ELCOT\\Documents\\NetBeansProjects\\Bank\\bank.png");
    String qry;
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Statement st;

    public void run() {
        setVisible(true);
        setLayout(null);
        setBounds(0, 0, 1500, 800);
        setTitle("Deposit");
        setIconImage(image);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        label1.setFont(new Font("Tahoma", Font.BOLD, 30));
        label1.setForeground(Color.WHITE);
        add(label1);
        label1.setBounds(800, 120, 400, 60);

        accno.setFont(new Font("Monospaced", Font.BOLD, 20));
        add(accno);
        accno.setBounds(850, 180, 300, 35);

        label3.setFont(new Font("Tahoma", Font.BOLD, 30));
        label3.setForeground(Color.WHITE);
        add(label3);
        label3.setBounds(800, 300, 400, 50);
        label4.setFont(new Font("Tahoma", Font.BOLD, 30));
        label4.setForeground(Color.WHITE);
        add(label4);
        label4.setBounds(800, 430, 400, 50);

        first.setFont(new Font("Monospaced", Font.BOLD, 20));
        add(first);
        first.setBounds(1030, 310, 200, 35);
        last.setFont(new Font("Monospaced", Font.BOLD, 20));
        add(last);
        last.setBounds(1030, 440, 200, 35);

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

        label9.setFont(new Font("Serif", Font.BOLD, 30));
        label9.setCursor(new Cursor(Cursor.HAND_CURSOR));
        label9.setForeground(Color.GRAY);
        add(label9);
        label9.setBounds(1200, 500, 400, 40);
        

        dep.setFont(new Font("Serif", Font.BOLD, 40));
        dep.setForeground(Color.WHITE);
        add(dep);
        dep.setBounds(100, 50, 300, 60);
        deposite.setFont(new Font("Monospaced", Font.BOLD, 20));
        add(deposite);
        deposite.setBounds(130, 150, 200, 35);
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

        label9.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String url, uname, pwd;
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");  //Itha file la load pannum 
                    url = "jdbc:mysql://localhost:3306/bank";
                    uname = "sample1";
                    pwd = "137731";
                    con = DriverManager.getConnection(url, uname, pwd);
                    String i = deposite.getText();
                    String d = accno.getText();
                    int k = Integer.parseInt(i);
                    qry = "Update account set balance= balance+? Where accountnum=?; ";
                    ps = con.prepareStatement(qry);
                    ps.setString(1, i);
                    ps.setString(2, d);

                    int m = ps.executeUpdate();
                    if (m == 1) {
                        JOptionPane.showMessageDialog(null, "Deposite Successfully");
                    } else {
                        JOptionPane.showMessageDialog(null, "Deposite Failed");
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                }
                deposite();
                deposite.setText("");
                accno.setText("");
                first.setText("");
                last.setText("");
            }
        });
       
        img.setIcon(new ImageIcon("C:\\Users\\ELCOT\\Documents\\NetBeansProjects\\Bank\\img25.jpg"));
        add(img);
        img.setBounds(-200, 0, 1900, 800);

    }

    public void deposite() {
        String url, uname, pwd;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  //Itha file la load pannum 
            url = "jdbc:mysql://localhost:3306/bank";
            uname = "sample1";
            pwd = "137731";
            con = DriverManager.getConnection(url, uname, pwd);
            ps=con.prepareStatement("insert into deposite(date,accountnum,deposite) Values (?,?,?)");
            ps.setString(1,dt.getText());
            ps.setString(2,accno.getText());
            ps.setString(3,deposite.getText());
            ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}

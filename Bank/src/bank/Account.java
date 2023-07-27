package bank;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Account extends JFrame {

    JLabel label1 = new JLabel("Account Number");
    JLabel label2 = new JLabel("First Name");
    JLabel label3 = new JLabel("Last Name");
    JLabel label4 = new JLabel("Street");
    JLabel label5 = new JLabel("City");
    JLabel label6 = new JLabel("Branch");
    JLabel label7 = new JLabel("Mobile Number");
    public static JTextField label8 = new JTextField("");
    public static JTextField txt1 = new JTextField();
    public static JTextField txt2 = new JTextField();
    public static JTextField txt3 = new JTextField();
    public static JTextField txt4 = new JTextField();
    public static JTextField txt5 = new JTextField();
    public static JTextField txt6 = new JTextField();
    public static JComboBox branch = new JComboBox();
    JLabel label9 = new JLabel("ADD");
    JLabel label10 = new JLabel("EDIT");
    JLabel label11 = new JLabel("DELETE");
    JLabel label12 = new JLabel("CLEAR");
    JLabel label13 = new JLabel("Amount");
    JLabel img = new JLabel();
    JLabel arr = new JLabel("←");
    JTable table = new JTable();
    JScrollPane scroll = new JScrollPane();
    Image image = Toolkit.getDefaultToolkit().createImage("C:\\Users\\ELCOT\\Documents\\NetBeansProjects\\Bank\\bank.png");
    String qry;
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Statement st;

    public void run() {
        JLabel[] l = {label1, label2, label3, label3, label4, label5, label6, label7};
        setVisible(true);
        setLayout(null);
        setBounds(0, 0, 1500, 800);
        setTitle("Account");
        setIconImage(image);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label1.setFont(new Font("Monospaced", Font.BOLD, 30));
        label1.setBackground(Color.BLACK);
        label1.setForeground(Color.WHITE);
        add(label1);
        label1.setBounds(100, 70, 400, 50);

        label8.setFont(new Font("Serif", Font.BOLD, 30));
        // label8.setForeground(Color.WHITE);
        add(label8);
        label8.setBounds(400, 70, 200, 30);

//        Adddbase a = new Adddbase();
//        Thread th = new Thread(a);
//        th.run();
        label2.setFont(new Font("Monospaced", Font.BOLD, 30));
        label2.setForeground(Color.WHITE);
        add(label2);
        label2.setBounds(100, 150, 400, 50);

        txt1.setFont(new Font("Serif", Font.BOLD, 20));
        add(txt1);
        txt1.setBounds(400, 150, 150, 40);

        label3.setFont(new Font("Monospaced", Font.BOLD, 30));
        label3.setForeground(Color.WHITE);
        add(label3);
        label3.setBounds(100, 230, 400, 50);

        txt2.setFont(new Font("Serif", Font.BOLD, 20));
        add(txt2);
        txt2.setBounds(400, 230, 150, 40);

        label4.setFont(new Font("Monospaced", Font.BOLD, 30));
        label4.setForeground(Color.WHITE);
        add(label4);
        label4.setBounds(100, 300, 400, 50);

        txt3.setFont(new Font("Serif", Font.BOLD, 20));
        add(txt3);
        txt3.setBounds(400, 300, 150, 40);

        label5.setFont(new Font("Monospaced", Font.BOLD, 30));
        label5.setForeground(Color.WHITE);
        add(label5);
        label5.setBounds(100, 380, 400, 50);

        txt4.setFont(new Font("Serif", Font.BOLD, 20));
        add(txt4);
        txt4.setBounds(400, 380, 150, 40);

        label6.setFont(new Font("Monospaced", Font.BOLD, 30));
        label6.setForeground(Color.WHITE);
        add(label6);
        label6.setBounds(100, 450, 200, 50);

        branch.setFont(new Font("Serif", Font.BOLD, 20));
        branch.addItem("Tenkasi");
        branch.addItem("Pavoorchatram");
        branch.addItem("Surandai");
        add(branch);
        branch.setBounds(400, 450, 150, 40);

        label7.setFont(new Font("Monospaced", Font.BOLD, 30));
        label7.setForeground(Color.WHITE);
        add(label7);
        label7.setBounds(100, 530, 400, 50);

        txt5.setFont(new Font("Serif", Font.BOLD, 20));
        add(txt5);
        txt5.setBounds(400, 530, 150, 40);
        
        label13.setFont(new Font("Monospaced", Font.BOLD, 30));
        label13.setForeground(Color.WHITE);
        add(label13);
        label13.setBounds(100, 600, 400, 50);
        
        txt6.setFont(new Font("Serif", Font.BOLD, 20));
        add(txt6);
        txt6.setBounds(400, 600, 150, 40);

        label9.setFont(new Font("Serif", Font.BOLD, 30));
        label9.setCursor(new Cursor(Cursor.HAND_CURSOR));
        label9.setForeground(Color.WHITE);
        add(label9);
        label9.setBounds(700, 600, 100, 50);

        label10.setFont(new Font("Serif", Font.BOLD, 30));
        label10.setCursor(new Cursor(Cursor.HAND_CURSOR));
        label10.setForeground(Color.WHITE);
        add(label10);
        label10.setBounds(850, 600, 150, 50);

        label11.setFont(new Font("Serif", Font.BOLD, 30));
        label11.setCursor(new Cursor(Cursor.HAND_CURSOR));
        label11.setForeground(Color.WHITE);
        add(label11);
        label11.setBounds(1000, 600, 150, 50);

        //add(table);
        //table.setBounds(700, 100, 600, 400);
        id();
        label9.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                String url, uname, pwd;
                String acctnum = label8.getText();
                String fname = txt1.getText();
                String lname = txt2.getText();
                String str = txt3.getText();
                String city = txt4.getText();
                String brn = branch.getSelectedItem().toString();
                String phn = txt5.getText();
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");  //Itha file la load pannum 
                    url = "jdbc:mysql://localhost:3306/bank";
                    uname = "sample1";
                    pwd = "137731";
                    con = DriverManager.getConnection(url, uname, pwd);
                    ps = con.prepareStatement("insert into customer(accountnum,firstname,lastname,street,city,branch,phn) Values (?,?,?,?,?,?,?);");
                    ps.setString(1, acctnum);
                    ps.setString(2, fname);
                    ps.setString(3, lname);
                    ps.setString(4, str);
                    ps.setString(5, city);
                    ps.setString(6, brn);
                    ps.setString(7, phn);
                    int k = ps.executeUpdate();
                    if (k == 1) {
                        JOptionPane.showMessageDialog(null, "Account created Successfully");
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed");
                    }
                    insert();
                    clear();
                } catch (Exception ex) {
                    System.out.println(ex);
                }
                train();
            }
        });
        table.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                    "Account Number", "First Name", "Last Name", "Street", "City", "Branch", "Mobile number"
                }
        ));

        label12.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clear();
            }
        });
        
        label11.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String url,uname,pwd;
                String id=label8.getText();
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");  //Itha file la load pannum 
                    url = "jdbc:mysql://localhost:3306/bank";
                    uname = "sample1";
                    pwd = "137731";
                    con = DriverManager.getConnection(url, uname, pwd);
                    ps=con.prepareStatement("Delete from customer where accountnum=?;");
                    ps.setString(1,id);
                    
                    int k=ps.executeUpdate();
                    if(k==1){
                         JOptionPane.showMessageDialog(null, "Account Deleted Successfully");
                    }
                    else{
               
                             JOptionPane.showMessageDialog(null, "Failed");
                    }
                    delete();
                    clear();
               }
                catch(Exception ex){
                    System.out.println(ex);
                }
                train();
                
            }
        });
        
       
        

        label10.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String url, uname, pwd;
                String acctnum = label8.getText();
                String fname = txt1.getText();
                String lname = txt2.getText();
                String str = txt3.getText();
                String city = txt4.getText();
                String brn = branch.getSelectedItem().toString();
                String phn = txt5.getText();
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");  //Itha file la load pannum 
                    url = "jdbc:mysql://localhost:3306/bank";
                    uname = "sample1";
                    pwd = "137731";
                    con = DriverManager.getConnection(url, uname, pwd);
                    ps = con.prepareStatement("update customer set firstname=?,lastname=?,street=?,city=?,branch=?,phn=? where accountnum=?;");
                    ps.setString(1, fname);
                    ps.setString(2, lname);
                    ps.setString(3, str);
                    ps.setString(4, city);
                    ps.setString(5, brn);
                    ps.setString(6, phn);
                    ps.setString(7, acctnum);
                    int k = ps.executeUpdate();
                    if (k == 1) {
                        JOptionPane.showMessageDialog(null, "Account Updated Successfully");
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed");
                    }
                    clear();

                } catch (Exception ex) {
                    System.out.println(ex);
                }
                train();
            }
        });
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                DefaultTableModel d = (DefaultTableModel) table.getModel();
                int selectIndex = table.getSelectedRow();
                label8.setText(d.getValueAt(selectIndex, 0).toString());
                txt1.setText(d.getValueAt(selectIndex, 1).toString());
                txt2.setText(d.getValueAt(selectIndex, 2).toString());
                txt3.setText(d.getValueAt(selectIndex, 3).toString());
                txt4.setText(d.getValueAt(selectIndex, 4).toString());
                branch.setSelectedItem(d.getValueAt(selectIndex, 5).toString());
                txt5.setText(d.getValueAt(selectIndex, 6).toString());
            }
        });
        scroll.setViewportView(table);
        add(scroll);
        scroll.setBounds(600, 100, 700, 400);
        label12.setFont(new Font("Serif", Font.BOLD, 30));
        label12.setCursor(new Cursor(Cursor.HAND_CURSOR));
        label12.setForeground(Color.WHITE);
        add(label12);
        label12.setBounds(1200, 600, 150, 50);
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

        img.setIcon(new ImageIcon("C:\\Users\\ELCOT\\Documents\\NetBeansProjects\\Bank\\img24.jpg"));
        add(img);
        img.setBounds(-500, 0, 1900, 800);

    }

    public void train() {
        try {
            ps = con.prepareStatement("Select * from customer");
            rs = ps.executeQuery();
            ResultSetMetaData rsd = rs.getMetaData();
            int c;
            c = rsd.getColumnCount();
            DefaultTableModel d = (DefaultTableModel) table.getModel();
            d.setRowCount(0);
            while (rs.next()) {
                Vector v = new Vector();
                for (int i = 0; i <= c; i++) {
                    v.add(rs.getString("accountnum"));
                    v.add(rs.getString("firstname"));
                    v.add(rs.getString("lastname"));
                    v.add(rs.getString("city"));
                    v.add(rs.getString("street"));
                    v.add(rs.getString("branch"));
                    v.add(rs.getString("phn"));
                }
                d.addRow(v);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void id() {
        String url, uname, pwd;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  //Itha file la load pannum 
            url = "jdbc:mysql://localhost:3306/bank";
            uname = "sample1";
            pwd = "137731";
            con = DriverManager.getConnection(url, uname, pwd);
            Statement s = con.createStatement();
            rs = s.executeQuery("SELECT MAX(accountnum) FROM customer");
            rs.next();
            rs.getString("MAX(accountnum)");
            if (rs.getString("MAX(accountnum)") == null) {
                label8.setText("B001");

            } else {
                long id = Long.parseLong(rs.getString("MAX(accountnum)").substring(2, rs.getString("MAX(accountnum)").length()));
                id++;
                label8.setText("B" + String.format("%03d", id));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void clear() {
        label8.setText("");
        txt1.setText("");
        txt2.setText("");
        txt3.setText("");
        txt4.setText("");
        txt5.setText("");
        branch.setSelectedIndex(0);
        txt6.setText("");
    }
    public void insert(){
        String url, uname, pwd;
        String acctnum=label8.getText();
        String bal=txt6.getText();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  //Itha file la load pannum 
            url = "jdbc:mysql://localhost:3306/bank";
            uname = "sample1";
            pwd = "137731";
            con = DriverManager.getConnection(url, uname, pwd);
            ps = con.prepareStatement("insert into account(accountnum,balance) Values (?,?);");
            ps.setString(1, acctnum);
            ps.setString(2,bal);
            ps.executeUpdate();

        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
     public void delete(){
        String url,uname,pwd;
                String id=label8.getText();
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");  //Itha file la load pannum 
                    url = "jdbc:mysql://localhost:3306/bank";
                    uname = "sample1";
                    pwd = "137731";
                    con = DriverManager.getConnection(url, uname, pwd);
                    ps=con.prepareStatement("Delete from account where accountnum=?;");
                    ps.setString(1,id);
                    ps.executeUpdate();
                    
                }
                catch(Exception ex){
                    System.out.println(ex);
                }
                
            }
   

}


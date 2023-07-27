package bank;


    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import static bank.Account.label8;
 import java.sql.*;
import javax.swing.JOptionPane;

public class Adddbase implements Runnable {

    
    Connection con;
    ResultSet rs;
    String qry;
    Statement st;
    PreparedStatement pre;
    public static int id;
    public static String btname=" ";
     public Adddbase() {
        String url, uname, pwd;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  //Itha file la load pannum 
            url = "jdbc:mysql://localhost:3306/bank";
            uname = "sample1";
            pwd = "137731";
            con = DriverManager.getConnection(url, uname, pwd);
        } catch (Exception ex) {
            System.out.println("Error:" + ex);
        }
    }
     @Override
    public void run(){
        id=getId();
        Account.label8.setText("IOB"+id);
        if(btname.equals("Add")){
            add();
        }
        /*else if(btname.equals("Remove")){
            remove();
        }
        else if(btname.equals("Edit")){
            edit();
        }*/
        
    }
    public void add(){
//        System.out.println("Name :"+Home.d1.name);
//        System.out.println("Age :"+Home.d1.age);
//        System.out.println("Gender :"+Home.d1.gen);
//        System.out.println("Course :"+Home.d1.cor);
//        System.out.println("Address :"+Home.d1.add);
        qry="insert into customer(accountnum,firstname,lastname,street,city,branch,phn) Values (?,?,?,?,?,?,?);";
        try{
            pre=con.prepareStatement(qry);
            //pre.setInt(1,id);
            pre.setString(2,Account.label8.getText());
            pre.setString(3,Account.txt1.getText());
            pre.setString(4,Account.txt2.getText());
            pre.setString(5,Account.txt3.getText());
            pre.setString(6,Account.txt4.getText());
            pre.setString(6,Account.branch.getSelectedItem().toString());
            pre.setString(6,Account.txt5.getText());
            pre.execute();
            JOptionPane.showMessageDialog(null,"Added Successfully");
//            Adddbase.btname="";
//            Adddbase d1=new Adddbase();
//            Thread t1=new Thread(d1);
//            t1.start();
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }
   /*public void remove(){
       
       qry="Delete From detail Where id=?;";
       try{
           pre=con.prepareStatement(qry);
           pre.setString(1,Home.curid);
           pre.execute();
           JOptionPane.showMessageDialog(null,"Removed");
            Databs.btname="";
            Databs d1=new Databs();
            Thread t1=new Thread(d1);
            t1.start();
       }
       catch (Exception ex){
           System.out.println(ex);
       }
       
   }
   public void edit(){
       qry="Update detail set name = ?,age= ?,gender = ?,course = ?,city = ? Where id = ?;";
        try{
            pre=con.prepareStatement(qry);
  
            pre.setString(1,Home.d1.name);
            pre.setString(2,Home.d1.age);
            pre.setString(3,Home.d1.gen);
            pre.setString(4,Home.d1.cor);
            pre.setString(5,Home.d1.add);
            pre.setString(6,Home.curid);
            pre.execute();
            con.close();
            JOptionPane.showMessageDialog(null,"Edit Successfully");
            Databs.btname="";
            Databs d1=new Databs();
            Thread t1=new Thread(d1);
            t1.start();
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }*/

   
    public int getId(){
        int dId=0;
        try{
            qry="Select accountnum From customer ORDER BY id DESC LIMIT 1;";
            st=con.createStatement();
            rs=st.executeQuery(qry);
           if( rs.next()){
             dId =Integer.parseInt(rs.getString("id"));
           }
        }
        catch (Exception ex){
            System.out.println(ex);
        }
        if(dId>=0){
            return dId+1;
        }
        else{
        return 1;
        }
    }
    
}

    


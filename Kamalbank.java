
package kamalbank;
// note: please download mysql-connecter jav to implemet this code. otherwise it will not work. we need driver to connect with mysql.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.*;
public class Kamalbank {
    Scanner input = new Scanner(System.in);
    Connection conn = null;
    Statement stmt = null;
         
       
    public static void main(String[] args) {
       Scanner input = new Scanner(System.in);
       Kamalbank object = new Kamalbank();
       System.out.println(" \t Press 1 For registration....\t");
       System.out.println(" \t Press 2 For login....\t");
       System.out.println("Start from here.........");
       int number = input.nextInt();
       if(number == 1){
         object.registration();
       }
       else if(number == 2){
         object.login();
       }
       else{
       System.out.println("\t\t========================================================");
       System.out.println("\t\t\t please enter valid number...\t\t\t");
       System.out.println("\t\t\t\t Thanks...\t\t\t\t");
        System.out.println("\t\t========================================================");
       
       }
    }
    
//    for ragistation
//    create new methoed with name registration
    public void registration(){
         Scanner input = new Scanner(System.in);
         System.out.println("  ******* \t Welcome to Registration Form \t *******");
         Connection conn = null;
         Statement stmt = null;
         
         try{
              Class.forName("com.mysql.cj.jdbc.Driver");
              String URL = "jdbc:mysql://localhost:3308/bank";
              String USER = "root";
              String PASS = "Lalo@123"; 
              conn = DriverManager.getConnection(URL,USER,PASS);
              
              stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                           ResultSet.CONCUR_UPDATABLE);
              System.out.println(" enter your id ");
              String id = input.next();
//              check user id from user table
              
              String sql = "select * from users where user_id = '"+id+"'";
              ResultSet rs = stmt.executeQuery(sql);
              rs.next();
//              get number of row affected in sql....
              int row = rs.getRow();
              sql = "select * from users";
              rs = stmt.executeQuery(sql);
              rs.next();
//              check user id column from table and compare user_id with entered user id bu user. if both user id same then give output. 
              String check_id = rs.getString("user_id");
              
              if(row > 0){
                if(row > 0){
//          check user id from user table  until user enter different user id
                do{
                   System.out.println(" enter your id ");
                   id = input.next();

              
              sql = "select * from users where user_id = '"+id+"'";
              rs = stmt.executeQuery(sql);
              rs.next();
              row = rs.getRow();
              sql = "select * from users";
              
              rs = stmt.executeQuery(sql);
              rs.next();
              check_id = rs.getString("user_id"); 
                }
                while(row > 0);
                }
              System.out.println(" enter your First name..");
              String fn = input.next();
              
              System.out.println(" enter your Last name..");
              String ln = input.next();
              
              System.out.println(" enter your email address..");
              String email = input.next();
              
              System.out.println(" enter your phone number..");
              String phone = input.next();
              
              System.out.println(" enter your password.. ");
              String p = input.next();
              
              Date crnt_date = new Date();
              SimpleDateFormat dt = new SimpleDateFormat("E dd.MM.yyyy  hh:mm:ss a zzz");
              String current_date = dt.format(crnt_date);
              
              sql = "create table "+id+" (No int(10) primary key auto_increment,date_time varchar(100) not null,Message varchar(100) null,Deposite double not null,Withdrow double not null,Total_balance double not null)";
              stmt.executeUpdate(sql);
              sql = "insert into "+id+" (date_time,Message,Deposite,withdrow,total_balance) value(?,null,0.00,0.00,0.00)";
              PreparedStatement pstmt = conn.prepareStatement(sql);
              
              pstmt.setString(1,current_date);
              pstmt.executeUpdate();
              
              sql = "insert into users value(?,?,?,?,?,?,floor(rand()*1000000000),0.00,?)";
              pstmt = conn.prepareStatement(sql);
              pstmt.setString(1,id);
              pstmt.setString(2,fn);
              pstmt.setString(3,ln);
              pstmt.setString(4,p);
              pstmt.setString(5,phone);
              pstmt.setString(6,email);
              pstmt.setString(7,current_date);
             
              pstmt.executeUpdate();
          
              System.out.println("\t\t========================================================================================\t\t");
              System.out.println(" \t\t\tcongratulations ! " +fn+ " you successfully registered \t\t\t");
              System.out.println("\t\t========================================================================================\t\t");
                
              
              }else{
              
              System.out.println(" enter your First name..");
              String fn = input.next();
              
              System.out.println(" enter your Last name..");
              String ln = input.next();
              
              System.out.println(" enter your email address..");
              String email = input.next();
              
              System.out.println(" enter your phone number..");
              String phone = input.next();
              
              System.out.println(" enter your password.. ");
              String p = input.next();
              
               
              Date crnt_date = new Date();
              SimpleDateFormat dt = new SimpleDateFormat("E dd.MM.yyyy  hh:mm:ss a zzz");
              String current_date = dt.format(crnt_date);
              
              sql = "create table "+id+" (No int(10) primary key auto_increment,date_time varchar(100) not null,Message varchar(100) null,Deposite double not null,Withdrow double not null,Total_balance double not null)";
              stmt.executeUpdate(sql);
              sql = "insert into "+id+" (date_time,Message,Deposite,withdrow,total_balance) value(?,null,0.00,0.00,0.00)";
              PreparedStatement pstmt = conn.prepareStatement(sql);
              
              pstmt.setString(1,current_date);
              pstmt.executeUpdate();
              
              
              sql = "insert into users value(?,?,?,?,?,?,floor(rand()*1000000000),0.00,?)";
              pstmt = conn.prepareStatement(sql);
              pstmt.setString(1,id);
              pstmt.setString(2,fn);
              pstmt.setString(3,ln);
              pstmt.setString(4,p);
              pstmt.setString(5,phone);
              pstmt.setString(6,email);
              pstmt.setString(7,current_date);
             
              pstmt.executeUpdate();
          
            
              System.out.println("\t\t==========================================================================================\t\t");
              System.out.println(" \t\t\tcongratulations ! " +fn+ " you successfully registered \t\t\t");
              System.out.println("\t\t==========================================================================================\t\t");
                
             
              }
         }catch(Exception e){
             System.out.println(" your mistake---" +e.getMessage());
         }
    }
//    login funcationality......
    public void login(){
         try{
              Class.forName("com.mysql.cj.jdbc.Driver");
              String URL = "jdbc:mysql://localhost:3308/bank";
              String USER = "root";
              String PASS = "Lalo@123"; 
              conn = DriverManager.getConnection(URL,USER,PASS);
              
              stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                           ResultSet.CONCUR_UPDATABLE);
              
              System.out.println("enter your user id please....");
              String id = input.next();
     
              System.out.println("enter your password please....");
              String p = input.next();
              
              String sql = "select * from users where user_id = '"+id+"' and password = '"+p+"'";
              ResultSet rs = stmt.executeQuery(sql);
              rs.next();
              int row = rs.getRow();
              if(row > 0){
               System.out.println("\t\t========================================================");
               System.out.println(" \t\t\t\t login Successful....\t\t\t");
               System.out.println("\t\t========================================================");
               
               System.out.println("press 1 : For deposite money .......");
               System.out.println("press 2 : For Withdrow money .......");
               System.out.println("press 3 : For transfer money to your friend .......");
               System.out.println("press 4 : For View-transcation.......");
              
               
               System.out.println("===============================================================");
               
               System.out.println(" press here..");
               int number = input.nextInt();
               System.out.println("===============================================================");
//       for deposite money into account......        
               if(number == 1){
                  
                  System.out.println(" How much Dollar Do you want to deposite ? ");
                  double dollar = input.nextDouble();
                  if(dollar < 0){
                  System.out.println("\t\t========================================================");
                  System.out.println(" \t\t\t Transaction has been failed....\t\t\t");
                  System.out.println(" \t\t\t you can not enter negative value...\t\t\t");
                  System.out.println("\t\t========================================================");
                  }
                  else if(dollar == 0){}
                  else{
                  System.out.println(" Message ");
                  String m = input.next();
                  
                    Date crnt_date = new Date();
                    SimpleDateFormat dt = new SimpleDateFormat("E dd.MM.yyyy  hh:mm:ss a zzz");
                    String current_date = dt.format(crnt_date);
                   
                  sql = "select * from "+id+"";
      
                  rs = stmt.executeQuery(sql);
                  rs.last();
                  
                  double bln = rs.getDouble("total_balance");
                  sql = "update users set total_balance = total_balance + "+dollar+" where user_id = '"+id+"' and password = '"+p+"'";
                  stmt.executeUpdate(sql);
                  sql = "insert into "+id+"(date_time,Message,Deposite,withdrow,total_balance) value(?,?,?,0.00,?)";
                  PreparedStatement pstmt= conn.prepareStatement(sql);
                  
                  pstmt.setString(1, current_date);
                  pstmt.setString(2, m);
                  pstmt.setDouble(3, dollar);
                  pstmt.setDouble(4, bln + dollar);
                  pstmt.executeUpdate();
                  
                  sql = "select * from "+id+"";
                  rs = stmt.executeQuery(sql);
                  rs.last();
                  
                  Double tbln = rs.getDouble("total_balance");
                  System.out.println("\t\t===============================================================\t\t");
                  System.out.println(" \t\t\t your balance is $" +tbln+ " \t\t\t ");
                  System.out.println("\t\t===============================================================\t\t");
                }
               }
// for withdrow money from account.....
               else if(number == 2){

                  System.out.println(" How much Dollar Do you want to Withdrow ? ");
                  double dollar = input.nextDouble();
                  if(dollar < 0){
                  System.out.println("\t\t========================================================");
                  System.out.println(" \t\t\t Transaction has been failed....\t\t\t");
                  System.out.println(" \t\t\t you can not enter negative value...\t\t\t");
                  System.out.println("\t\t========================================================");
                  }
                  else if(dollar == 0){
                  
                  }
                  else{
                  sql = "select * from users where user_id = '"+id+"' and password = '"+p+"'";
                  rs = stmt.executeQuery(sql);
                  rs.next();
                  double balance = rs.getDouble("total_balance");
                  
                  if(balance < 0 ){
                  System.out.println("\t\t===============================================================\t\t");    
                  System.out.println(" \t\t\t Transaction has been failed....\t\t\t");
                  System.out.println(" \t\t\t you do not have sufficient balance...\t\t\t");
                  System.out.println("\t\t===============================================================\t\t");
                  }
                  else if(balance < dollar){
                  System.out.println("\t\t========================================================");
                  System.out.println(" \t\t\t Transaction has been failed....\t\t\t");
                  System.out.println(" \t\t\t you do not have sufficient balance...\t\t\t");
                  System.out.println("\t\t========================================================");
                  }
                  else{
                  System.out.println(" Message ");
                  String m = input.next();
                  
                    Date crnt_date = new Date();
                    SimpleDateFormat dt = new SimpleDateFormat("E dd.MM.yyyy  hh:mm:ss a zzz");
                    String current_date = dt.format(crnt_date);
                   
                  sql = "select * from "+id+"";
      
                  rs = stmt.executeQuery(sql);
                  rs.last();
                  
                  double bln = rs.getDouble("total_balance");
                  sql = "update users set total_balance = total_balance - "+dollar+" where user_id = '"+id+"' and password = '"+p+"'";
                  stmt.executeUpdate(sql);
                  sql = "insert into "+id+"(date_time,Message,Deposite,withdrow,total_balance) value(?,?,0.00,?,?)";
                  PreparedStatement pstmt= conn.prepareStatement(sql);
                  
                  pstmt.setString(1, current_date);
                  pstmt.setString(2, m);
                  pstmt.setDouble(3, dollar);
                  pstmt.setDouble(4, bln - dollar);
                  pstmt.executeUpdate();
                  
                  sql = "select * from "+id+"";
                  rs = stmt.executeQuery(sql);
                  rs.last();
                  
                  Double tbln = rs.getDouble("total_balance");
                  System.out.println("\t\t===============================================================");
                  System.out.println(" \t\t\t your balance is $" +tbln+ "\t\t\t");
                  System.out.println("\t\t===============================================================");
                }
                  }
               }
//               for transfer money .....
               else if(number == 3){

                  System.out.println(" How much Dollar Do you want to transfer ? ");
                  double dollar = input.nextDouble();
                  if(dollar < 0){
                  System.out.println("\t\t========================================================");
                  System.out.println(" \t\t\t Transaction has been failed....\t\t\t");
                  System.out.println(" \t\t\t you can not enter negative value...\t\t\t");
                  System.out.println("\t\t========================================================");
                  }
                  else{
                  sql = "select * from users where user_id = '"+id+"' and password = '"+p+"'";
                  rs = stmt.executeQuery(sql);
                  rs.next();
                  double balance = rs.getDouble("total_balance");
                  
                  if(balance < 0 ){
                  System.out.println("\t\t===============================================================");    
                  System.out.println(" \t\t\t Transaction has been failed....\t\t\t");
                  System.out.println(" \t\t\t you do not have sufficient balance...\t\t\t");
                  System.out.println("\t\t===============================================================");
                  }
                  else if(balance < dollar){
                  System.out.println("\t\t========================================================");    
                  System.out.println(" \t\t\t Transaction has been failed....\t\t\t");
                  System.out.println(" \t\t\t you do not have sufficient balance...\t\t\t");
                  System.out.println("\t\t========================================================");
                  }
                  else{
                  System.out.println(" Message ");
                  String m = input.next();
                  
                    Date crnt_date = new Date();
                    SimpleDateFormat dt = new SimpleDateFormat("E dd.MM.yyyy  hh:mm:ss a zzz");
                    String current_date = dt.format(crnt_date);
                   
                  
                  System.out.println(" enter your friends user id....");
                  String friend_id = input.next();
                  
                  sql = "select * from users where user_id = '"+friend_id+"'";
                  rs = stmt.executeQuery(sql);
                  rs.next();
                  row = rs.getRow();
                  if(row > 0){
                  sql = "select * from "+id+"";
                  rs = stmt.executeQuery(sql);
                  rs.last();    
                  double bln = rs.getDouble("total_balance");
                  sql = "update users set total_balance = total_balance - "+dollar+" where user_id = '"+id+"' and password = '"+p+"'";
                  stmt.executeUpdate(sql);
                  sql = "insert into "+id+"(date_time,Message,Deposite,withdrow,total_balance) value(?,?,0.00,?,?)";
                  PreparedStatement pstmt= conn.prepareStatement(sql);
                  
                  pstmt.setString(1, current_date);
                  pstmt.setString(2, m);
                  pstmt.setDouble(3, dollar);
                  pstmt.setDouble(4, bln - dollar);
                  pstmt.executeUpdate();
                  
                 
                  
                   sql = "select * from "+friend_id+"";
      
                   rs = stmt.executeQuery(sql);
                   rs.last();
                  
                  bln = rs.getDouble("total_balance");
                  sql = "update users set total_balance = total_balance + "+dollar+" where user_id = '"+friend_id+"'";
                  stmt.executeUpdate(sql);
                  sql = "insert into "+friend_id+"(date_time,Message,Deposite,withdrow,total_balance) value(?,?,?,0.00,?)";
                  pstmt= conn.prepareStatement(sql);
                  
                  pstmt.setString(1, current_date);
                  pstmt.setString(2, m);
                  pstmt.setDouble(3, dollar);
                  pstmt.setDouble(4, bln + dollar);
                  pstmt.executeUpdate();
                  
                  sql = "select * from "+friend_id+"";
                  rs = stmt.executeQuery(sql);
                  rs.last();
                  
                  Double total_bln = rs.getDouble("total_balance");

                  }
                  else{
                  System.out.println("\t\t========================================================");    
                  System.out.println("\t\t\t sorry! transaction has been failed.....");
                  System.out.println("\t\t\t user id has not match...");
                  System.out.println("\t\t========================================================"); 
                  
                  
                  sql = "select * from "+id+"";
                  rs = stmt.executeQuery(sql);
                  rs.last();
                  
                  
                  
                  System.out.println("\t\t===============================================================");
                  System.out.println(" \t\t\t your balance is $" +balance+ "\t\t\t");
                  System.out.println("\t\t===============================================================");
                  
                  }
                  sql = "select * from "+id+"";
                  rs = stmt.executeQuery(sql);
                  rs.last();
                  
                  Double tbln = rs.getDouble("total_balance");
                  sql = "select * from users where user_id = '"+friend_id+"'";
                  rs = stmt.executeQuery(sql);
                  rs.next();
                  String FName = rs.getString("first_name");
                  String LName = rs.getString("last_name");
                  String pnum = rs.getString("phone_number");
                  
                 
                  System.out.println("\t\t===============================================================");
                  System.out.println("\t\t\t you successfully transfered "+dollar+" to "+FName+"  "+LName+"");
                  System.out.println("\t\t\t "+FName+"  "+LName+"'s Phone-number - "+pnum+"");
                  System.out.println("\t\t===============================================================");
                  
                  System.out.println("\t\t===============================================================");
                  System.out.println(" \t\t\t your balance is $" +tbln+ "\t\t\t");
                  System.out.println("\t\t===============================================================");
                }
                  } 
                  

               }
//               see your privious transcation..............
               else if(number == 4){
               System.out.println("enter your user id please....");
               id = input.next();
     
              System.out.println("enter your password please....");
               p = input.next();
              
              sql = "select * from users where user_id = '"+id+"' and password = '"+p+"'";
              rs = stmt.executeQuery(sql);
              rs.next();
              row = rs.getRow();
              if(row > 0){
                  System.out.println(" How many  privious transactions do you want to see ? ");
                  int n = input.nextInt();
                  sql = "select date_time,Message,Deposite,withdrow,total_balance from "+id+" order by No desc limit "+n+"";
                  rs = stmt.executeQuery(sql);
                  
                   System.out.println("\n");
                      System.out.print("\tDate & Time\t\t");
                      System.out.print(" \t Deposite \t ");
                      System.out.print(" \t Withdrow \t ");
                      System.out.print("  \t Total-Balance \t");
                      System.out.println(" \t Message ");
                      System.out.println("\n"); 
                  while(rs.next()){
                  
                      String dt = rs.getString("date_time");
                      String msg = rs.getString("Message");
                      Double dipo = rs.getDouble("Deposite");
                      Double wdrow = rs.getDouble("withdrow");
                      Double t_check_balance = rs.getDouble("total_balance");
                      
                      
                      System.out.print(dt+ "\t | \t");
                      System.out.print(dipo+ "\t \t| \t");
                      System.out.print(wdrow+ "\t \t| \t");
                      System.out.print(t_check_balance+ "\t \t | \t");
                      System.out.println(msg);
                      
                      System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                  
                  }
                  
               }
               }
               
               
               
              }else{
                System.out.println("\t\t========================================================");
                System.out.println(" \t\t\t\t login UnSuccessful....\t\t\t");
                System.out.println("\t\t========================================================");
                System.out.println(" please try again...");
                
                 try{
              
              
              stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                           ResultSet.CONCUR_UPDATABLE);
              
              System.out.println("enter your user id please....");
              id = input.next();
     
              System.out.println("enter your password please....");
               p = input.next();
              
              sql = "select * from users where user_id = '"+id+"' and password = '"+p+"'";
              rs = stmt.executeQuery(sql);
              rs.next();
              row = rs.getRow();
              if(row > 0){
               System.out.println("\t\t========================================================");
               System.out.println(" \t\t\t\t login Successful....\t\t\t");
               System.out.println("\t\t========================================================");
               
               System.out.println("press 1 : For deposite money .......");
               System.out.println("press 2 : For Withdrow money .......");
               System.out.println("press 3 : For transfer money to your friend .......");
               System.out.println("press 4 : For View-transcation.......");
              
               
               System.out.println("===============================================================");
               
               System.out.println(" press here..");
               int number = input.nextInt();
               System.out.println("===============================================================");
               
               if(number == 1){

                  System.out.println(" How much Dollar Do you want to deposite ? ");
                  double dollar = input.nextDouble();
                  if(dollar < 0){
                  System.out.println("\t\t========================================================");
                  System.out.println(" \t\t\t Transaction has been failed....\t\t\t");
                  System.out.println(" \t\t\t you can not enter negative value...\t\t\t");
                  System.out.println("\t\t========================================================");
                  }
                  else{
                  System.out.println(" Message ");
                  String m = input.next();
                  
                    Date crnt_date = new Date();
                    SimpleDateFormat dt = new SimpleDateFormat("E dd.MM.yyyy  hh:mm:ss a zzz");
                    String current_date = dt.format(crnt_date);
                   
                  sql = "select * from "+id+"";
      
                  rs = stmt.executeQuery(sql);
                  rs.last();
                  
                  double bln = rs.getDouble("total_balance");
                  sql = "update users set total_balance = total_balance + "+dollar+" where user_id = '"+id+"' and password = '"+p+"'";
                  stmt.executeUpdate(sql);
                  sql = "insert into "+id+"(date_time,Message,Deposite,withdrow,total_balance) value(?,?,?,0.00,?)";
                  PreparedStatement pstmt= conn.prepareStatement(sql);
                  
                  pstmt.setString(1, current_date);
                  pstmt.setString(2, m);
                  pstmt.setDouble(3, dollar);
                  pstmt.setDouble(4, bln + dollar);
                  pstmt.executeUpdate();
                  
                  sql = "select * from "+id+"";
                  rs = stmt.executeQuery(sql);
                  rs.last();
                  
                  Double tbln = rs.getDouble("total_balance");
                  System.out.println("\t\t===============================================================");
                  System.out.println(" \t\t\t your balance is $" +tbln+ " \t\t\t ");
                  System.out.println("\t\t===============================================================");
                }
               }
               else if(number == 2){

                  System.out.println(" How much Dollar Do you want to Withdrow ? ");
                  double dollar = input.nextDouble();
                  if(dollar < 0){
                  System.out.println("\t\t========================================================");
                  System.out.println(" \t\t\t Transaction has been failed....\t\t\t");
                  System.out.println(" \t\t\t you can not enter negative value...\t\t\t");
                  System.out.println("\t\t========================================================");
                  }
                  
                  else{
                  sql = "select * from users where user_id = '"+id+"' and password = '"+p+"'";
                  rs = stmt.executeQuery(sql);
                  rs.next();
                  double balance = rs.getDouble("total_balance");
                  
                  if(balance < 0 ){
                  System.out.println("\t\t===============================================================");    
                  System.out.println(" \t\t\t Transaction has been failed....\t\t\t");
                  System.out.println(" \t\t\t you do not have sufficient balance...\t\t\t");
                  System.out.println("\t\t===============================================================");
                  }
                  else if(balance < dollar){
                  System.out.println("\t\t========================================================");    
                  System.out.println(" \t\t Transaction has been failed....\t\t");
                  System.out.println(" \t\t you do not have sufficient balance...\t\t");
                  System.out.println("\t\t========================================================");
                  }
                  else{
                  System.out.println(" Message ");
                  String m = input.next();
                  
                    Date crnt_date = new Date();
                    SimpleDateFormat dt = new SimpleDateFormat("E dd.MM.yyyy  hh:mm:ss a zzz");
                    String current_date = dt.format(crnt_date);
                   
                  sql = "select * from "+id+"";
      
                  rs = stmt.executeQuery(sql);
                  rs.last();
                  
                  double bln = rs.getDouble("total_balance");
                  sql = "update users set total_balance = total_balance - "+dollar+" where user_id = '"+id+"' and password = '"+p+"'";
                  stmt.executeUpdate(sql);
                  sql = "insert into "+id+"(date_time,Message,Deposite,withdrow,total_balance) value(?,?,0.00,?,?)";
                  PreparedStatement pstmt= conn.prepareStatement(sql);
                  
                  pstmt.setString(1, current_date);
                  pstmt.setString(2, m);
                  pstmt.setDouble(3, dollar);
                  pstmt.setDouble(4, bln - dollar);
                  pstmt.executeUpdate();
                  
                  sql = "select * from "+id+"";
                  rs = stmt.executeQuery(sql);
                  rs.last();
                  
                  Double tbln = rs.getDouble("total_balance");
                  System.out.println("\t\t===============================================================");
                  System.out.println(" \t\t\t your balance is $" +tbln+ "\t\t\t");
                  System.out.println("\t\t===============================================================");
                }
                  }
               }
               else if(number == 3){
                System.out.println(" How much Dollar Do you want to transfer ? ");
                  double dollar = input.nextDouble();
                  if(dollar < 0){
                  System.out.println("\t\t========================================================");
                  System.out.println(" \t\t\t Transaction has been failed....\t\t\t");
                  System.out.println(" \t\t\t you can not enter negative value...\t\t\t");
                  System.out.println("\t\t========================================================");
                  }
                  else{
                  sql = "select * from users where user_id = '"+id+"' and password = '"+p+"'";
                  rs = stmt.executeQuery(sql);
                  rs.next();
                  double balance = rs.getDouble("total_balance");
                  
                  if(balance < 0 ){
                  System.out.println("\t\t===============================================================");    
                  System.out.println(" \t\t\t Transaction has been failed....\t\t\t");
                  System.out.println(" \t\t\t you do not have sufficient balance...\t\t\t");
                  System.out.println("\t\t===============================================================");
                  }
                  else if(balance < dollar){
                  System.out.println("\t\t========================================================");    
                  System.out.println(" \t\t\t Transaction has been failed....\t\t\t");
                  System.out.println(" \t\t\t you do not have sufficient balance...\t\t\t");
                  System.out.println("\t\t========================================================");
                  }
                  else{
                  System.out.println(" Message ");
                  String m = input.next();
                  
                    Date crnt_date = new Date();
                    SimpleDateFormat dt = new SimpleDateFormat("E dd.MM.yyyy  hh:mm:ss a zzz");
                    String current_date = dt.format(crnt_date);
                   
                  
                  System.out.println(" enter your friends user id....");
                  String friend_id = input.next();
                  
                  sql = "select * from users where user_id = '"+friend_id+"'";
                  rs = stmt.executeQuery(sql);
                  rs.next();
                  row = rs.getRow();
                  if(row > 0){
                  sql = "select * from "+id+"";
                  rs = stmt.executeQuery(sql);
                  rs.last();    
                  double bln = rs.getDouble("total_balance");
                  sql = "update users set total_balance = total_balance - "+dollar+" where user_id = '"+id+"' and password = '"+p+"'";
                  stmt.executeUpdate(sql);
                  sql = "insert into "+id+"(date_time,Message,Deposite,withdrow,total_balance) value(?,?,0.00,?,?)";
                  PreparedStatement pstmt= conn.prepareStatement(sql);
                  
                  pstmt.setString(1, current_date);
                  pstmt.setString(2, m);
                  pstmt.setDouble(3, dollar);
                  pstmt.setDouble(4, bln - dollar);
                  pstmt.executeUpdate();
                  
                 
                  
                   sql = "select * from "+friend_id+"";
      
                   rs = stmt.executeQuery(sql);
                   rs.last();
                  
                  bln = rs.getDouble("total_balance");
                  sql = "update users set total_balance = total_balance + "+dollar+" where user_id = '"+friend_id+"'";
                  stmt.executeUpdate(sql);
                  sql = "insert into "+friend_id+"(date_time,Message,Deposite,withdrow,total_balance) value(?,?,?,0.00,?)";
                  pstmt= conn.prepareStatement(sql);
                  
                  pstmt.setString(1, current_date);
                  pstmt.setString(2, m);
                  pstmt.setDouble(3, dollar);
                  pstmt.setDouble(4, bln + dollar);
                  pstmt.executeUpdate();
                  
                  sql = "select * from "+friend_id+"";
                  rs = stmt.executeQuery(sql);
                  rs.last();
                  
                  Double total_bln = rs.getDouble("total_balance");

                  }
                  else{
                  System.out.println("\t\t========================================================");    
                  System.out.println("\t\t\t sorry! transaction has been failed.....");
                  System.out.println("\t\t\t user id has not match...");
                  System.out.println("\t\t========================================================"); 
                
                  
                  sql = "select * from "+id+"";
                  rs = stmt.executeQuery(sql);
                  rs.last();
                  
                  
                  
                  System.out.println("\t\t===============================================================");
                  System.out.println(" \t\t\t your balance is $" +balance+ "\t\t\t");
                  System.out.println("\t\t===============================================================");
                  
                  }
                  sql = "select * from "+id+"";
                  rs = stmt.executeQuery(sql);
                  rs.last();
                  
                  Double tbln = rs.getDouble("total_balance");
                  sql = "select * from users where user_id = '"+friend_id+"'";
                  rs = stmt.executeQuery(sql);
                  rs.next();
                  String FName = rs.getString("first_name");
                  String LName = rs.getString("last_name");
                  String pnum = rs.getString("phone_number");
                  
                 
                  System.out.println("\t\t===============================================================");
                  System.out.println("\t\t\t you successfully transfered "+dollar+" to "+FName+"  "+LName+"");
                  System.out.println("\t\t\t "+FName+"  "+LName+"'s Phone-number - "+pnum+"");
                  System.out.println("\t\t===============================================================");
                  
                  System.out.println("\t\t===============================================================");
                  System.out.println(" \t\t\t your balance is $" +tbln+ "\t\t\t");
                  System.out.println("\t\t===============================================================");
                }
                  }

               }
               else if(number == 4){
               System.out.println("enter your user id please....");
               id = input.next();
     
              System.out.println("enter your password please....");
               p = input.next();
              
              sql = "select * from users where user_id = '"+id+"' and password = '"+p+"'";
              rs = stmt.executeQuery(sql);
              rs.next();
              row = rs.getRow();
              if(row > 0){
                  System.out.println(" How many privious transactions do you want to see ?");
                  int n = input.nextInt();
                  sql = "select date_time,Message,Deposite,withdrow,total_balance from "+id+" order by No desc limit "+n+"";
                  rs = stmt.executeQuery(sql);
                  
                   System.out.println("\n");
                      System.out.print("\tDate & Time\t\t");
                      System.out.print(" \t Deposite \t ");
                      System.out.print(" \t Withdrow \t ");
                      System.out.print("  \t Total-Balance \t");
                      System.out.println(" \t Message ");
                      System.out.println("\n"); 
                  while(rs.next()){
                  
                      String dt = rs.getString("date_time");
                      String msg = rs.getString("Message");
                      Double dipo = rs.getDouble("Deposite");
                      Double wdrow = rs.getDouble("withdrow");
                      Double t_check_balance = rs.getDouble("total_balance");
                      
                      
                      System.out.print(dt+ "\t | \t");
                      System.out.print(dipo+ "\t \t| \t");
                      System.out.print(wdrow+ "\t \t| \t");
                      System.out.print(t_check_balance+ "\t \t | \t");
                      System.out.println(msg);
                      
                      System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                  
                  }
                  
               }
               }
               
               
               
              }else{
                System.out.println("\t\t========================================================");
                System.out.println(" \t\t\t\t login UnSuccessful....\t\t\t");
                System.out.println("\t\t========================================================");
                
                System.out.println(" press 1 : If Forget Password....");
                
                System.out.println("\t\t========================================================");
                System.out.println(" Press here....");
                int number = input.nextInt();
                System.out.println("\t\t========================================================");
                if(number == 1){ 
             
              System.out.println(" enter your phone number..");
              String phone = input.next();
            
              System.out.println("enter your user id please....");
              id = input.next();  
                
               sql = "select * from users where user_id = '"+id+"' and phone_number = '"+phone+"' ";
               rs = stmt.executeQuery(sql);
               rs.next();
               row = rs.getRow();
               if(row > 0){
                   System.out.println(" please enter your new password....");
                   String new_password = input.next();
                 sql = "update users set password = '"+new_password+"' where user_id = '"+id+"' and phone_number = '"+phone+"' ";
                 stmt.executeUpdate(sql);
                 System.out.println("\t\t========================================================");
                 System.out.println("\t\t\t you successfully reset new password...\t\t\t");
                 System.out.println("\t\t========================================================");
               }
              }
                else{
                System.out.println("\t\t========================================================");    
                System.out.println("\t\t\t please enter valid number....\t\t\t");
                System.out.println("\t\t========================================================");
                }
          
              
              }
                 
            }
            catch(Exception e){
                System.out.println(" your mistake--" +e.getMessage());
        
           }    
                
              }

            }
            catch(Exception e){
                System.out.println(" your mistake--" +e.getMessage());
        
           }    
     
     
     
    }
    
 
}


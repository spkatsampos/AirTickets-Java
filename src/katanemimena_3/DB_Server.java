
package katanemimena_3;

import java.net.*;
import java.io.*;

//import java.*;
import java.sql.*;

public class DB_Server {

    public static void main(String[] args) {
       // ServerSocket Server2 = null;

        try {
            ////////////////
          /*  Server2 = new ServerSocket(5050); //dimiourgoume socket gia ton server
            Socket Server1;
            Server1 = Server2.accept(); //perimenoume na sindethei kapoios client*/
            
            /////////////////////
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:test.db");
            Statement stat = conn.createStatement();
            stat.executeUpdate("drop table if exists flights;");
            stat.executeUpdate("create table flights(num_flight,from,to,num_seats,month1,day1,month2,day2,time,price);");
            PreparedStatement prep =conn.prepareStatement("insert into flights values (?,?,?,?,?,?,?,?,?,?);");

            prep.setString(1,"1");
            prep.setString(2,"ATH");
            prep.setString(3,"SMI");
            prep.setString(4,"20");
            prep.setString(5,"Jan");
            prep.setString(6,"5");
            prep.setString(7,"Feb");
            prep.setString(8,"20");
            prep.setString(9,"12:30");
            prep.setString(10,"100");
            prep.addBatch();


            conn.setAutoCommit(false);
            prep.executeBatch();


            ResultSet rs = stat.executeQuery("select * from flights;");
            while (rs.next()) {
                System.out.println("num_flight = " + rs.getString("num_flight"));
                System.out.println("from = " + rs.getString("from"));
                System.out.println("to = " + rs.getString("to"));
                System.out.println("num_seats= " + rs.getString("num_seats"));
                System.out.println("month1= " + rs.getString("month1"));
                System.out.println("day1 = " + rs.getString("day1"));
                System.out.println("month2= " + rs.getString("month2"));
                System.out.println("day2= " + rs.getString("day2"));
                System.out.println("time= " + rs.getString("time"));
                System.out.println("price= " + rs.getString("price"));
            }//while

            rs.close();
            conn.close();




        }//try
        catch (ClassNotFoundException s) {
            System.out.println("ClassNotFoundException");
        }//catch
        catch (SQLException s) {
            System.out.println("SQLException");
        }//catch
       // catch (IOException e) {
            //System.err.println("IO error ServerSocket" + e);

        //}//catch
    }//main
}//class


package katanemimena_3;

import java.net.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class Server_DB_Thread {

    Socket DB = null;

    public Server_DB_Thread(Socket db) {
        super("Server_DB");
        this.DB = db;
    }

    public void run() {


        try {
            ////////////////
            ObjectInputStream in = new ObjectInputStream(DB.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(DB.getOutputStream());


            /////////////////////
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:test.db");
            Statement stat = conn.createStatement();
            stat.executeUpdate("drop table if exists flights;");
            stat.executeUpdate("create table flights(num_flight,from,to,num_seats,month1,day1,month2,day2,time,price);");
            PreparedStatement prep = conn.prepareStatement("insert into flights values (?,?,?,?,?,?,?,?,?,?);");

            prep.setInt(1, 1);
            prep.setString(2, "ATH");
            prep.setString(3, "SMI");
            prep.setInt(4, 20);
            prep.setString(5, "Jan");
            prep.setString(6, "5");
            prep.setString(7, "Feb");
            prep.setString(8, "20");
            prep.setString(9, "12:30");
            prep.setInt(10, 100);
            prep.addBatch();


            conn.setAutoCommit(false);
            prep.executeBatch();



            /*while (rs.next()) {
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
            }//while*/

            Communication com = null;
            ////////////////pigenofermata////////////////////////
            com = (Communication) in.readObject();
            ResultSet rs = stat.executeQuery("select * from flights where from=com.getfrom() and to=com.getto() and num_seats=com.getnum_seats() and month1=com.getmonth1() and day1=com.getday1() and month2=com.getmonth2() and day2=com.getday2();");

            ArrayList<Communication> myarr = new ArrayList<Communication>();
            while (rs.next()) {
                com.setnum_flight(rs.getInt("num_flight"));
                com.setfrom(rs.getString("from"));
                com.setto(rs.getString("to"));
                com.setnum_seats(rs.getInt("num_seats"));
                com.setmonth1(rs.getString("month1"));
                com.setday1(rs.getString("day1"));
                com.setmonth2(rs.getString("month2"));
                com.setday2(rs.getString("day2"));
                com.settime(rs.getString("time"));
                com.setprice(rs.getInt("price"));

                myarr.add(com);

            }

            out.writeObject(myarr);






























            rs.close();
            conn.close();




        }//try
        catch (ClassNotFoundException s) {
            System.out.println("ClassNotFoundException");
        }//catch
        catch (SQLException s) {
            System.out.println("SQLException");
        }//catch
        catch (IOException e) {
            System.err.println("IO error ServerSocket" + e);

        }//catch
    }//main
}//class


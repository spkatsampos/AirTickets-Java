

package katanemimena_3;

import java.net.*;
import java.io.*;

public class Server_DB {

     public static void main(String[] args) throws IOException {
        ServerSocket db = null;
        boolean bool = true;

        try {
            db = new ServerSocket(25200);//dimiourgoume ena socket gia ton server
        } catch (IOException e) {
            System.err.println("IOerror");

        }

        while (bool) {//oso einai true (gia panta)
            Server_DB_Thread DBS = new Server_DB_Thread(db.accept());// dimiourgoume antikeimeno tupou kkmultipleserver
            DBS.start();                                                         // ksekiname ti run gia to antikeimeno tou kkmultipleserver
        }
        db.close(); //kleinoume to socket
    }



}

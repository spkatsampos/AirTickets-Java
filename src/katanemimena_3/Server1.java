package katanemimena_3;

import java.io.*;
import java.net.*;
import java.rmi.*;
import java.rmi.server.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server1 extends UnicastRemoteObject implements FlightsInt {

    //i sinartisi search pernei tis times apo ton client kai tis bazei stis parapano metablites
    public void search(String day1, String month1, String day2, String month2, int num_seats, String from, String to) throws RemoteException {

        Communication com = new Communication(day1, month1, day2, month2, num_seats, from, to);
        Server1 server = null;
        Socket DB = null;

        try {

            DB = new Socket("localhost", 25200);                                          //dimiourgia socket tou client

            ObjectOutputStream out = new ObjectOutputStream(DB.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(DB.getInputStream());
            ArrayList<Communication> myarr = new ArrayList<Communication>();
            out.writeObject(com);

            myarr = (ArrayList) in.readObject();



        }//catchMalformedURLException
        catch (IOException e) {
            System.err.println("IO error! " + e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Server1.class.getName()).log(Level.SEVERE, null, ex);
        }//catch
    }//search

    public static void main(String Args[]) {


        try {
            RMISecurityManager sec = new RMISecurityManager();
            System.setSecurityManager(sec); /*edo ka8orizoume tin politiki asfaleias parametropoiontas to sec*/
            Server1 server = new Server1();
            Naming.rebind("//localhost/Server1", server);  /*i entoli auti paei kai leei sto registry oti uparxei mia upiresia operation server(syndeei onoma kai upiresia)prepei prota na "trexoume to registry"*/
            //>kalesma sinartisis search apo ton client



        }//try
        catch (RemoteException ex) {
            System.out.println("RemoteException ERROR" + ex);
        }//catchRemoteException
        catch (MalformedURLException ex) {
            System.out.println("MalformedURLException ERROR" + ex);
        }//catchMalformedURLException

        ///////////////////////////////






    }
}

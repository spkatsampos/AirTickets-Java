
package katanemimena_3;
import java.rmi.*;

public interface FlightsInt extends Remote{

  public void search(String day1,String month1,String day2,String month2,int num_seats,String from,String to)throws RemoteException;
    //public Communication answer()throws RemoteException;
    
}

package RMI.parking;

import java.net.MalformedURLException;
import java.rmi.*;

public class ParkingClient {
  ParkingManager parkingManager;

  public ParkingClient(String host, String port, String server) {
    try {
      this.parkingManager = (ParkingManager)Naming.lookup("rmi://" + host + ":" + port + "/" + server);
    } catch (RemoteException remoteException) {
      System.out.println("RemoteException ->" + remoteException);
    } catch (MalformedURLException malformedURLException) {
      System.out.println("MalformedURLException ->" + malformedURLException);
    } catch (NotBoundException notBoundException) {
      System.out.println("NotBoundException ->" + notBoundException);
    }

    try {
      ParkingTicket ticket = this.parkingManager.requestParkingTicket("NI-221-AB", 1, 14, 17);
      this.parkingManager.extendParkingTicket(ticket, 14, 59);
    }catch (RemoteException remoteException) {
      System.out.println("RemoteException ->" + remoteException);
    } 
  }

  public static void main(String[] args) {
    String host = args[0];
    String port = args[0];
    String server = args[0];

    new ParkingClient(host, port, server);
  }
}

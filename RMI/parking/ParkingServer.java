package RMI.parking;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;

public class ParkingServer {
  ParkingManager parkingManager;

  public ParkingServer(String host, String port, String server) {
    try {
      this.parkingManager = new ParkingManagerImpl();
    } catch (RemoteException remoteException) {
      System.err.println("RemoteException ->" + remoteException);
    }

    try {
      LocateRegistry.createRegistry(Integer.parseInt(port));
      Naming.rebind("rmi://" + host + ":" + port + "/" + server, this.parkingManager);
    } catch (RemoteException remoteException) {
      System.err.println("RemoteException ->" + remoteException);
    } catch (MalformedURLException malformedURLException) {
      System.err.println("MalformedURLException ->" + malformedURLException);
    }
  }

  public void main(String[] args) {
    String host = args[0];
    String port = args[1];
    String server = args[2];

    new ParkingServer(host, port, server);

    try {
      System.in.read();
    } catch (IOException ioexception) {
      System.err.println("IOException ->" + ioexception);
    }

    System.exit(0);
  }
  
}

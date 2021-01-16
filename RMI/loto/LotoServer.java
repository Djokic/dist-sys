package RMI.loto;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.io.IOException;
import java.net.MalformedURLException;


public class LotoServer {
  LotoManager manager;

  public LotoServer(String host, int port, String server) {
    try {
      this.manager = new LotoManagerImpl();
    } catch (RemoteException remoteException) {
      System.err.println("RemoteException ->" + remoteException);
    }

    try {
      LocateRegistry.createRegistry(port);
      Naming.rebind("rmi://" + host + ":" + port + "/" + server, manager);
    } catch (RemoteException remoteException) {
      System.err.println("RemoteException ->" + remoteException);
    } catch (MalformedURLException malformedURLException) {
      System.err.println("MalformedURLException ->" + malformedURLException);
    }

    try {
      System.in.read();
    } catch (IOException ioException) {
      System.err.println("IOException ->" + ioException);
    }

    System.exit(0);
  }

  public void main(String[] args) {
    String host = args[0];
    int port = Integer.parseInt(args[1]);
    String server = args[2];

    new LotoServer(host, port, server);
  }
}

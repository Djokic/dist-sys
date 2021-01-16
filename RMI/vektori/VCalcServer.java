package RMI.vektori;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.io.IOException;
import java.net.MalformedURLException;

public class VCalcServer {
  VCalcManager manager;

  public VCalcServer(String host, String port, String server) {
    try {
      this.manager = new VCalcManagerImpl();
    } catch (RemoteException re) {
      // Handle RE
    }

    try {
      LocateRegistry.createRegistry(Integer.parseInt(port));
      Naming.rebind("rmi://" + host + ":" + port + "/" + server, this.manager);
    } catch (RemoteException re) {
      // Handle RE
    } catch (MalformedURLException me) {
      // Handle ME
    }

    try {
      System.in.read();
    } catch (IOException ioe) {
      // Handle IOE
    }
  }

  public void main(String[] args) {
    String host = args[0];
    String port = args[1];
    String server = args[2];

    new VCalcServer(host, port, server);
  }
}

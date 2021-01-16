package RMI.vektori;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Vector;

public class VCalcClient {
  VCalcManager manager;

  public VCalcClient(String host, String port, String server) {
    try {
      this.manager = (VCalcManager) Naming.lookup("rmi://" + host + ":" + port + "/" + server);
    } catch (RemoteException re) {
      // Handler RE
    } catch (MalformedURLException me) {
      // Handler ME
    } catch (NotBoundException nbe) {
      // Handler NBE
    }
  }

  public void main(String args[]) {
    String host = args[0];
    String port = args[1];
    String server = args[2];

    VCalcClient client = new VCalcClient(host, port, server);

    Vector<Integer> vectorA = new Vector<Integer>();
    vectorA.add(2);
    vectorA.add(4);
    vectorA.add(6);

    Vector<Integer> vectorB = new Vector<Integer>();
    vectorB.add(3);
    vectorB.add(5);
    vectorB.add(6);
    
    try {
      VCalcCallback callback = new VCalcCallbackImpl();
      VCalcRequest request1 = new VCalcRequestImpl(0, vectorA, vectorB, callback);
      VCalcRequest request2 = new VCalcRequestImpl(1, vectorB, vectorA, callback);
      client.manager.SendVCalcRequest(request1);
      client.manager.SendVCalcRequest(request2);
      client.manager.RunNextVCalc();
      client.manager.RunNextVCalc();
    } catch (RemoteException remoteException) {
      // Handle remote exception
    }
  }
}

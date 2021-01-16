package RMI.loto;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Vector;

public class LotoClient {
  LotoManager manager;

  public LotoClient(String host, String port, String server) {
    try {
      this.manager = (LotoManager) Naming.lookup("rmi://" + host + ":" + port + "/" + server);
    } catch (RemoteException remoteException) {
      System.err.println("RemoteException ->" + remoteException);
    } catch (MalformedURLException malformedURLException) {
      System.err.println("MalformedURLException ->" + malformedURLException);
    } catch (NotBoundException notBoundException) {
      System.err.println("NotBoundException ->" + notBoundException);
    }
  }

  public void main(String[] args) {
    String host = args[0];
    String port = args[1];
    String server = args[1];

    try {
      LotoClient client = new LotoClient(host, port, server);
      Vector<Integer> numbers = new Vector<Integer>(1, 7);
      numbers.add(2);
      numbers.add(14);
      numbers.add(33);
      numbers.add(11);
      numbers.add(18);
      numbers.add(21);
      numbers.add(29);

      Ticket ticket =  client.manager.playTicket(numbers);
      client.manager.drawNumbers();
      Vector<Integer> winners = client.manager.getWinners();

      if (winners.contains(ticket.id)) {
        System.out.println("We have a winner!");
      }
    } catch (RemoteException remoteException) {
      System.err.println("RemoteException ->" + remoteException);
    }
  }
  
}

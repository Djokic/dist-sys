package RMI.loto;
import java.util.*;
import java.rmi.*;

public interface LotoManager extends Remote {
  Ticket playTicket(Vector<Integer> numbers) throws RemoteException;
  Vector<Integer> getWinners() throws RemoteException;
  void drawNumbers() throws RemoteException;
}

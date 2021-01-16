package RMI.loto;
import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

public class LotoManagerImpl extends UnicastRemoteObject implements LotoManager {
  static int NumbersCount = 7;
  static int NumbersLimit = 39;

  List<Ticket> tickets = new ArrayList<Ticket>();
  Vector<Integer> numbers = new Vector<Integer>();

  public LotoManagerImpl() throws RemoteException {}

  public Ticket playTicket(Vector<Integer> numbers) throws RemoteException {
    Collections.sort(numbers);
    Ticket ticket = new Ticket(tickets.size(), numbers);
    tickets.add(ticket);
    return ticket;
  }

  public Vector<Integer> getWinners() throws RemoteException {
    Vector<Integer> winners = new Vector<Integer>();

    for (int i = 0; i < tickets.size(); i++) {
      Ticket ticket = tickets.get(i);

      if (ticket.numbers.equals(this.numbers)) {
        winners.add(ticket.id);
      }
    }

    return winners;
  }

  public void drawNumbers() throws RemoteException {
    for (int i = 0; i < LotoManagerImpl.NumbersCount; i++) {
      int number = (int) Math.ceil(Math.random() * 39);
      this.numbers.add(number);
    }
    Collections.sort(this.numbers);
  }
}

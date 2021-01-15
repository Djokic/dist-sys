package RMI.parking;
import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

public class ParkingManagerImpl extends UnicastRemoteObject implements ParkingManager {
  private static int TicketDuration = 60;
  private static int TicketMaxRenevalTimeout = 75;

  HashMap<String, ParkingTicket> tickets = new HashMap<String, ParkingTicket>();

  public ParkingManagerImpl() throws RemoteException {}

  private int getMinuteDifference(int startHour, int startMinute, int endHour, int endMinute) {
    // This condition is not correct but let's keep it for simplicity for now
    return 60 * (endHour - startHour) + endMinute - startMinute;
  }

  public ParkingTicket requestParkingTicket(String reg, int zone, int hour, int minute) throws RemoteException {
    ParkingTicket currentTicket = this.tickets.get(reg);
    
    boolean canCreateTicket = true;
    if (currentTicket != null) {
      int minDiff = this.getMinuteDifference(currentTicket.hour, currentTicket.minute, hour, minute);

      if (minDiff > 0 && minDiff < ParkingManagerImpl.TicketDuration) {
        canCreateTicket = false;
      }
    }

    if (!canCreateTicket) return null;

    ParkingTicket ticket = new ParkingTicket(reg, zone, hour, minute);
    this.tickets.put(reg, ticket);
    return ticket;
  }

  public ParkingTicket extendParkingTicket(ParkingTicket ticket, int hour, int minute) throws RemoteException {
    ParkingTicket existingTicket = this.tickets.get(ticket.reg);
    int minDiff = this.getMinuteDifference(ticket.hour, ticket.minute, hour, minute);

    if (existingTicket != null && minDiff > 0 && minDiff < ParkingManagerImpl.TicketMaxRenevalTimeout) {
      existingTicket.hour = (existingTicket.hour + 1) % 24;
      this.tickets.put(existingTicket.reg, existingTicket);
      return existingTicket;
    } else {
      return null;
    }
  }
}

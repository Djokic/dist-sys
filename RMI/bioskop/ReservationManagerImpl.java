import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

public class ReservationManagerImpl extends UnicastRemoteObject implements ReservationManager {
    public Seat[][] seats;
    public HashMap<Integer, Reservation> reservations = new HashMap<Integer, Reservation>();
    private int rowSize;
    
    public ReservationManagerImpl(int numRows, int rowSize) throws RemoteException {
        this.rowSize = rowSize;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < rowSize; j++) {
                seats[i][j] = new Seat(i, j);
            }
        }
    }
    
    public Reservation makeReservation(int seatRow, int seatNum, int numSeats) throws RemoteException {
        if (seatNum + numSeats > rowSize) return null;
        
        boolean isPossible = true;
        
        for (int i = seatNum; i <= seatNum + numSeats; i++) {
            if (!seats[seatRow][i].isFree) {
                isPossible = false;
                break;
            }
        }
        
        if (!isPossible) return null;
        
        for (int i = seatNum; i <= seatNum + numSeats; i++) {
            seats[seatRow][i].isFree = false;
        }
        
        return new Reservation(reservations.size(), seatNum, seatRow, numSeats);
    }
    
    public void cancelReservation(int id) throws RemoteException {
        reservations.remove(id);
    }
}
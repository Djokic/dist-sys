import java.rmi.*;

public interface ReservationManager extends Remote {
    Reservation makeReservation(int seatRow, int seatNum, int numSeats) throws RemoteException;
    
    void cancelReservation(int id) throws RemoteException;
}
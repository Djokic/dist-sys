import java.rmi.*;
import java.io.*;
import java.net.MalformedURLException;

public class ReservationClient {
    ReservationManager reservationManager;
    
    public ReservationClient(String host, String port, String server) {
        try {
            this.reservationManager = (ReservationManager)Naming.lookup("rmi://" + host + ":" + port + "/" + server);
        } catch (RemoteException remoteException) {
            System.err.println("RemoteException ->" + remoteException);
        } catch (MalformedURLException malformedUrlException) {
            System.err.println("MalformedURLException ->" + malformedUrlException);
        } catch (NotBoundException notBoundException) {
            System.err.println("NotBoundException ->" + notBoundException);
        }
        
        try {
            Reservation reservation = this.reservationManager.makeReservation(4, 3, 6);
            this.reservationManager.cancelReservation(reservation.id);
        } catch (RemoteException remoteException) {
            System.err.println("RemoteException ->" + remoteException);
        }
    }
    
    public static void main(String[] args) {
        String host = args[0];
        String port = args[0];
        String server = args[0];
        
        new ReservationClient(host, port, server);
    }

}
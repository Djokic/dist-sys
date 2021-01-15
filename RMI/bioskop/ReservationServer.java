import java.io.IOException;
import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;
import java.net.MalformedURLException;

public class ReservationServer {
    ReservationManager reservationManager;
    
    public ReservationServer(String host, String port, String server) {
        try {
            this.reservationManager = new ReservationManagerImpl(10, 8);
        } catch(RemoteException remoteException) {
            System.err.println("RemoteException during creation of ReservationManager ->" + remoteException);
        }
        
        try {
            LocateRegistry.createRegistry(Integer.parseInt(port));
            Naming.rebind("rmi://" + host + ":" + port + "/" + server, this.reservationManager);
        } catch (RemoteException remoteException) {
            System.out.println("RemoteException during name registration ->" + remoteException);
        } catch (MalformedURLException malformedURLException) {
            System.out.println("MalformedURLException during name registration ->" + malformedURLException);
        }
    }
    
    public static void main(String[] args) {
        String host = args[0];
    	String port = args[1];
    	String server = args[2];
	
	    new ReservationServer(host, port, server);
	
        try {
            System.in.read();
        } catch(IOException ioexception) {
            System.out.println("IOException ->" + ioexception);
        }
        
        System.exit(0);
    }
}
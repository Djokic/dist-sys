package RMI.vektori;
import java.rmi.*;

public interface VCalcCallback extends Remote {
  void onDone(int cId, double result) throws RemoteException;
}

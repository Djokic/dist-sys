package RMI.vektori;
import java.rmi.*;

public interface VCalcManager extends Remote {
  int SendVCalcRequest(VCalcRequest req) throws RemoteException;
  boolean RunNextVCalc() throws RemoteException;
}

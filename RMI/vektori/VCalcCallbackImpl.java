package RMI.vektori;
import java.rmi.*;
import java.rmi.server.*;

public class VCalcCallbackImpl extends UnicastRemoteObject implements VCalcCallback {
  public void onDone(int cId, double result) throws RemoteException {
    System.out.println("Result for request [" + cId + "] is: " + result);
  }
}

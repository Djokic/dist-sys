package RMI.vektori;
import java.rmi.*;
import java.util.*;

public interface VCalcRequest extends Remote {
  int getCid() throws RemoteException;
  Vector<Integer> getVectorA() throws RemoteException;
  Vector<Integer> getVectorB() throws RemoteException;
  VCalcCallback getCallback() throws RemoteException;
}
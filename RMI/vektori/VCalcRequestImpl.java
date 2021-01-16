package RMI.vektori;
import java.rmi.RemoteException;
import java.rmi.server.*;
import java.util.*;
import java.io.Serializable;

public class VCalcRequestImpl extends UnicastRemoteObject implements VCalcRequest {
  private int cId;
  private Vector<Integer> a;
  private Vector<Integer> b;
  private VCalcCallback callback;

  public VCalcRequestImpl(int cId, Vector<Integer> a, Vector<Integer> b, VCalcCallback callback) throws RemoteException {
    this.cId = cId;
    this.a = a;
    this.b = b;
    this.callback = callback;
  }

  public int getCid() throws RemoteException {
    return this.cId;
  }

  public Vector<Integer> getVectorA() throws RemoteException {
    return this.a;
  }

  public Vector<Integer> getVectorB() throws RemoteException {
    return this.b;
  }
  
  public VCalcCallback getCallback() throws RemoteException {
    return this.callback;
  }
}

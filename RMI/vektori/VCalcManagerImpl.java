package RMI.vektori;
import java.util.*;
import java.rmi.*;
import java.rmi.server.*;

public class VCalcManagerImpl extends UnicastRemoteObject implements VCalcManager {
  private List<VCalcRequestImpl> requests = new ArrayList<VCalcRequestImpl>();
  private int currentReqest = 0;

  public VCalcManagerImpl() throws RemoteException {}
  
  public int SendVCalcRequest(VCalcRequestImpl req) throws RemoteException {
    this.requests.add(req);
    return req.getCid();
  }

  public boolean RunNextVCalc() throws RemoteException {
    VCalcRequestImpl req = this.requests.get(currentReqest);

    if (req != null) {
      this.currentReqest++;
      
      int result = 0;
      for (int i = 0; i < req.getVectorA().size(); i++) {
        result += req.getVectorA().get(i) * req.getVectorB().get(i);
      }

      req.getCallback().onDone(req.getCid(), result);
      return true;
    } else {
      return false;
    }
  }
}

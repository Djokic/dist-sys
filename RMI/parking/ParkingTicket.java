package RMI.parking;
import java.io.Serializable;

public class ParkingTicket extends Serializable {
  public String reg;
  public int zone;
  public int hour;
  public int minute;

  public ParkingTicket(String reg, int zone, int hour, int minute) {
    this.reg = reg;
    this.zone = zone;
    this.hour = hour;
    this.minute = minute;
  }
}

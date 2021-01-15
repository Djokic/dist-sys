import java.io.Serializable;

public class Seat implements Serializable {
    public int seatRow;
    public int seatNum;
    public boolean isFree;
    
    public Seat(int seatRow, int seatNum) {
        this.seatRow = seatRow;
        this.seatNum = seatNum;
        this.isFree = true;
    }
}

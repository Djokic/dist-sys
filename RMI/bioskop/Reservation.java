import java.io.Serializable;

public class Reservation implements Serializable {
    public int id;
    public int seatNum;
    public int seatRow;
    public int numSeats;
    
    public Reservation(int id, int seatNum, int seatRow, int numSeats) {
        this.id = id;
        this.seatNum = seatNum;
        this.seatRow = seatRow;
        this.numSeats = numSeats;
    }
}

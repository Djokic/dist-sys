package RMI.loto;
import java.io.Serializable;
import java.util.Vector;

public class Ticket extends Serializable {
  public int id;
  public Vector<Integer> numbers;
  
  public Ticket(int id, Vector<Integer> numbers) {
    this.id = id;
    this.numbers = numbers;
  }
}

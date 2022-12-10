import java.util.ArrayList;
import java.util.Date;

public class Quarto {
    private int numberOfGuests;
    private int typeOfRoom;
    private static final ArrayList<Date> vacancy = new ArrayList<>(); // dias que o quarto está ocupado

    public Quarto(int numberOfGuests, int typeOfRoom, ArrayList<Date> vacancy) {
        this.numberOfGuests = numberOfGuests;
        this.typeOfRoom = typeOfRoom;
    }

    // todo
    private boolean createRoom(int numberOfGuests) {
        return false;
    }

    public boolean isAvailable(Date d) {
        for (Date date : vacancy) {
            if (d.compareTo(date) == 0) return false;
        }
        return true;
    }

    public int getnumberOfGuests() {
        return numberOfGuests;
    }
    public void setnumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }
    public int gettypeOfRoom() {
        return typeOfRoom;
    }
    public void settypeOfRoom(int typeOfRoom) {
        this.typeOfRoom = typeOfRoom;
    }
}
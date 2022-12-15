package poo_final;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
        
public class Quarto {
    private int roomNumber;
    private int numberOfGuests; 
    protected ArrayList<Date> notAvaiable = new ArrayList<>();

    public Quarto(int roomNumber, int numberOfGuests) {
        this.roomNumber = roomNumber;
        this.numberOfGuests = numberOfGuests;
    }

    public boolean isAvaiable(Date d, int days) {
        Calendar c = Calendar.getInstance();
        for(int i = 1; i <= days; i++){ 
            for (int j = 0; j < notAvaiable.size(); j++) { 
                if (d.compareTo(notAvaiable.get(j)) == 0)
                    return false;
        }
            c.setTime(d);
            c.add(Calendar.DATE, 1);
            d = c.getTime();            
        }
        return true;
    }
    public void Occupied(Date d, int days){ 
        Calendar c = Calendar.getInstance();
        for (int i = 1; i <= days; i++) {
            notAvaiable.add(d);
            c.setTime(d);
            c.add(Calendar.DATE, 1);
            d = c.getTime();
        }
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
}
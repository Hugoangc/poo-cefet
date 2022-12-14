package poo_final;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
        

public class Quarto {
    private int roomNumber;
    private int numberOfGuests; // pessoas que o quarto suporta
    private boolean vacancy;

    private ArrayList<Date> avaiable = new ArrayList<>();


    public Quarto(int roomNumber, int numberOfGuests, boolean vacancy) {
        this.roomNumber = roomNumber;
        this.numberOfGuests = numberOfGuests;
        this.vacancy = vacancy;
    }

    public  boolean isAvaiable(Date d, int days) {
        Calendar c = Calendar.getInstance();
        for(int i = 1; i <= days; i++){
            for (int j = 0; j < avaiable.size(); j++) {
                if (d.compareTo(avaiable.get(j)) == 0)
                    return false;
        }
            c.setTime(d);
            c.add(Calendar.DATE, 1);
            d = c.getTime();            
        }
        return true;
    }
    public void Ocupado(Date d, int days){
        Calendar c = Calendar.getInstance();
        for (int i = 1; i <= days; i++) {
            avaiable.add(d);
        }
        c.setTime(d);
        c.add(Calendar.DATE, 1);
        d = c.getTime();
    }
    public static void listRooms() {
        System.out.println("\nQuartos:\n");
        for (Quarto room : Hotel.rooms) {
            System.out.println("Quarto: " + room.roomNumber);
            System.out.println("Capacidade do Quarto: " + room.numberOfGuests+" hospedes");
        }
        System.out.println("\n");
    }

    public boolean isVacancy() {
        return vacancy;
    }

    public void setVacancy(boolean vacancy) {
        this.vacancy = vacancy;
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
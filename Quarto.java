import java.util.ArrayList;
import java.util.Date;

public class Quarto {
    private int roomNumber;
    private int numberOfGuests;
    private int typeOfRoom;
    private static int roomCapacity = 0;
    private static final ArrayList<Date> vacancy = new ArrayList<>();
    private static final ArrayList<Quarto> rooms = new ArrayList<>(10);

    public Quarto(int roomNumber, int numberOfGuests, int typeOfRoom, ArrayList<Date> vacancy) {
        this.roomNumber = roomNumber;
        this.numberOfGuests = numberOfGuests;
        this.typeOfRoom = typeOfRoom;
    }

    public Quarto(int roomNumber, int numberOfGuests, int typeOfRoom) {
        this.roomNumber = roomNumber;
        this.numberOfGuests = numberOfGuests;
        this.typeOfRoom = typeOfRoom;
    }

    public static Quarto createRoom(int numberOfGuests) {
        int type = (numberOfGuests + 1 == 2 ? 2 : 1);
        Quarto q = new Quarto(roomCapacity+1, numberOfGuests, type);
        rooms.add(q);
        roomCapacity++;
        return q;
    }

    public static void listRooms() {
        System.out.println("\nQuartos:\n");
        for (Quarto room : rooms) {
            System.out.println("Quarto: " + room.roomNumber);
            System.out.println("Capacidade Hospedes: " + room.numberOfGuests);
            System.out.println("Tipo Quarto: " + room.typeOfRoom);
        }
    }

    public static boolean isAvailable(Date d) {
        for (Date date : vacancy) {
            if (d.compareTo(date) == 0) return false;
        }
        return true;
    }

    public static ArrayList<Date> getVacancy() {
        return vacancy;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public int getTypeOfRoom() {
        return typeOfRoom;
    }

    public void setTypeOfRoom(int typeOfRoom) {
        this.typeOfRoom = typeOfRoom;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
}

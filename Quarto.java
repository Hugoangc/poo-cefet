import java.util.ArrayList;
import java.util.Random;

public class Quarto {
    private int roomNumber;
    private int numberOfGuests; // pessoas que o quarto suporta
    private boolean vacancy;
    private static int roomCapacity = 0;
    private static final ArrayList<Quarto> rooms = new ArrayList<>(10);

    public Quarto(int roomNumber, int numberOfGuests, boolean vacancy) {
        this.roomNumber = roomNumber;
        this.numberOfGuests = numberOfGuests;
        this.vacancy = vacancy;
    }

    public static Quarto createRoom(int numberOfGuests) {
        Quarto q = new Quarto(roomCapacity+1, numberOfGuests, true);
        rooms.add(q);
        roomCapacity++;
        return q;
    }

    public static void createRooms() {
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            int guests = rand.nextInt(4);
            Quarto q = new Quarto(i+1, guests+1, true);
            rooms.add(q);
            roomCapacity++;
        }
    }

    public static Quarto searchRooms(int numberOfGuests) {
        for (Quarto room : rooms) {
            if (numberOfGuests == room.numberOfGuests && room.isVacancy())
                return room;
        }
        return null;
    }

    public static void listRooms() {
        System.out.println("\nQuartos:\n");
        for (Quarto room : rooms) {
            System.out.println("Quarto: " + room.roomNumber);
            System.out.println("Capacidade do Quarto: " + room.numberOfGuests+" hospedes");
        }
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

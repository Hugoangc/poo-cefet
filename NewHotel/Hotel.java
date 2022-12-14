package poo_final;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Hotel {
    String nome;
    private int roomCapacity;
    Quarto q;
    static ArrayList<Quarto> rooms = new ArrayList<>(10);

    public Hotel() {
        nome = "CEFET";
    }
    
    public Quarto searchRooms(int numberOfGuests, Date d, int days) {
        for (Quarto room : Hotel.rooms) {
            if (numberOfGuests == room.getNumberOfGuests() && room.isVacancy() && q.isAvaiable(d, days))
                return room;
        }
        return null;
    }    

    public Quarto createRoom(int numberOfGuests) {
        q = new Quarto(roomCapacity+1, numberOfGuests, true);
        rooms.add(q);
        roomCapacity++;
        return q;
    }
    
    public void createRooms() {
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            int guests = rand.nextInt(4);
            Quarto q = new Quarto(i+1, guests+1, true);
            Hotel.rooms.add(q);
            roomCapacity++;
        }
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getRoomCapacity() {
        return roomCapacity;
    }

    public void setRoomCapacity(int roomCapacity) {
        this.roomCapacity = roomCapacity;
    }

    public Quarto getQ() {
        return q;
    }

    public void setQ(Quarto q) {
        this.q = q;
    }
    
}

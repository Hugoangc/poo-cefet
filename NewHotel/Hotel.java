package poo_final;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Hotel { // class criada a fins de resolver as coisas por fora, nao precisando focar muito em static
    String nome;
    private int roomCapacity;
    Quarto q;
    static ArrayList<Quarto> rooms = new ArrayList<>(10);
    static ArrayList<Reserva> Reservas = new ArrayList<>(); // fiz so pra listar mesmo
    public Hotel() {
        nome = "CEFET";
    }
    
    public Quarto searchRooms(int numberOfGuests, Date d, int days) {
        for (Quarto room : Hotel.rooms) {
            if (numberOfGuests <= room.getNumberOfGuests() && q.isAvaiable(d, days))
                return room;
        }
        return null;
    }    
    public void makeReserve(Quarto q, Date d, int numberOfGuests, Hospede h, int days) {
        if (q.getNumberOfGuests() >= numberOfGuests+1) { // mudanca: +1 dps do numberOfGuests, nao lembro a logica, perguntar a dupla
            if (q.isAvaiable(d, days)) {
                h.setTotal(days * 50 + 25 * numberOfGuests);
                q.Occupied(d, days);
                Reserva r = new Reserva(q, numberOfGuests, h, d, days);
                Hotel.Reservas.add(r);
            }
        }
    }
    public Quarto createRoom(int numberOfGuests) {
        q = new Quarto(roomCapacity+1, numberOfGuests);
        rooms.add(q);
        roomCapacity++;
        return q;
    }
    public static void listReserves(){                         //Ambas as listas trouxe pra ca por mero capricho, podendo leva-las de volta para suas respectivas classes
        System.out.println("\nReservas ja feitas:");
        for(Reserva r : Hotel.Reservas){
            System.out.println(r.getH().getNome());
            System.out.println("Data: " + r.getDate());
            System.out.println("Reservado por: " + r.getDays() + " dias.");
        }
    }
    public static void listRooms() {
        System.out.println("\nQuartos:\n");
        for (Quarto room : Hotel.rooms) {
            System.out.println("Quarto: " + room.getRoomNumber());
            System.out.println("Capacidade do Quarto: " + room.getNumberOfGuests()+" hospedes");
        }
        System.out.println("\n");
    }
    
    public void createRooms() {
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            int guests = rand.nextInt(4);
            Quarto q = new Quarto(i+1, guests+1);
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

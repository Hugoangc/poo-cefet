package poo_final;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Hotel { 
    String nome;
    private int roomCapacity;
    Quarto q;
    static ArrayList<Quarto> rooms = new ArrayList<>(10);
    static ArrayList<Reserva> Reservas = new ArrayList<>(); 
    public Hotel() {
        nome = "CEFET";
    }   
    public Quarto searchRooms(int numberOfGuests, Date d, int days) {
        for (Quarto room : Hotel.rooms) {
            if ((numberOfGuests <= room.getNumberOfGuests()) && room.isAvaiable(d, days))
                return room;
        }
        return null;
    }    
    public void makeReserve(Quarto q, Date d, int numberOfGuests, Hospede h, int days) {
        if (q.getNumberOfGuests() >= numberOfGuests) {
            if (q.isAvaiable(d, days)) {
                h.setTotal(h.getTotal()+((days * 100) + (50 * numberOfGuests)));
                q.Occupied(d, days);
                Reserva r = new Reserva(q, numberOfGuests, h, d, days);
                Hotel.Reservas.add(r);
            }
        }
    }
    public static void Register(){        
        Scanner input = new Scanner(System.in);
        System.out.print("Entre com o Nome do Hospede: \n");
        String name = input.nextLine();
        System.out.print("Entre com o CPF do Hospede: \n");
        String cpf = input.nextLine();
        while (!Pessoa.isCPF(cpf)){
            System.out.print("CPF ja existente ou invalido, tente novamente!\n");
            cpf = input.nextLine();
        }
        Hospede.registerGuest(name, cpf);
    }    
    public Quarto createRoom(int numberOfGuests) {
        q = new Quarto(roomCapacity+1, numberOfGuests);
        rooms.add(q);
        roomCapacity++;
        return q;
    }
    public static void listReserves(){                        
        System.out.println("\nReservas ja feitas:");
        if(Reservas.isEmpty()){
            System.out.println("A lista de reservas esta vazia!\n");
            return;        
        }           
        for(Reserva r : Hotel.Reservas){
            System.out.println(r.getH().getNome());
            System.out.println("Data: " + r.getDate());
            System.out.println("Reservado por: " + r.getDays() + " dias.");
            System.out.println("Total: R$"+ r.getH().getTotal());
        }
    }
    public static void listRooms() {
        System.out.println("\nQuartos:\n");
        if(rooms.isEmpty()){
            System.out.println("A lista de quartos esta vazia!\n");
            return;        
        }        
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

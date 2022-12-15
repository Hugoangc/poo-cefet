package poo_final;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Hotel { 
    protected String nome;
    private int roomCapacity;
    protected Quarto q;
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
    public boolean checkRoom(int numberOfGuests){
        for(Quarto room : Hotel.rooms){
            if(numberOfGuests <= room.getNumberOfGuests()) return true;
        }      
        return false;
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
    public Reserva searchReserv(String CPF){
        for(Reserva r : Hotel.Reservas){
            if(r.getH().getCPF().equals(CPF)){
                return r;
            }
        }
        return null;
    } 
    public void cancelReserve(Reserva r){
        if(r==null) return;
        Calendar c = Calendar.getInstance();
        for(int i = 1; i <= r.getDays();i++){
            r.getQ().notAvaiable.remove(r.getDate());
            c.setTime(r.getDate());
            c.add(Calendar.DATE,1);
            r.setDate(c.getTime());                    
        }
        Hotel.Reservas.remove(r);
        r.getH().setTotal(0);
    }
    public static void Register(){        
        Scanner input = new Scanner(System.in);
        System.out.print("Entre com o Nome do Hospede: \n");
        String name = input.nextLine();
        System.out.print("Entre com o CPF do Hospede: \n");
        String cpf = input.nextLine();
        while (!Pessoa.isCPF(cpf)){
            System.out.print("CPF invalido, tente novamente!\n");
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
            System.out.println("Nome: " + r.getH().getNome());
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println("Data: " + dateFormat.format(r.getDate()));
            System.out.println("Reservado para " + r.getNumberOfGuests() + " pessoas.");
            System.out.println("Reservado por: " + r.getDays() + " dias.");
            System.out.println("Total: R$"+ r.getH().getTotal());
            System.out.print("\n");
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

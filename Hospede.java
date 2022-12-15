package poo_final;
import java.util.ArrayList;

public class Hospede extends Pessoa {
    private double total;
    protected static ArrayList<Hospede> guests = new ArrayList<>();
    public Hospede(String nome, String CPF) {
        super(nome, CPF);
    }

    public static void registerGuest(String nome, String CPF) {
        Hospede h = new Hospede(nome, CPF);
        guests.add(h);
    }
    public static Hospede searchH(String CPF){
        if(guests.isEmpty()) return null;
        for(Hospede guest : guests){
            if(guest.getCPF().equals(CPF)) return guest;
        }
        return null;
    }
    public static Hospede lastH(){
        return guests.get(guests.size()-1);
    }
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    public static void listGuests() {
        if (guests.isEmpty()) {
            System.out.println("A lista de hospedes esta vazia!\n");
            return;
        }
        int it = 1;
        for (Hospede guest : guests) {
            System.out.println("Hospede "+it);
            System.out.println("Nome: "+guest.getNome());
            System.out.println("CPF: "+guest.getCPF());
            it++;
        }
        System.out.println("\n");
    }
}
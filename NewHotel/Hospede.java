
package poo_final;

import java.util.ArrayList;

public class Hospede extends Pessoa {
    private double total;
    private static ArrayList<Hospede> guests = new ArrayList<Hospede>();

    private Hospede(String nome, String CPF) {
        super(nome, CPF);
    }

    public static Hospede registerGuest(String nome, String CPF) {
        Hospede h = new Hospede(nome, CPF);
        guests.add(h);
        return h;
    }
    public static void removeGuest(Hospede h){
       guests.remove(guests.size()-1);
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    public static boolean cpfExistente(String CPF){
        if (guests.isEmpty()) {
            System.out.println("A lista de hospedes esta vazia!\n");
            return false;
        }
        for(Hospede guest : guests){
            if(guest.getCPF().equals(CPF)){
                return false;
            }
        }
        return true;
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
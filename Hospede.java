import java.util.ArrayList;

public class Hospede extends Pessoa {
    static ArrayList<Hospede> guests = new ArrayList<Hospede>();

    private Hospede(String nome, String CPF) {
        super(nome, CPF);
    }

    public static void registerGuest(String nome, String CPF) {
        Hospede h = new Hospede(nome, CPF);
        guests.add(h);
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

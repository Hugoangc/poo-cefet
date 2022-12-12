import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner menu = new Scanner(System.in);
        while (true) {
            System.out.print("##-----------Menu------------##\n");
            System.out.print("|-----------------------------|\n");
            System.out.print("| Opção 1 - Nova Reserva      |\n");
            System.out.print("| Opção 2 - Listar Hospedes   |\n");
            System.out.print("| Opção 3 - Registrar Hospede |\n");
            System.out.print("| Opção 4 - Listar Quartos    |\n");
            System.out.print("| Opção 5 - Sair              |\n");
            System.out.print("|-----------------------------|\n");
            System.out.print("Digite uma opção: ");

            int option = menu.nextInt();

            if (option == 5) {
                System.out.print("\nAté logo!\n");
                break;
            }

            switch (option) {
                case 1 -> {
                    System.out.print("\nOpção 'Nova Reserva' Selecionado\n");
                    Scanner input = new Scanner(System.in);
                    System.out.println("Digite a quantidade de acompanhantes: ");
                    int guests = input.nextInt();
                    input.nextLine();
                    System.out.println("Digite o ano desejado: ");
                    int ano = input.nextInt();
                    input.nextLine();
                    System.out.println("Digite o mes desejado: ");
                    int mes = input.nextInt();
                    input.nextLine();
                    System.out.println("Digite o dia desejado: ");
                    int dia = input.nextInt();
                    input.nextLine();
                    Date d = new Date(ano, mes, dia);
                    if (Quarto.isAvailable(d)) {
                        Reserva.makeReserve(Quarto.createRoom(guests), d, guests);
                        Quarto.getVacancy().add(d);
                        System.out.println("Reserva criada!\n");
                    } else {
                        System.out.println("Indisponivel!\n");
                    }
                }
                case 2 -> {
                    System.out.print("\nOpção 'Listar Hospedes' Selecionado\n");
                    Hospede.listGuests();
                }
                case 3 -> {
                    System.out.print("\nOpção 'Registrar Hospede' Selecionado\n");
                    Scanner input = new Scanner(System.in);
                    System.out.print("Entre com o Nome: \n");
                    String name = input.nextLine();
                    System.out.print("Entre com o CPF: \n");
                    String cpf = input.nextLine();
                    Hospede.registerGuest(name, cpf);
                }
                case 4 -> Quarto.listRooms();
                default -> System.out.print("\nOpção Invalida!\n");
            }
        }
    }
}

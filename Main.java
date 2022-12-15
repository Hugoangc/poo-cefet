package poo_final;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {
        Funcionario admin = Funcionario.administrador();
        Hotel hotel = new Hotel();
        Scanner input = new Scanner(System.in);
        hotel.createRooms();
        System.out.print("|-------------------------------------|\n");
        System.out.println("|      Bem vindo ao Hotel: " + hotel.getNome() + "      |");
        Scanner menu = new Scanner(System.in);
        while (true) {
            System.out.print("##---------------Menu----------------##\n");
            System.out.print("|-------------------------------------|\n");
            System.out.print("| Opção 1 - Nova Reserva              |\n");
            System.out.print("| Opção 2 - Listar Hospedes           |\n");
            System.out.print("| Opção 3 - Buscar Hospede            |\n");
            System.out.print("| Opção 4 - Registrar Hospede         |\n");
            System.out.print("| Opção 5 - Listar Quartos            |\n");
            System.out.print("| Opção 6 - Entrar como Gerente       |\n");
            System.out.print("| Opção 0 - Sair                      |\n");
            System.out.print("|-------------------------------------|\n");
            System.out.print("Digite uma opção: ");

            int option = menu.nextInt();
            menu.nextLine();

            if (option == 0) {
                System.out.print("\nAté logo!\n" + hotel.getNome() + " sempre a disposicao de seus hospedes.\n");
                break;
            }
            switch (option) {
                case 1: {
                    System.out.print("\nOpção 'Nova Reserva' Selecionado\n");
                    System.out.println("Digite a quantidade de pessoas: ");
                    int guests = input.nextInt();
                    input.nextLine();
                    if(guests < 1){
                        System.out.println("Quantidade invalida!");
                        break;
                    }
                    if (!hotel.checkRoom(guests)) {
                        System.out.println("Nao existe quarto com essa capacidade");
                        break;
                    }
                    System.out.println("Digite o tempo de estadia: ");
                    int days = input.nextInt();
                    input.nextLine();
                    if(days < 1){
                        System.out.println("Quantidade invalida!");
                        break;
                    }                    
                    System.out.println("Deseja reservar para a data atual ou para alguma data especifica?");
                    System.out.println("1 - Data atual\n" + "2 - Data especifica");
                    int DTDecision;
                    DTDecision = input.nextInt();
                    input.nextLine();
                    Date atual = new Date();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");                    
                    dateFormat.format(atual);
                    if (DTDecision == 2) {
                        System.out.println("Digite a data especifica, no formato dd/mm/yyyy");
                        String FuturaData = input.nextLine();
                        atual = new SimpleDateFormat("dd/MM/yyyy").parse(FuturaData);
                    }
                    Quarto q = hotel.searchRooms(guests, atual, days);
                    if (q == null) {
                        System.out.println("Indisponivel!\n");
                        System.out.println("Cadastro impossibilitado.");
                        break;
                    }
                    hotel.Register();
                    Hospede aux = Hospede.lastH();
                    hotel.makeReserve(q, atual, guests, aux, days);
                    System.out.println("Valor total: " + aux.getTotal());
                    System.out.println("Reserva efetuada");
                    break;
                }
                case 2: {
                    System.out.print("\nOpção 'Listar Hospedes' Selecionado\n");
                    Hospede.listGuests();
                    break;
                }
                case 3: {
                    if (Hospede.guests.isEmpty()) {
                        System.out.println("Nenhum hospede cadastrado!");
                        break;
                    }
                    System.out.println("Digite o CPF do Hospede");
                    String buscarCPF = input.nextLine();
                    Hospede newName = Hospede.searchH(buscarCPF);
                    if (newName == null) {
                        System.out.println("CPF nao encontrado!");
                        break;
                    } else {
                        System.out.println("Hospede: " + newName.getNome());
                        System.out.println("CPF: " + newName.getCPF());
                        System.out.println("Total: " + newName.getTotal());
                        break;
                    }
                }
                case 4: {
                    System.out.print("\nOpção 'Registrar Hospede' Selecionado\n");
                    hotel.Register();
                    break;
                }
                case 5:
                    hotel.listRooms();
                    break;
                case 6: {
                    System.out.println("Digite a senha de administrador:");
                    String keyword = input.nextLine();
                    if (!Funcionario.checkKeyword(keyword, admin.getKeyword())) {
                        System.out.println("Senha invalida!\n");
                        break;
                    }
                    System.out.print("|-------------------------------------|\n");
                    System.out.print("| Opção 1 - Mudar senha               |\n");
                    System.out.print("| Opção 2 - Criar Quarto              |\n");
                    System.out.print("| Opção 3 - Mudar nome Hotel          |\n");
                    System.out.print("| Opção 4 - Listar reservas           |\n");
                    System.out.print("| Opção 5 - Alterar nome do Hospede   |\n");
                    System.out.print("| Opção 6 - Cancelar Reserva          |\n");                    
                    System.out.print("| Opção 0 - Sair                      |\n");
                    System.out.print("|-------------------------------------|\n");
                    int gInt;
                    gInt = input.nextInt();
                    input.nextLine();
                    switch (gInt) {
                        case 1:
                            System.out.println("Digite a nova senha");
                            String newKeyword = input.nextLine();
                            admin.setKeyword(newKeyword);
                            break;
                        case 2:
                            System.out.println("Qual numero de capacidade que voce deseja?");
                            int nRoom = input.nextInt();
                            input.nextLine();
                            hotel.createRoom(nRoom);
                            break;
                        case 3:
                            System.out.println("Digite o nome desejado");
                            String novoNome;
                            novoNome = input.nextLine();
                            hotel.setNome(novoNome);
                            System.out.println("Novo nome: " + hotel.getNome());
                            break;
                        case 4:
                            hotel.listReserves();
                            break;
                        case 5:
                            System.out.println("Digite o CPF de qual hospede deseja alterar o nome:");
                            String buscarCPF = input.nextLine();
                            Hospede newName = Hospede.searchH(buscarCPF);
                            if (newName == null) {
                                System.out.println("CPF nao encontrado!");
                                break;
                            } else {
                                System.out.println("Digite o novo nome:");
                                String newCPF = input.nextLine();
                                newName.setNome(newCPF);
                                System.out.println("Nome alterado com sucesso!");
                                System.out.println("Novo nome: " + newName.getNome());
                                break;
                            }
                        case 6:
                            System.out.println("Digite o CPF da pessoa que deseja cancelar a reserva");
                            String CPFcanc = input.nextLine();
                            if(hotel.searchReserv(CPFcanc) == null){
                                System.out.println("Reserva nao encontrada!");
                            }
                            System.out.println("Total: " + hotel.searchReserv(CPFcanc).getTotal());
                            System.out.println("O pagamento ja foi realizado?");
                            System.out.println("1 - Sim. \n2 - Nao.");
                            int PagR = input.nextInt();
                            input.nextLine();
                            if (PagR == 1) {
                                hotel.cancelReserve(hotel.searchReserv(CPFcanc));
                                System.out.println("Reserva cancelada com sucesso!");
                                System.out.println("Verificando se existe outra reserva neste mesmo CPF...");
                                if(hotel.searchReserv(CPFcanc) == null) {
                                    System.out.println("Nenhuma outra reserva encontrada.");
                                    break;
                                }
                                else {
                                    System.out.println("Existe outra reserva no mesmo CPF");
                                    Reserva Rcanc = hotel.searchReserv(CPFcanc);
                                    System.out.println("Nome: " + Rcanc.getH().getNome());
                                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                                    System.out.println("Data: " + dateFormat.format(Rcanc.getDate()));
                                    System.out.println("Reservado para " + Rcanc.getNumberOfGuests() + " pessoas.");
                                    System.out.println("Reservado por: " + Rcanc.getDays() + " dias.");
                                    System.out.println("Total: R$" + Rcanc.getH().getTotal());
                                    System.out.print("\n");                       
                                }
                            }
                            else{
                                System.out.println("Nao e possivel cancelar reserva sem efetuar o pagamento");
                                break;
                            }

                        default:
                            break;
                    }
                    break;
                }
                default:
                    System.out.print("\nOpção Invalida!\n");
            }
        }
    }
}

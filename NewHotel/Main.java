package poo_final;

import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Scanner;


public class Main {
    public static void main(String[] args){
        Funcionario admin = Funcionario.administrador();
        Hotel hotel = new Hotel();
        hotel.createRooms();
        System.out.println("Bem vindo ao Hotel: " + hotel.getNome());
        Scanner menu = new Scanner(System.in);
        while (true) {
            System.out.print("##------------Menu-------------##\n");
            System.out.print("|-------------------------------|\n");
            System.out.print("| Opção 1 - Nova Reserva        |\n");
            System.out.print("| Opção 2 - Listar Hospedes     |\n");
            System.out.print("| Opção 3 - Registrar Hospede   |\n");
            System.out.print("| Opção 4 - Listar Quartos      |\n");
            System.out.print("| Opção 5 - Entrar como Gerente |\n");
            System.out.print("| Opção 0 - Sair                |\n");
            System.out.print("|-------------------------------|\n");
            System.out.print("Digite uma opção: ");

            int option = menu.nextInt();
            menu.nextLine();

            if (option == 0) {
                System.out.print("\nAté logo!\n");
                break;
            }

            OUTER:
            switch (option) {
                case 1:{
                    System.out.print("\nOpção 'Nova Reserva' Selecionado\n");
                    Scanner input = new Scanner(System.in);
                    System.out.println("Deseja reservar para a data atual ou para alguma data especifica?");
//                    System.out.println("1 - Data atual\n" + "2 - Data especifica");
//                    int DTDecision;
//                    DTDecision = input.nextInt();
//                    input.nextLine();
                    System.out.println("Digite a quantidade de acompanhantes: ");
                    int guests = input.nextInt();
                    input.nextLine();
                    System.out.println("Digite o tempo de estadia: ");
                    int days = input.nextInt();
                    input.nextLine();
                    Date atual = new Date();
//                    if(DTDecision == 2){
//                        System.out.println("Digite a data especifica, no formato dd/mm/yyyy");
//                        String FuturaData = input.nextLine();
//                        atual = new SimpleDateFormat("dd/MM/yyyy").parse(FuturaData); 
//                    }
                    hotel.searchRooms(guests, atual, days);
                    if (hotel.q == null) {
                        System.out.println("Indisponivel!\n"); 
                        System.out.println("Cadastro impossibilitado.");
                        break;
                    }

                    Hospede aux = Registrar();
                    Reserva.makeReserve(hotel.q, atual, guests, aux, days);
                    System.out.print("Valor total: ");
                    System.out.println(aux.getTotal());
                    System.out.println("Reserva efetuada");
                    
                    
                    break;
                }
                case 2:{
                    System.out.print("\nOpção 'Listar Hospedes' Selecionado\n");
                    Hospede.listGuests();
                    break;
                }
                case 3:{
                    System.out.print("\nOpção 'Registrar Hospede' Selecionado\n");
                    Registrar();
                    break;
                }
                case 4:
                    Quarto.listRooms();
                    break; 
                case 5:
                    {
                        System.out.println("Digite a senha de administrador:");
                        Scanner input = new Scanner(System.in);
                        String keyword = input.nextLine();
                        if(!Funcionario.checkKeyword(keyword, admin.getKeyword())){
                            System.out.println("Senha invalida!\n");
                            break;
                        }   System.out.print("|-------------------------------|\n");
                        System.out.print("| Opção 1 - Mudar senha         |\n");
                        System.out.print("| Opção 2 - Criar Quarto        |\n");
                        System.out.print("| Opção 3 - Mudar nome Hotel    |\n");
                        System.out.print("| Opção 0 - Sair                |\n");
                        System.out.print("|-------------------------------|\n");
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
                                System.out.println("Qual numero de pessoas que voce deseja?");
                                int nRoom = input.nextInt();
                                input.nextLine();
                                hotel.createRoom(nRoom);
                                break;
                            case 3:
                                System.out.println("Digite o nome desejado");
                                String novoNome;
                                novoNome = input.nextLine();
                                hotel.setNome(novoNome);
                                
                            default:
                                break OUTER;
                        }
                    }
              
                default:
                    System.out.print("\nOpção Invalida!\n");
            }
        }
    }
    public static Hospede Registrar(){
        Hospede aux;
        Scanner input = new Scanner(System.in);
        System.out.print("Entre com o Nome do Hospede: \n");
        String name = input.nextLine();
        System.out.print("Entre com o CPF do Hospede: \n");
        String cpf = input.nextLine();
        while (!Pessoa.isCPF(cpf) || Hospede.cpfExistente(cpf)) {
            System.out.print("CPF ja existente ou invalido, tente novamente!\n");
            cpf = input.nextLine();
        }
        aux = Hospede.registerGuest(name, cpf);
        return aux;
    }
}

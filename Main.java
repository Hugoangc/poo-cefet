import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner menu = new Scanner(System.in);

        while (true) {

            System.out.print("##--Teste Estrutura de Menu--##\n\n");
            System.out.print("|-----------------------------|\n");
            System.out.print("| Opção 1 - Nova Reserva     |\n");
            System.out.print("| Opção 2 - Hospedes          |\n");
            System.out.print("| Opção 3 - Produtos          |\n");
            System.out.print("| Opção 4 - Sair              |\n");
            System.out.print("|-----------------------------|\n");
            System.out.print("Digite uma opção: ");

            int option = menu.nextInt();

            if (option == 4) {
                System.out.print("\nAté logo!");
                menu.close();
                break;
            }

            switch (option) {
                case 1 -> System.out.print("\nOpção Novo Cadastro Selecionado");
                case 2 -> System.out.print("\nOpção Clientes Selecionado\n");
                case 3 -> System.out.print("\nOpção Produtos Selecionado\n");
                default -> System.out.print("\nOpção Inválida!");
            }
        }
    }
}
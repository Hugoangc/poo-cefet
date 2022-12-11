import java.util.ArrayList;
import java.util.Scanner;

public class Funcionario extends Pessoa {
    private String keyword;
    private boolean isManager;
    private static final ArrayList<Funcionario> login = new ArrayList<>();

    public Funcionario(String nome, String CPF, String keyword){
        super(nome, CPF);
        setKeyword(keyword);
        isManager = true;
    }

    public Funcionario(String nome, String CPF) {
        super(nome, CPF);
    }

    public boolean promote(Funcionario f) {
        if (!getIsManager()) return false;
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o nome do funcionario: ");
        String name = input.next();
        super.setNome(name);
        System.out.println("Digite o CPF do funcionario: ");
        String cpf = input.next();
        super.setCPF(cpf);
        System.out.println("Digite a senha do funcionario: ");
        String keyword = input.next();
        this.setKeyword(keyword);
        login.add(f);
        return true;
    }

    public String getKeyword() {
        return keyword;
    }
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    public boolean getIsManager() {
        return isManager;
    }
    public void setIsManager(boolean isManager) {
        this.isManager = isManager;
    }
}

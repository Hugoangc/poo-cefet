package hotelpoo2;

import java.util.ArrayList;
import java.util.Scanner;

public class Funcionario extends Pessoa {
    private String keyword;
    private boolean isManager;
    private double salario;
    private static final ArrayList<Funcionario> login = new ArrayList<>();

    public Funcionario(String nome, String CPF, double salario, String keyword){
        super(nome, CPF);
        if(salario >= 0) this.salario = salario;
        else this.salario = 0;
        setKeyword(keyword);
        isManager = true;
    }

    public Funcionario(String nome, String CPF) {
        super(nome, CPF);
    }

    public boolean promote(Funcionario f) {
        if (!getIsManager()) return false;
        Scanner input = new Scanner(System.in);
        System.out.println("Digite a nova senha para o funcionario: ");
        String keyword = input.nextLine();
        this.setKeyword(keyword);
        //f.setIsManager(true);
        login.add(f);
        return true;
    }

    public double getSalario() {
        return salario;
    }

    public boolean setSalario(double salario) {
        if(isManager) {
            this.salario = salario;
            return true;
        }
        else return false;
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

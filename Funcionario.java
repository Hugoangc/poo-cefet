package hotelpoo2;

public class Funcionario extends Pessoa {
    private boolean eGerente = false;
    private double salario;
    private String senha;

    public Funcionario(String senha, double salario, String nome, String CPF) {
        super(nome, CPF);
        this.salario = salario;
        this.senha = senha;
    }


    public Funcionario(String nome, String CPF) {
        super(nome, CPF);
    }
    public boolean geteGerente() {
        return eGerente;
    }
    public void seteGerente(boolean eGerente) {
        this.eGerente = eGerente;
    }

    public double getSalario() {
        return salario;
    }

    public boolean setSalario(double salario) {
        if(geteGerente()) {
            this.salario = salario;
            return true;
        }
        else return false;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
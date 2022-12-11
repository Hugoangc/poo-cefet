public class Funcionario extends Pessoa {
    private boolean eGerente = false;

    public Funcionario(String nome, String CPF, String senha){
        super(nome, CPF);
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
}
package poo_final;
public class Funcionario extends Pessoa { 
    private String keyword;
    private boolean isManager;
    private double salario;

    public Funcionario(String nome, String CPF, String keyword){
        super(nome, CPF);
        this.salario = 7000;
        this.keyword = keyword;
        isManager = true;
    }

    public Funcionario(String nome, String CPF) {
        super(nome, CPF);
        this.salario = 4000;
    }
    public static Funcionario administrador(){
        return new Funcionario("admin", "64277075070", "admin");
    }
    public static boolean checkKeyword(String keyword, String keyword2){
        return keyword.equals(keyword2);
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
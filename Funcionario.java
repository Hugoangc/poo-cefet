import java.util.Date;
public class Funcionario extends Pessoa {
    private Double salario;
    private Date dataAdmissao;

    public Funcionario(Double salario){
    super(nome, email, CPF);
    if(salario>0) this.salario = salario;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }
}

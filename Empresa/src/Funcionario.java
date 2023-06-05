public class Funcionario {
    public String nome;
    public long cpf;
    public float salario;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public float calcularBonus(){
        return this.getSalario()*0.05f;
    }

    public Funcionario(String nome, long cpf, float salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
    }
}

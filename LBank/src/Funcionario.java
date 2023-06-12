public class Funcionario extends Pessoa{
    private long matricula;
    private long senha;

    public long getMatricula() {
        return matricula;
    }

    public void setMatricula(long matricula) {
        this.matricula = matricula;
    }

    public long getSenha() {
        return senha;
    }

    public void setSenha(long senha) {
        this.senha = senha;
    }

    public Funcionario(String nome, String sobreNome, long cpf, long matricula, long senha) {
        super(nome, sobreNome, cpf);
        this.matricula = matricula;
        this.senha = senha;
    }

}

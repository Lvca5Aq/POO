import java.math.BigInteger;

public abstract class Pessoa {
    public String nome;
    public String sobreNome;
    private long cpf;

    public Pessoa(String nome, String sobreNome, long cpf) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }
}

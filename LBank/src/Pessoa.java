import java.math.BigInteger;

public abstract class Pessoa {
    public String nome;
    public String sobreNome;
    private BigInteger cpf;

    public Pessoa(String nome, String sobreNome, BigInteger cpf) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.cpf = cpf;
    }
}

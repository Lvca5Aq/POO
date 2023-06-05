public class Pessoa {
    private String nome;
    private long cpf;
    private int anoDeNascimento;
    private double altura;

    public void status() {
        System.out.println("Nome: " + this.getNome());
        System.out.println("CPF: " + this.getCpf());
        System.out.println("Ano de Nascimento: " + this.getAnoDeNascimento());
        System.out.println("Altura: " + this.getAltura());
    }
    
    public void calculoDeIdade() {
        int idade = this.getAnoDeNascimento()-2023;
        System.out.println("O " + this.getNome() + " tem " + idade + "anos");
    }
    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCpf() {
        return this.cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public int getAnoDeNascimento() {
        return this.anoDeNascimento;
    }

    public void setAnoDeNascimento(int anoDeNascimento) {
        this.anoDeNascimento = anoDeNascimento;
    }

    public double getAltura() {
        return this.altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

}

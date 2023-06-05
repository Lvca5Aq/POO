public class Pessoa {
    public String nome;
    public int anoDeNascimento;
    public double peso;
    public double altura;

    public void mostra() {
        System.out.println(imc);
    }

    public void calculoDeImc() {
        double imc = this.getPeso()/(this.getAltura()*this.getAltura());
        System.out.println(imc);
    }
    public void calculoDeIdade() {
        int idade = 2023-this.getAnoDeNascimento();
        System.out.println(idade);
    }
    public void calculoDeQuantidadeDeAgua() {
        
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoDeNascimento() {
        return this.anoDeNascimento;
    }

    public void setAnoDeNascimento(int anoDeNascimento) {
        this.anoDeNascimento = anoDeNascimento;
    }

    public double getPeso() {
        return this.peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return this.altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

}

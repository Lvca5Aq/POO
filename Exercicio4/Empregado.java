public class Empregado {
    public String nome;
    public String sobrenome;
    private double salario;


    public Empregado(String nome, String sobrenome, double salario) {
        this.nome = "Lucas";
        this.sobrenome = "Aquino";
        this.salario = 1280;
    }
   
    public void forneceAumento() {
        this.setSalario(this.getSalario()*1.10);
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return this.sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public double getSalario() {
        return this.salario;
    }

    public void setSalario(double salario) {
        if(salario<0){
            this.salario=0;
        } else {
            this.salario = salario;
        }
    }

    @Override
    public String toString() {
        return "{" +
            " nome='" + getNome() + "'" +
            ", sobrenome='" + getSobrenome() + "'" +
            ", salario='" + getSalario() + "'" +
            "}";
    }

}

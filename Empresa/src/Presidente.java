public class Presidente extends Funcionario{
    private float quantidadeDeAçoes;

    public Presidente(String nome, long cpf, float salario, float quantidadeDeAçoes) {
        super(nome, cpf, salario);
        this.quantidadeDeAçoes = quantidadeDeAçoes;
    }

    @Override
    public float calcularBonus(){
        return this.getSalario()*0.10f;
    }
}

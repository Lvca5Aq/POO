public class Exercicio01 {
    public static void main(String[] args) {
        Pessoa p = new Pessoa();
        p.setAltura(1.60);
        p.setPeso(70);
        p.calculoDeImc();
        p.setAnoDeNascimento(2002);
        p.calculoDeIdade();
        p.mostra(imc);
    }
}

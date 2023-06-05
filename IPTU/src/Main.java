import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Imovel casa = new Imovel(1,"lucas",100,false,2002,10000 );
        //System.out.println(casa.calcularIptu());
        //System.out.println(casa.calcularValorDeVenda());
        //System.out.println(casa.calcularIdade(1950));
        //System.out.println(casa);
        Scanner prompt = new Scanner(System.in);
        System.out.println("Quantas imoveis voce quer cadastrar?");
        int n = prompt.nextInt();
        Imovel v[] = new Imovel[n];
        for (int i = 0;i <= n;i++){
            System.out.println("qual tipo?");
            int tipo = prompt.nextInt();
            System.out.println("quem eh o proprietario");
            String proprietario = prompt.nextLine();
            double tamanho = prompt.nextDouble();
            boolean nobre = prompt.nextBoolean();
            int ano = prompt.nextInt();
            double valor = prompt.nextDouble();
            v[i] = new Imovel(tipo,proprietario,tamanho,nobre,ano,valor);
            System.out.println(v[i]);
        }
    }
}
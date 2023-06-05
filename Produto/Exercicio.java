import java.util.ArrayList;
import java.util.Scanner;

public class Exercicio {
    public static void main(String[] args) {
        char x = "s";
        Scanner leia = new Scanner(System.in);
        ArrayList<Produto> lista = new ArrayList<Produto>();
        do {
            System.out.println("Digite o codigo do produto");
            String c = leia.next();
            System.out.println("Digite o peso do produto");
            Double p = leia.nextDouble();
            System.out.println("Digite o preço do produto");
            Double pr = leia.nextDouble();
            Produto t = new Produto(c,p,pr);
            lista.add(t);
            System.out.println("Deseja adicionar mais algum produto?(Digite s ou S)");
            x = leia.next().charAt(0);
        }while(x == "S" || x == "s")
    }
}

import java.util.Scanner;

public class media { 
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double soma=0, nota=0;
        for(int x=0;x<3;x++){
            if(x==0){
                System.out.println("Qual foi a primeira nota?");
            } if(x==1) {
                System.out.println("Qual foi a segunda nota?");
            } if(x==2) {
                System.out.println("Qual foi a terceira nota?");
            }
            nota = in.nextDouble();
            soma = soma + nota;
            nota=0;
        }
        double media = soma/3;
        if(media<7){
            System.out.println("O aluno esta reprovado com uma media de " + media);
        } else {
            System.out.println("O aluno esta aprovado com uma media de " + media);
        }
    }
}

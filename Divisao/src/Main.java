import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int w =0;
        while (w==0){
            try {
                Scanner scan = new Scanner(System.in);
                int x = scan.nextInt();
                int y = scan.nextInt();
                System.out.println(x/y);
                w = 1;
            } catch (InputMismatchException e){
                System.out.println("voce digitou uma letra, tente novamente");
            } catch (ArithmeticException e){
                System.out.println("voce digitou uma divisao por zero, tente novamente");
            }
        }
    }
}
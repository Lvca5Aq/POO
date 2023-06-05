import java.util.InputMismatchException;
import java.util.Scanner;

public class Divisao {
    public void fazerDivisao(){
        int w = 1;
        while (w == 1){
            try {
                Scanner scan = new Scanner(System.in);
                float x = scan.nextFloat();
                float y = scan.nextFloat();
                System.out.println(x/y);
            } catch (InputMismatchException e){
                System.out.println("voce digitou uma letra");
            }
        }
    }

}

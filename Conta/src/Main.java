// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Cliente Lucas = new Cliente(62659406,"Travessa");
        Conta CLucas = new Conta(Lucas,185.10f);
        System.out.println(Lucas);
        System.out.println(CLucas);
        Operaçao n = new Operaçao("r",200f);
        CLucas.fazOperaçao(n);
        System.out.println(CLucas);
    }
}
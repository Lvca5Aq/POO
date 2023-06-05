// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Funcionario lucas = new Funcionario("Lucas",62659406359l,1300f);
        Presidente lara = new Presidente("Lara",62659406359l,3000f,50f);
        System.out.println(lucas.calcularBonus());
        System.out.println(lara.calcularBonus());
    }
}
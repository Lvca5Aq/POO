// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Estudante lucas = new Estudante();
        System.out.println(lucas.valorCopia(10));
        Bolsista lara = new Bolsista();
        lara.setBolsa(500);
        System.out.println(lara.quantMaxDeCopias());
    }
}
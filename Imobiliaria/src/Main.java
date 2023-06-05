import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Imovel> imovels = new ArrayList<Imovel>();
        Casa casa = new Casa();
        imovels.add(casa);
        casa.setValorDeCompra(1000);
        Imobiliaria aquino = new Imobiliaria();
        System.out.println(aquino.quantDeApart(imovels));
        System.out.println(aquino.mediaDeCompra(imovels));
    }}

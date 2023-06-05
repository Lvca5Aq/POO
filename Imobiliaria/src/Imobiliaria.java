import java.util.ArrayList;

public class Imobiliaria {
    ArrayList<Imovel> imovels;
    public float mediaDeCompra(ArrayList<Imovel> x){
        float acumulador = 0;
        for (int i=0;i<x.size();i++){
            acumulador = acumulador + x.get(i).getValorDeCompra();
        }
        return acumulador/x.size();
    }

    public int quantDeCasas(ArrayList<Imovel> x){
        int acumulador = 0;
        for (int i=0;i<x.size();i++){
            if (x.get(i) instanceof Casa){
                acumulador++;
            }
        }
        return acumulador;
    }

    public int quantDeApart(ArrayList<Imovel> x){
        int acumulador = 0;
        for (int i=0;i<x.size();i++){
            if (x.get(i) instanceof Apartamento){
                acumulador++;
            }
        }
        return acumulador;
    }

    public Imovel imovelMaisTop(ArrayList<Imovel> x){
        float comparador = 0;
        Imovel y = null;
        for (int i=0;i<x.size();i++){
            if (comparador<x.get(i).getValorDeCompra()){
                comparador=x.get(i).getValorDeCompra();
                y = x.get(i);
            }
        }
        return y;
    }
}

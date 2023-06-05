import java.lang.reflect.Array;
import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Preguiça lulu   = new Preguiça();
        Cachorro zaza   = new Cachorro();
        Animal viper    = new Animal();
        viper.idade     = 18;
        zaza.idade      = 47;
        lulu.idade      = 85;
        System.out.println(zaza.emitirSom());
        System.out.println(lulu.emitirSom());

        ArrayList<Animal> animais = new ArrayList<Animal>();
        animais.add(zaza);
        animais.add(lulu);
        animais.add(viper);

        int acumulador=0;
        int somaDasIdades=0;
        for (int i = 0;i<animais.size();i=i+1){
            if (animais.get(i) instanceof Cachorro || animais.get(i) instanceof Preguiça){
                acumulador=acumulador+1;
                somaDasIdades=somaDasIdades+animais.get(i).idade;
            }

        }
        System.out.println(somaDasIdades/acumulador);

    }
}
public class Bolsista extends Estudante{
    private float bolsa;

    public float getBolsa() {
        return bolsa;
    }

    public void setBolsa(float bolsa) {
        this.bolsa = bolsa;
    }

    public int quantMaxDeCopias(){
        return Math.round(this.getBolsa()/0.07f);
    }

    @Override
    public float valorCopia(int x){
        return x*0.07f;
    }
}

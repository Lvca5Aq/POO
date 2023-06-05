public class Apartamento extends Imovel{
    private boolean piscina;

    public boolean isPiscina() {
        return piscina;
    }

    public void setPiscina(boolean piscina) {
        this.piscina = piscina;
    }
    @Override
    public float calcularValorDeVenda(){
        if (this.getArea()>300 && isPiscina()==true){
            return this.getValorDeCompra()*1.5f;
        } else {
            return this.getValorDeCompra()*1.1f;
        }
    }
}

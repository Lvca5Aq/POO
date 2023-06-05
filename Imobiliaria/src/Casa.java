public class Casa extends Imovel{
    private boolean quintal;

    public boolean isQuintal() {
        return quintal;
    }

    public void setQuintal(boolean quintal) {
        this.quintal = quintal;
    }
    @Override
    public float calcularValorDeVenda(){
        if (this.getQuantDeQuartos()>4 || isQuintal()==true){
            return this.getValorDeCompra()*1.3f;
        } else {
            return this.getValorDeCompra()*1.15f;
        }
    }
}

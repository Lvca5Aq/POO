public class Imovel {
    private float area;
    private int quantDeQuartos;
    private float valorDeCompra;

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public int getQuantDeQuartos() {
        return quantDeQuartos;
    }

    public void setQuantDeQuartos(int quantDeQuartos) {
        this.quantDeQuartos = quantDeQuartos;
    }

    public float getValorDeCompra() {
        return valorDeCompra;
    }

    public void setValorDeCompra(float valorDeCompra) {
        this.valorDeCompra = valorDeCompra;
    }

    public float calcularValorDeVenda(){
        if (this.getArea()>400){
            return this.getValorDeCompra()*1.4f;
        } else {
            return this.getValorDeCompra()*1.05f;
        }
    }
}

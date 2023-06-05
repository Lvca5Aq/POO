public class Operaçao {
    private String tipo;
    private float valor;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public Operaçao(String tipo, float valor) {
        this.tipo = tipo;
        this.valor = valor;
    }
}

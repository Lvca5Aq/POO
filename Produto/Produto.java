public class Produto {
    public String codigo;
    public double peso;
    public double preço; 

    public void mostra() {
        System.out.println(this.getCodigo());
        System.out.println(this.getPeso());
        System.out.println(this.getPreço());
    }

    public Produto(String n, double i, double p) {
        this.setCodigo(n);
        this.setPeso(i);
        this.setPreço(p);
    }
    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPeso() {
        return this.peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getPreço() {
        return this.preço;
    }

    public void setPreço(double preço) {
        this.preço = preço;
    }


}

import java.util.Scanner;

public class Imovel {
    public int tipo;
    private String proprietario;
    public double tamanho;
    public boolean nobre;
    private int dataDeCompra;
    private double valorDeCompra;

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public double getTamanho() {
        return tamanho;
    }

    public void setTamanho(double tamanho) {
        this.tamanho = tamanho;
    }

    public boolean isNobre() {
        return nobre;
    }

    public void setNobre(boolean nobre) {
        this.nobre = nobre;
    }

    public int getDataDeCompra() {
        return dataDeCompra;
    }

    public void setDataDeCompra(int dataDeCompra) {
        this.dataDeCompra = dataDeCompra;
    }

    public double getValorDeCompra() {
        return valorDeCompra;
    }

    public void setValorDeCompra(double valorDeCompra) {
        this.valorDeCompra = valorDeCompra;
    }

    public Imovel(int tipo, String proprietario, double tamanho, boolean nobre, int dataDeCompra, double valorDeCompra) {
        this.tipo = tipo;
        this.proprietario = proprietario;
        this.tamanho = tamanho;
        this.nobre = nobre;
        this.dataDeCompra = dataDeCompra;
        this.valorDeCompra = valorDeCompra;
    }
    public double calcularIptu(){
        if (this.getTipo()==2){
            if (this.getTamanho()>100){
               return this.getValorDeCompra()*0.05;
            } else if (this.getTamanho()<=100) {
                return this.getValorDeCompra()*0.02;
            }
        } else if (this.getTipo()==1) {
            if (this.getTamanho()>100){
                return this.getValorDeCompra()*0.03;
            } else if (this.getTamanho()<=100) {
                return this.getValorDeCompra()*0.01;
            }
        }
        return 0;
    }
    public double calcularValorDeVenda(){
        if (this.isNobre()){
            if (this.getTamanho()>100){
                return this.getValorDeCompra()*1.80;
            } else if (this.getTamanho()<=100) {
                return this.getValorDeCompra()*1.10;
            }
        } else if (!this.isNobre()) {
            if (this.getTamanho()>100){
                return this.getValorDeCompra()*1.20;
            } else if (this.getTamanho()<=100) {
                return this.getValorDeCompra()*1.05;
            }
        }
        return 0;
    }
    public int calcularIdade(int x){
        return getDataDeCompra()-x;
    }

    @Override
    public String toString() {
        return "Imovel{" +
                "tipo=" + tipo +
                ", proprietario='" + proprietario + '\'' +
                ", tamanho=" + tamanho +
                ", nobre=" + nobre +
                ", dataDeCompra=" + dataDeCompra +
                ", valorDeCompra=" + valorDeCompra +
                '}';
    }
}

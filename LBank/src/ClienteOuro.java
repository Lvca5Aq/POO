import java.math.BigInteger;

public class ClienteOuro extends Cliente{
    public float taxa;
    private float credito;
    private float divida;


    public float getTaxa() {
        return taxa;
    }

    public void setTaxa(float taxa) {
        this.taxa = taxa;
    }

    public float getCredito() {
        return credito;
    }

    public void setCredito(float credito) {
        this.credito = credito;
    }

    public float getDivida() {
        return divida;
    }

    public void setDivida(float divida) {
        this.divida = divida;
    }

    public ClienteOuro(String nome, String sobreNome, BigInteger cpf, float saldo, long senha) {
        super(nome, sobreNome, cpf, saldo, senha);
        this.taxa = 0.025f;
        this.credito = saldo*4f;
        this.divida = 0;
    }

    @Override
    public String fazerSaque(float s) throws Exceções.limiteSuperado {
        float T = s*this.getTaxa();
        this.setLimiteDeSaque(this.getSaldo()*0.25f);
        if(s>this.getLimiteDeSaque()) {
            throw new Exceções.limiteSuperado("O limite de saque foi superado");
        }else if(s>this.getSaldo()+T){
            throw new Exceções.limiteSuperado("O valor do saque ultrapassa o valor do saldo mas a taxa");
        }else {
            this.setSaldo(s+T-this.getSaldo());
            return "Saque feito com sucesso seu novo saldo é: " + this.getSaldo() + " R$";
        }
    }
    @Override
    public String CompraCartao(float s) throws Exceções.limiteSuperado {
        float T = s*this.getTaxa();
        if(s+T>this.getSaldo()+this.getCredito()){
            throw new Exceções.limiteSuperado("O valor da compra ultrapassa o valor do saldo");
        }else if(s+T<this.getSaldo()){
            this.setSaldo(s+T-this.getSaldo());
            return "Compra feita com sucesso seu novo saldo é: " + this.getSaldo() + " R$";
        } else {
            this.setDivida(-1*(this.getSaldo()-(s+T)));
            this.setSaldo(0);
            return "Compra feita com cartao de credito seu novo saldo é: " + this.getSaldo() + " R$ e uma divida de " + this.getDivida() + " R$";
        }
    }
}
